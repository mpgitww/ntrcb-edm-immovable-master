package com.ntrcb.immovable.service.imp;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.ntrcb.common.constant.ReturnResult;
import com.ntrcb.common.mapper.IOfficePushMapper;
import com.ntrcb.common.util.Base64Util;
import com.ntrcb.common.util.ParamUtil;
import com.ntrcb.common.util.S3Util;
import com.ntrcb.immovable.entity.Immovable.model.HttpHeadModel;
import com.ntrcb.immovable.entity.PushEntity;
import com.ntrcb.immovable.entity.XmidEntity;
import com.ntrcb.immovable.entity.immovableToProvince.req.*;
import com.ntrcb.immovable.service.EsbService;
import com.ntrcb.immovable.service.ImmovableToProvinceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 不动产
 */
@Service
@Slf4j
public class ImmovableToProvinceServiceImpl implements ImmovableToProvinceService {

    @Resource
    private EsbService esbService;

    @Resource
    private IOfficePushMapper iOfficePushMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Value("${property.url.sendNoticeUrl}")
    private  String sendNoticeUrl;

    @Value("${property.url.tokenUrl}")
    private  String tokenUrl;

    @Value("${property.url.encryptUrl}")
    private  String encryptUrl;

    @Value("${property.url.bdcfyxxUrl}")
    private  String bdcfyxxUrl;

    @Value("${property.url.dydjUrl}")
    private  String dydjUrl;

    @Value("${property.url.dyzxUrl}")
    private  String dyzxUrl;

    @Value("${property.url.zzjsUrl}")
    private  String zzjsUrl;

    @Value("${property.url.zzwjxzurl}")
    private  String zzwjxzurl;

    @Value("${property.url.tsWwsqFjxxUrl}")
    private  String tsWwsqFjxxUrl;

//    @Resource
    private S3Util s3Util;

//    @Value("${aws.s3-config.bucket}")
    private String bucketName;

    @Value("${property.file.localpath}")
    private String localpath;

    @Override
    public JSONObject queryLoanList(LoanAgoQueryEq loanAgoQueryEq) {
        JSONObject result = new JSONObject();
        try {
            String url = bdcfyxxUrl;
            HttpHeadModel token = getToken();
            JSONObject resJson = esbService.sendPostByJson(url, token, requestCx(loanAgoQueryEq));
            JSONObject resMap = dealResponseCx(resJson);
            ReturnResult returnResult = getResData(resJson);
            System.out.println("返回参数:" + returnResult);
            result.set("status", "100");
            result.set("msg", returnResult.getMessage());
            result.set("data", resMap);
            result.set("code", returnResult.getCode());
            if(!resMap.isEmpty()){
                //将项目id存入表中
                XmidDTO dto = new XmidDTO();
                dto.setCqzh(loanAgoQueryEq.getBzcqzh());
                dto.setXmid(resMap.getStr("xmid"));
                List<XmidEntity> xmidEntities = iOfficePushMapper.queryXmidhList(dto);
                if(null==xmidEntities || xmidEntities.size()==0){
                    iOfficePushMapper.insertXmid(dto);
                }
            }else{
                result.set("status","-1");
                result.set("msg","请求参数错误，未查询到项目id");
                result.set("data","");
                result.set("code","-1");
            }

        } catch (Exception e) {
            result.set("status", "-1");
            result.set("msg", e.getMessage());
            result.set("data", "");
            result.set("code", "-1");

        }

        return result;
    }

    @Override
    public JSONObject pledgeRegister(PledgeRegisterEq pledgeRegisterEq) {
        log.info("不动产-抵押登记创建开始");
        JSONObject result = new JSONObject();
        System.out.println(pledgeRegisterEq);
        //采用异步方式 处理附件及创建功能
        threadPoolTaskExecutor.execute(() -> {
            dealRequestDydjcj(pledgeRegisterEq);
        });

        result.set("status","100");
        result.set("msg","抵押登记创建处理中");
        return result;
    }

    @Override
    public JSONObject pledgeWriteOffRegister(PledgeWriteOffRegisterEq pledgeWriteOffRegisterEq) {
        log.info("不动产-抵押注销开始");
        JSONObject result = new JSONObject();
        //采用异步方式 处理附件及创建功能
        threadPoolTaskExecutor.execute(() -> {
            dealRequestDyzxcj(pledgeWriteOffRegisterEq);
        });

        result.set("status",100);
        result.set("msg","抵押注销创建处理中");
        return result;
    }


    @Override
    public JSONObject planPushBdc(PlanPushBdcEq planPushBdcEq) {
        log.info("不动产-办件进度推送");
        JSONObject result = new JSONObject();
        try {
            //先查询有没有
            PlanQueryegisterEq planQueryegisterEq = new PlanQueryegisterEq();
            planQueryegisterEq.setSlbh(planPushBdcEq.getCenterNumber());
            planQueryegisterEq.setQydm(planPushBdcEq.getXzqdm());
            result.set("slbh", planPushBdcEq.getCenterNumber());
            List<PushEntity> pushEntities = iOfficePushMapper.queryOfficePushList(planQueryegisterEq);
            if(null == pushEntities || pushEntities.size()==0){
                Integer integer = iOfficePushMapper.insertPush(planPushBdcEq);
                if (1 != integer) {
                    result.set("result", "2");
                    result.set("status","-1");
                    result.set("message", "推送失败");
                    return result;
                }
            }else{
                Integer integer = iOfficePushMapper.updatePush(planPushBdcEq);
                if (1 != integer) {
                    result.set("result", "2");
                    result.set("status","-1");
                    result.set("message", "推送失败");
                    return result;
                }
            }

            result.set("result", "1");
            result.set("status","100");
            result.set("message", "推送成功");
        } catch (Exception e) {
            result.set("result", "2");
            result.set("message", e.getMessage());
        }
        return result;
    }


    @Override
    public JSONObject queryPlanPushBdc(PlanQueryegisterEq planQueryegisterEq) {
        JSONObject result = new JSONObject();
        try {
            List<PushEntity> pushEntities = iOfficePushMapper.queryOfficePushList(planQueryegisterEq);
            PushEntity pushEntity = new PushEntity();
            if (CollectionUtils.isNotEmpty(pushEntities)) {
                pushEntity = pushEntities.get(0);
            }
            result.set("status", "100");
            result.set("code", "000000");
            result.set("msg", "查询成功");
            result.set("bjzt", pushEntity.getBjzt());
            result.set("slbh", pushEntity.getSlbh());
            result.set("dyzmh",pushEntity.getDyzmh());
        } catch (Exception e) {
            result.set("status", "-1");
            result.set("msg", e.getMessage());
            result.set("code", "-1");
        }
        return result;
    }

    @Override
    public JSONObject queryCertIdBdc(CertIdBdcQueryEq certIdBdcQueryEq) {
        JSONObject result = new JSONObject();
        try {
            String url = zzjsUrl;
            HttpHeadModel token = getToken();
            JSONObject requestDzzzxxcx = requestDzzzxxcx(certIdBdcQueryEq);
            JSONObject resMap = esbService.sendPostByJson(url, token, requestDzzzxxcx);
            ReturnResult resData = getResData(resMap);
//            if (!"0000".equals(resData.getCode())) {
//                result.set("msg", "调用不动产证件号查询失败");
//                result.set("status", "-1");
//                result.set("code", resData.getCode());
//                return result;
//            }


            JSONArray jsonArray = resMap.getJSONArray("data");
            if (CollectionUtils.isNotEmpty(jsonArray)) {
                JSONObject jb = (JSONObject) jsonArray.get(0);
                JSONObject down = new JSONObject();
                down.set("zzbs", jb.getStr("zzbs"));
                down.set("xzqdm", certIdBdcQueryEq.getQydm());
                result = certDown(down);

            } else {
                result.set("msg", "电子证照信息为空");
                result.set("status", "-1");
                result.set("code", "-1");

            }
        } catch (Exception e) {
            result.set("status", "100");
            result.set("msg", e.getMessage());
            result.set("data", "");
        }
        return result;
    }

    /**
     * 一个接口形式
     * @param pledgeRegisterEq
     */
    private void dealRequestDydjcj(PledgeRegisterEq pledgeRegisterEq){
        JSONObject result = new JSONObject();
        try {
            String url = dydjUrl;
            HttpHeadModel token = getToken();
            JSONArray jsonArray = new JSONArray();
            JSONObject djJson = repalceParamCx(pledgeRegisterEq);
            jsonArray.add(djJson);
            setFjxx(djJson);
            JSONObject resMap = esbService.sendPostForListByJson(url, token, jsonArray);
            ReturnResult<JSONObject> resData = getResData(resMap);

            if ("0000".equals(resData.getCode())) {
                String slbh = (String) resData.getData().get("slbh");
                log.info("不动产-抵押登记创建-slbh:{}",slbh);

                result.set("msg","success");
                result.set("code","000000");
                result.set("bjbh", pledgeRegisterEq.getBjbh());
                result.set("slbh",slbh);
                result.set("type", "1");
                log.info("不动产-抵押登记创建-成功:"+resData.getMessage());

            }else{
                result.set("msg","fail");
                result.set("code","999999");
                result.set("bjbh", pledgeRegisterEq.getBjbh());
                result.set("type", "1");
                log.info("不动产-抵押登记创建-失败:"+resData.getMessage());
            }
            //通知展业
            log.info("不动产-抵押登记创建-上传附件完成-通知展业参数{}",result);
            JSONObject sendRes = esbService.sendZhanye(sendNoticeUrl, result);
            log.info("不动产-抵押登记创建-上传附件完成-通知展业结果{}",sendRes.toString());
        } catch (Exception e) {
            log.error("不动产-抵押登记创建-报错:{}",e.getMessage());
        }
    }

    /**
     * 2023-09-07
     * 由于国图方 不接受两个接口做抵押登记的方式
     * 暂时换成一个接口形式
     * @param pledgeRegisterEq
     */
    private void dealRequestDydjcj2(PledgeRegisterEq pledgeRegisterEq){
        JSONObject result = new JSONObject();
        try {
            String url = dydjUrl;
            HttpHeadModel token = getToken();
            JSONArray jsonArray = new JSONArray();
            JSONObject djJson = repalceParamCx(pledgeRegisterEq);
            //原方案1:根据fileurl处理fj参数 设置fjxx到请求参数
//            setFjxx(djJson);

            jsonArray.add(djJson);
            JSONObject resMap = esbService.sendPostForListByJson(url, token, jsonArray);
            ReturnResult<JSONObject> resData = getResData(resMap);
            if ("0000".equals(resData.getCode())) {
//                result.set("msg", resData.getMessage());
                result.set("msg", "抵押登记创建处理中");
//                result.set("slbh", resData.getData().get("slbh"));

                //新方案2:根据fileurl调用上传附件接口
                String slbh = (String) resData.getData().get("slbh");
                djJson.set("slbh",slbh);
                log.info("不动产-抵押登记创建-slbh:{}",slbh);
                uploadFjxx4Dydj(djJson);


            } else {
                result.set("msg", resData.getData().get("msg"));
                result.set("slbh", "");
            }
            result.set("status", "100");
            result.set("code", resData.getCode());
        } catch (Exception e) {
            result.set("status", "-1");
            System.out.println(e);
            result.set("msg", e.getMessage());
            result.set("data", "");
            result.set("code", "-1");
        }
    }

    /**
     *2023-09-07
     *  一个接口传附件形式
     * @param pledgeWriteOffRegisterEq
     */
    private void dealRequestDyzxcj(PledgeWriteOffRegisterEq pledgeWriteOffRegisterEq){
        repalceParamDyzxcj(pledgeWriteOffRegisterEq);
        JSONObject result = new JSONObject();
        try {
            String url = dyzxUrl;
            HttpHeadModel token = getToken();
            JSONArray jsonArray = new JSONArray();
            JSONObject djzxJson = repalceParamDyzxcj(pledgeWriteOffRegisterEq);
            jsonArray.add(djzxJson);
            setFjxx4Dyzx(djzxJson);
            JSONObject resMap = esbService.sendPostForListByJson(url, token, jsonArray);
            ReturnResult<JSONObject> resData = getResData(resMap);

            if ("0000".equals(resData.getCode())) {
                String slbh = (String) resData.getData().get("slbh");
                log.info("不动产-抵押注销-slbh:{}",slbh);

                result.set("msg","success");
                result.set("code","000000");
                result.set("bjbh", pledgeWriteOffRegisterEq.getBjbh());
                result.set("slbh",slbh);
                result.set("type", "2");
                log.info("不动产-抵押注销-成功:"+resData.getMessage());

            }else{
                result.set("msg","fail");
                result.set("code","999999");
                result.set("bjbh", pledgeWriteOffRegisterEq.getBjbh());
                result.set("type", "2");
                log.info("不动产-抵押注销-失败:"+resData.getMessage());
            }
            //通知展业
            log.info("不动产-抵押注销-上传附件完成-通知展业参数{}",result);
            JSONObject sendRes = esbService.sendZhanye(sendNoticeUrl, result);
            log.info("不动产-抵押注销-上传附件完成-通知展业结果{}",sendRes.toString());

        } catch (Exception e) {
            log.error("不动产-抵押注销-报错:{}",e.getMessage());
        }

    }

    /**
     * 2023-09-07
     * 两个接口形式暂时不用了
     * @param pledgeWriteOffRegisterEq
     */
    private void dealRequestDyzxcj2(PledgeWriteOffRegisterEq pledgeWriteOffRegisterEq){
        repalceParamDyzxcj(pledgeWriteOffRegisterEq);
        JSONObject result = new JSONObject();
        try {
            String url = dyzxUrl;
            HttpHeadModel token = getToken();
            JSONArray jsonArray = new JSONArray();
            JSONObject djzxJson = repalceParamDyzxcj(pledgeWriteOffRegisterEq);
            jsonArray.add(djzxJson);
            JSONObject resMap = esbService.sendPostForListByJson(url, token, jsonArray);
            ReturnResult<JSONObject> resData = getResData(resMap);
            if ("0000".equals(resData.getCode())) {
                result.set("msg", resData.getMessage());
                result.set("slbh", resData.getData().get("slbh"));
                result.set("status", "100");
                result.set("code", resData.getCode());
                //判断附件是否为空
                if (StringUtils.isEmpty(pledgeWriteOffRegisterEq.getFileUrl())){
                    return ;
                }
                String slbh = result.getStr("slbh");
                djzxJson.set("slbh",slbh);
                log.info("不动产-抵押注销-slbh:{}",slbh);
                JSONObject result1 = uploadFjxx4Dyzx(djzxJson);
                if ("999999".equals(result1.getStr("code"))){
                    result.set("status","-1");
                    result.set("msg",result1.getStr("msg"));
                    result.set("code","999999");
                    result.set("bjbh", result1.getStr("bjbh"));
                }

            } else {
                result.set("msg", resData.getData().get("msg"));
                result.set("slbh", "");
            }

        } catch (Exception e) {
            result.set("status", "-1");
            result.set("msg", e.getMessage());
            result.set("data", "");
            result.set("code", "-1");
        }

    }

    public JSONObject certDown(JSONObject jsonObject) throws Exception {
        JSONObject result = new JSONObject();
        String url = zzwjxzurl;
        HttpHeadModel token = getToken();
        JSONObject resMap = esbService.sendPostByJson(url, token, jsonObject);
        ReturnResult resData = getResData(resMap);
        if (!"0000".equals(resData.getCode())) {
            result.set("msg", resData.getMessage());
            result.set("status", "-1");
            result.set("code", resData.getCode());
            return result;
        }
        result.set("msg", resData.getMessage());

        result.set("status", "100");
        result.set("code", resData.getCode());
        //上传文件到s3
        String fileUrl = uploadS3(resMap.getJSONObject("data").getStr("content"));
//        String fileUrl = "http://test";
//        String fileUrl = Base64Util.encryptBASE64(s.getBytes(StandardCharsets.UTF_8));
        result.set("content",  Base64Util.encryptBASE64(fileUrl.getBytes(StandardCharsets.UTF_8)));

        return result;
    }

    /**
     * 获取token
     *
     * @return
     */
    private HttpHeadModel getToken() {
        String telphone =  "18021659209";
        HttpHeadModel headModel = new HttpHeadModel();
        String url = tokenUrl;
        Map<String, Object> headMap = new HashMap<>();
        Map<String, Object> dataMap = new HashMap<>();
        String token = redisTemplate.opsForValue().get("token:" +telphone);
        if (StringUtils.isNotEmpty(token)) {
            headModel.setAccess_token(token);
        } else {
            dataMap.put("lxDh", telphone);
//        测试
//            dataMap.put("userPwd", getPassword("Ntnsh123456"));
            //生产
            dataMap.put("userPwd", getPassword("Aa123456"));
            dataMap.put("loginType", "organize");

            Map<String, Object> resMap = esbService.sendPost(url, headMap, dataMap);
            //判断head是否存在
            if (resMap.containsKey("head")) {
                Map<String, Object> resTokenMap = (Map<String, Object>) resMap.get("head");
                //是否返回token
                if (resTokenMap.containsKey("access_token")) {
                    redisTemplate.opsForValue().set("token:" + telphone, resTokenMap.get("access_token").toString(), 25, TimeUnit.MINUTES);
                    headModel.setAccess_token(resTokenMap.get("access_token").toString());
                    headModel.setSign(resTokenMap.get("sign").toString());
                }
            }
        }
        headModel.setQydm("320600");
        //测试
//        headModel.setUserId("b63527dbff7d45b29658c96b6cc2d7b7");
        //生产
        headModel.setUserId("196a1abfefa14413ada054f9ad188170");
        return headModel;
    }

    /**
     * 获取加密后的密码
     *
     * @return
     */
    private String getPassword(String password) {
        String encodeValue = "";
        String url = encryptUrl;
        Map<String, Object> headMap = new HashMap<>();
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("encodeKey", password);
        Map<String, Object> resMap = esbService.sendPost(url, headMap, dataMap);
        //判断data是否存在
        if (resMap.containsKey("data")) {
            Map<String, Object> resPasswordMap = (Map<String, Object>) resMap.get("data");
            //是否返回token
            if (resPasswordMap.containsKey("encodeValue")) {
                encodeValue = resPasswordMap.get("encodeValue").toString();
            }
        }
        return encodeValue;
    }


    public JSONObject requestDzzzxxcx(CertIdBdcQueryEq certIdBdcQueryEq) {
        JSONObject requestBody = new JSONObject();
        requestBody.set("bdcqzh", certIdBdcQueryEq.getBdctxzmh());
        requestBody.set("xzqdm", certIdBdcQueryEq.getQydm());
        requestBody.set("zzlxdm", "11100000MB03271699022");
        return requestBody;
    }


    /**
     * 贷前查询请求字段转换字段转换
     *
     * @param loanAgoQueryEq
     * @return
     */
    private JSONObject requestCx(LoanAgoQueryEq loanAgoQueryEq) {
        JSONObject result = new JSONObject();
        result.set("cqzh", loanAgoQueryEq.getBzcqzh());
        result.set("qlrmc", loanAgoQueryEq.getQlrName());
        result.set("xzqdm", loanAgoQueryEq.getQydm());
        return result;
    }

    /**
     * 贷前查询返回字段转换
     *
     * @param jsonObject
     * @return
     */
    private JSONObject dealResponseCx(JSONObject jsonObject) {
        JSONObject result = new JSONObject();
        if (jsonObject.getJSONObject("data") == null || jsonObject.getJSONObject("data").size() < 1) {
            return result;
        }
        JSONArray array = jsonObject.getJSONObject("data").getJSONArray("qlxx");
        for (Object o : array) {
            JSONObject r = (JSONObject) o;
            result.set("xmid", r.get("xmid"));
            result.set("bzcqzh", r.get("bdcqzh"));
            result.set("bdcdyh", r.get("bdcdyh"));
            result.set("bdcdybh",r.get("bdcdywybh"));
            result.set("zl",r.get("zl"));
            result.set("fjh","");
            result.set("dh","");
            result.set("djsj","");
            result.set("djlx","");
            result.set("qszt","");
            //权利人信息适配
            JSONArray qlrList = new JSONArray();
            JSONArray qlrArray = r.getJSONArray("qlr");
            for (Object ob : qlrArray) {
                JSONObject qlr = (JSONObject) ob;
                JSONObject qlrJson = new JSONObject();
                qlrJson.set("qlrName", qlr.get("qlrmc"));
                qlrJson.set("qlrCertType", qlr.get("zjzl"));
                qlrJson.set("qlrCertId", qlr.get("zjh"));
                qlrJson.set("gyfs", qlr.get("gyfs"));
                qlrJson.set("gybl", qlr.get("qlbl"));
                qlrJson.set("qlrPhone", qlr.get("dh"));
                qlrList.add(qlrJson);
            }
            result.set("qlr", qlrList);
            result.set("ygzmh", "");
            //判断是否查询
            JSONArray cfxxArray = r.getJSONArray("cfxx");
            if (cfxxArray != null && cfxxArray.size() > 0) {
                result.set("cfzt", "是");
            } else {
                result.set("cfzt", "否");
            }
            //判断是否抵押
            JSONArray dyxxArray = r.getJSONArray("dyxx");
            if (dyxxArray != null && dyxxArray.size() > 0) {
                result.set("dyzt", "是");
            } else {
                result.set("dyzt", "否");
            }
            //判断异议状态
            JSONArray yyxxArray = r.getJSONArray("yyxx");
            if (yyxxArray != null && yyxxArray.size() > 0) {
                result.set("yyzr", "是");
            } else {
                result.set("yyzr", "否");
            }
            result.set("jzmj", r.get("jzmj"));
            result.set("tnmj", "");
            result.set("sjc", r.get("szc"));
            result.set("zcs", r.get("zcs"));
            result.set("fwjg", r.get("fwjg"));
            result.set("fwxz", r.get("fwxz"));
            result.set("fwlx", "");
            result.set("ghyt", "");
            result.set("jgsj", r.get("jgsj"));
            result.set("tdsymj", "");
            result.set("tdqllx", "");
            result.set("tdqlxz", "");
            result.set("xzqhdm", r.get("qxdm"));
            result.set("gltdzxx", "");
            //判断锁定状态
            JSONArray sdxxArray = r.getJSONArray("sdxx");
            if (sdxxArray != null && sdxxArray.size() > 0) {
                result.set("sdzt", "是");
            } else {
                result.set("sdzt", "否");
            }
            break;
        }

        return result;
    }


    /**
     * 抵押登记创建码值替换
     *
     * @param pledgeRegisterEq
     * @return
     */
    private JSONObject repalceParamCx(PledgeRegisterEq pledgeRegisterEq) {
        JSONObject jsonObject = new JSONObject(pledgeRegisterEq);
        //是否需要云签
        jsonObject.set("sfxyyq","false");
        XmidDTO dto = new XmidDTO();
        dto.setCqzh(pledgeRegisterEq.getCqzh());
        List<XmidEntity> xmidEntities = iOfficePushMapper.queryXmidhList(dto);
        if(null!=xmidEntities && xmidEntities.size()>0){
            XmidEntity entity = xmidEntities.get(0);
            log.info("不动产-抵押登记创建-根据cqzh获取xmid:{}",entity.toString());
            jsonObject.set("zsxmid",entity.getXmid());
        }

        //申请登记类型
        String sqdjlx = jsonObject.getStr("sqdjlx");
        if ("1".equals(sqdjlx)) {
//            jsonObject.set("sqdjlx", "10004008");
            jsonObject.set("sqdjlx", "17");
        }
        //证书来源
        jsonObject.set("zsly","2");
        //预约部门编号
        jsonObject.set("yybmbm",jsonObject.getStr("qydm"));
        //登记原因代码
        jsonObject.set("djyydm", ParamUtil.replaceDjyy(jsonObject.getStr("qydm")));
        //登记原因名称
        jsonObject.set("djyymc","国有建设用地使用权/房屋所有权房屋抵押权首次登记");
        //自动转发 0不转 1转
        jsonObject.set("zdzf","1");
        //受理来源
        jsonObject.set("slly","6");
        //是否主房 0 否 1 是
        jsonObject.set("sfzf","1");
        //行政区域代码
        jsonObject.set("xzqdm",jsonObject.getStr("qydm"));
        //抵押人参数替换
        JSONArray dyr = jsonObject.getJSONArray("dyr");
        for (Object o : dyr) {
            JSONObject dy = (JSONObject) o;
            //抵押人名称
            dy.set("qlrmc",dy.get("dyrmc"));
            //抵押人证件号
            dy.set("qlrzjh",dy.get("dyrzjh"));
            //抵押人证件种类
            dy.set("qlrzjzl",dy.get("dyrzjzl") + "");
            //抵押人联系电话
            dy.set("qlrlxdh",dy.get("dyrlxdh"));
            //权利人种类代码/权利人种类名称
            Object dyrzldm = dy.get("dyrzldm");
            if (ObjectUtils.isEmpty(dyrzldm)){
                dy.set("qlrzldm","");
                dy.set("qlrzlmc","");
            }else {
                dy.set("qlrzldm",dy.get("dyrzldm") + "");
                dy.set("qlrzlmc", ParamUtil.replaceZlmc(dy.get("dyrzldm") + ""));
            }
            //共有方式/共有方式名称
            Object gyfs = dy.get("gyfs");
            if (ObjectUtils.isEmpty(gyfs)){
                dy.set("gyfs","");
                dy.set("gyfsmc","");
            }else {
                dy.set("gyfs",dy.get("gyfs") + "");
                dy.set("gyfsmc", ParamUtil.replaceGyfsmc(dy.get("gyfs") + ""));
            }
        }
        jsonObject.set("qlr", dyr);
        //抵押权利人
        JSONArray dyqlr = jsonObject.getJSONArray("dyqlr");
        for (Object o : dyqlr) {
            JSONObject dyql = (JSONObject) o;
            //证件种类
            dyql.set("qlrzjzl",dyql.get("qlrzjzl") + "");
            //抵押权利人/种类名称
            Object qlrzldm = dyql.get("qlrzldm");
            if (ObjectUtils.isEmpty(qlrzldm)){
                dyql.set("qlrzldm","");
                dyql.set("qlrzlmc","");
            }else {
                dyql.set("qlrzldm",dyql.get("qlrzldm") + "");
                dyql.set("qlrzlmc", ParamUtil.replaceZlmc(dyql.get("qlrzldm") + ""));
            }
            //共有方式/共有方式名称
            Object gyfsdm = dyql.get("gyfsdm");
            if (ObjectUtils.isEmpty(gyfsdm)){
                dyql.set("gyfsdm","");
                dyql.set("gyfsmc","");
            }else {
                dyql.set("gyfsdm",dyql.get("gyfsdm") + "");
                dyql.set("gyfsmc", ParamUtil.replaceGyfsmc(dyql.get("gyfsdm") + ""));
            }
        }
        jsonObject.set("dyqlr", dyqlr);
        //债务人信息
//        JSONArray zwrxx = jsonObject.getJSONArray("zwrxx");
//        for (Object o : zwrxx) {
//            JSONObject zwrx = (JSONObject) o;
//            zwrx.set("zwrzjzl",zwrx.get("zwrzjzl") +"");
//
//        }
//        jsonObject.set("zwrxx", zwrxx);
        //抵押信息
        JSONArray dyxx = jsonObject.getJSONArray("dyxx");
        for (Object o : dyxx) {
            JSONObject dyx = (JSONObject) o;
            dyx.set("fj", dyx.get("fjxx") + "");
            dyx.set("xlsqdjlx","17");
            //权利类型
            dyx.set("qllx","18");
            dyx.set("qllxmc","抵押");
            dyx.set("sfjzdyqjdywzr","1");
        }
        jsonObject.set("dyxx", dyxx);


        return jsonObject;
    }

    //抵押注销
    private JSONObject repalceParamDyzxcj(PledgeWriteOffRegisterEq pledgeWriteOffRegisterEq) {
        JSONObject jsonObject = new JSONObject(pledgeWriteOffRegisterEq);
        //抵押证明号
        jsonObject.set("zmh", jsonObject.getStr("dyzmh"));
        //产权证号
        jsonObject.set("cqzh", jsonObject.getStr("bdcqzh"));

        //抵押人参数替换
        JSONArray dyr = jsonObject.getJSONArray("dyr");
        for (Object o : dyr) {
            JSONObject dy = (JSONObject) o;
            dy.set("qlrmc", dy.get("dyrmc") + "");
            dy.set("qlrzjh", dy.get("dyrzjh") + "");
            dy.set("qlrzjzl",dy.get("dyrzjzl") + "");
            //证件类型码值替换
//            if (StringUtils.isNotEmpty(dy.get("dyrzjzl") + "")) {
//                String dyrzjzl = ParamUtil.replaceParam(dy.get("dyrzjzl") + "");
//                dy.set("qlrzjzl", dyrzjzl);
//            }
            dy.set("qlrlxdh", dy.get("dyrlxdh") + "");
            //权利人种类代码
            dy.set("qlrzldm", dy.get("dyrzldm") + "");
        }
        //抵押人
        jsonObject.set("dyr", dyr);
        jsonObject.set("qlr",jsonObject.getJSONArray("dyqlr"));
        return jsonObject;
    }

    @Autowired
    private DownMethodHandler downMethodHandler;

    private void setFjxx(JSONObject jsonObject){
        downMethodHandler.getUrltoByte4DydjFjxx(jsonObject);
    }

    private void setFjxx4Dyzx(JSONObject jsonObject){
        downMethodHandler.getUrltoByte4DyzxFjxx(jsonObject);
    }

    public void uploadFjxx4Dydj(JSONObject jsonObject){
        log.info("不动产-抵押登记创建-上传附件");
        downMethodHandler.getUrltoByte(jsonObject);
        JSONObject result = new JSONObject();
        try{
            JSONObject fjJsonObject = new JSONObject();
            fjJsonObject.set("proid",jsonObject.getStr("slbh"));
//            fjJsonObject.set("xldjsqlx","10004008");
            fjJsonObject.set("xldjsqlx","17");
            log.info("不动产-抵押登记创建-上传附件,除fjxx参数：{}",fjJsonObject);
            fjJsonObject.set("fjxx",jsonObject.getJSONArray("fjxx"));
            String url = tsWwsqFjxxUrl;
            HttpHeadModel token = getToken();
            JSONObject resMap = esbService.sendPostByJson4tsWwsqFjxx(url, token, fjJsonObject);
            ReturnResult resData = getResData(resMap);

            if (!"0000".equals(resData.getCode())) {
                result.set("msg","fail");
                result.set("code","999999");
                result.set("bjbh", jsonObject.getStr("bjbh"));
                result.set("type", "1");
                log.info("不动产-抵押登记创建-上传附件-失败:"+resData.getMessage());
            }else{
                result.set("msg","success");
                result.set("code","000000");
                result.set("bjbh", jsonObject.getStr("bjbh"));
                result.set("slbh",jsonObject.getStr("slbh"));
                result.set("type", "1");
                log.info("不动产-抵押登记创建-上传附件-成功:"+resData.getMessage());
            }
            //通知展业
            log.info("不动产-抵押登记创建-上传附件完成-通知展业参数{}",result);
            JSONObject sendRes = esbService.sendZhanye(sendNoticeUrl, result);
            log.info("不动产-抵押登记创建-上传附件完成-通知展业结果{}",sendRes.toString());
        }catch (Exception e){
            log.info("不动产-抵押登记创建-上传附件-期间出错:"+e.getMessage());
//            result.set("status","-1");
            result.set("msg",e.getMessage());
            result.set("code","999999");
            result.set("bjbh", jsonObject.getStr("bjbh"));
        }

    }

    public JSONObject uploadFjxx4Dyzx(JSONObject jsonObject){
        log.info("不动产-抵押注销-上传附件");
        downMethodHandler.getUrltoByte(jsonObject);
        JSONObject result = new JSONObject();
        try{
            JSONObject fjJsonObject = new JSONObject();
            fjJsonObject.set("proid",jsonObject.getStr("slbh"));
            fjJsonObject.set("xldjsqlx","17");
            log.info("不动产-抵押注销-上传附件,除fjxx参数：{}",fjJsonObject);
            fjJsonObject.set("fjxx",jsonObject.getJSONArray("fjxx"));
            String url = tsWwsqFjxxUrl;
            HttpHeadModel token = getToken();
            JSONObject resMap = esbService.sendPostByJson4tsWwsqFjxx(url, token, fjJsonObject);
            ReturnResult resData = getResData(resMap);

            if (!"0000".equals(resData.getCode())) {
                result.set("msg",resData.getMessage());
                result.set("code","999999");
                result.set("bjbh", jsonObject.getStr("bjbh"));
                result.set("type", "2");
                log.info("不动产-抵押注销-上传附件-失败:"+resData.getMessage());
            }else{
                result.set("msg","success");
                result.set("code","000000");
                result.set("bjbh", jsonObject.getStr("bjbh"));
                result.set("slbh",jsonObject.getStr("slbh"));
                result.set("type", "2");
                log.info("不动产-抵押注销-上传附件-成功:"+resData.getMessage());
            }
            //通知展业
            log.info("不动产-抵押注销-上传附件完成-通知展业参数{}",result);
            JSONObject sendRes = esbService.sendZhanye(sendNoticeUrl, result);
            log.info("不动产-抵押注销-上传附件完成-通知展业结果{}",sendRes.toString());
        }catch (Exception e){
            log.info("不动产-抵押注销-上传附件-期间出错:"+e.getMessage());
//            result.set("status","-1");
            result.set("msg",e.getMessage());
            result.set("code","999999");
            result.set("bjbh", jsonObject.getStr("bjbh"));
        }
        return result;
    }

    private String uploadS3(String content){
        UUID uuid = UUID.randomUUID();
        String fileName = uuid + ".pdf";
        //上传文件
        File file = Base64Util.base64ToFile(content, fileName, localpath);

        String UploadFile = file.getPath();

        PutObjectResult putObjectResult = s3Util.upload(bucketName, UploadFile, file);
        if(putObjectResult == null){
            log.info("上传到S3出错!");
        }else {
            log.info("上传到S3成功");
        }
        // 获取url
        long expireTimeMillis= new Date().getTime()+ 1000*60*60*24*7;
        String url = s3Util.getURL(bucketName, UploadFile, expireTimeMillis, HttpMethod.GET);
        log.info("S3文件Url:{}",url);
        file.delete();
        return url;
    }

    /**
     * 转换为自己响应值，响应码，响应信息
     *
     * @return
     */
    private ReturnResult getResData(Map<String, Object> resMap) {
        ReturnResult returnResult = new ReturnResult();
        if (resMap.containsKey("head")) {
            Map<String, Object> headMap = (Map<String, Object>) resMap.get("head");
            if (headMap.containsKey("code")) {
                returnResult.setCode(headMap.get("code").toString());
                returnResult.setMessage(headMap.containsKey("msg") ? headMap.get("msg").toString() : "");
                returnResult.setData(resMap.get("data"));
            } else if (headMap.containsKey("statusCode")) {
                returnResult.setCode(headMap.get("statusCode").toString());
                returnResult.setMessage(headMap.containsKey("msg") ? headMap.get("msg").toString() : "");
                returnResult.setData(headMap.containsKey("msg") ? headMap.get("msg").toString() : null);
            }
        } else {
            if (resMap.containsKey("code")) {
                returnResult.setCode(resMap.get("code").toString());
                if (resMap.containsKey("msg")) {
                    returnResult.setMessage(resMap.get("msg").toString());
                } else if (resMap.containsKey("message")) {
                    returnResult.setMessage(resMap.get("message").toString());
                }
                if (resMap.containsKey("data")) {
                    returnResult.setData(resMap.get("data"));
                }
            } else if (resMap.containsKey("error")) {
                returnResult.setCode(resMap.get("status").toString());
                returnResult.setMessage(resMap.get("message").toString());
            }
        }
        return returnResult;
    }
}
