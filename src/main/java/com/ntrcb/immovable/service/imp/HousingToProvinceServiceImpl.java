package com.ntrcb.immovable.service.imp;

import cn.hutool.json.JSONObject;
import com.finstone.house.iface.ws.client.FrameInvokeServiceClient;
import com.ntrcb.common.constant.ReturnResult;
import com.ntrcb.common.util.JsonToXmlUtil;
import com.ntrcb.common.util.XmlToJsonUtil;
import com.ntrcb.immovable.constant.HousingConstant;
import com.ntrcb.immovable.constant.HousingReturnEnum;
import com.ntrcb.immovable.entity.Immovable.model.HttpHeadModel;
import com.ntrcb.immovable.entity.Req0541.Req0541Root;
import com.ntrcb.immovable.entity.Req0541.Req0541RootBody;
import com.ntrcb.immovable.entity.Req0541.Req0541RootBodyHead;
import com.ntrcb.immovable.entity.Req0542.Req0542Root;
import com.ntrcb.immovable.entity.Req0542.Req0542RootBody;
import com.ntrcb.immovable.entity.Req0542.Req0542RootBodyHead;
import com.ntrcb.immovable.entity.Res0541.Res0541Root;
import com.ntrcb.immovable.entity.Res0541.Res0541RootBodyHead;
import com.ntrcb.immovable.entity.Res0542.Res0542Root;
import com.ntrcb.immovable.entity.Res0542.Res0542RootBodyHead;
import com.ntrcb.immovable.entity.gjj.req.QueryInfoReq;
import com.ntrcb.immovable.entity.xmlReq.ReqRootHead;
import com.ntrcb.immovable.service.IHousingToProvinceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

@Service
@Slf4j
public class HousingToProvinceServiceImpl implements IHousingToProvinceService {

    @Resource
    FrameInvokeServiceClient client;

    @Override
    public JSONObject queryInfo(QueryInfoReq req) {
        JSONObject result = new JSONObject();
        try {
            //1.客户身份验证接口
            Res0541Root res0541Root = invoke_0541(req);
            Res0541RootBodyHead res0541RootBodyHead = res0541Root.getBody().getHead();
            //判断0541接口调用是否成功
            if(HousingReturnEnum.RET_0001.getCode().equals(res0541Root.getHead().getRetcode())){
                //判断是否通过
                if(HousingConstant.STDMERRSLT_1.equals(res0541RootBodyHead.getStdmerrslt())){
                    //2.客户公积金缴纳信息
                    Req0542Root req0542Root = creeateReq0542Root(res0541RootBodyHead);
                    Res0542Root res0542Root = invoke_0542(req0542Root);
                    //判断0542接口是否成功
                    if (HousingReturnEnum.RET_0001.getCode().equals(res0542Root.getHead().getRetcode())){
                        Res0542RootBodyHead res0542RootBodyHead = res0542Root.getBody().getHead();
                        //判断是否通过
                        if(HousingConstant.STDMERRSLT_1.equals(res0542RootBodyHead.getStdmerrslt())){
                            //返回查询结果
                            result.set("status", "100");
                            result.set("msg", "查询成功");
                            result.set("data", dealResData(res0542RootBodyHead));
                            result.set("code", "0000");
                        }
                        //不通过
                        else{
                            result.set("status", "-1");
                            result.set("msg", dealStdrslttp(res0542RootBodyHead.getStdrslttp()));
                            result.set("data", "");
                            result.set("code", "-1");
                            return result;
                        }

                    }
                    //不成功
                    else{
                        result.set("status", "-1");
                        result.set("msg", res0542Root.getHead().getRetmsg());
                        result.set("data", "");
                        result.set("code", "-1");
                        return result;
                    }

                }
                //不通过
                else{
                    result.set("status", "-1");
                    result.set("msg", dealStdrslttp(res0541RootBodyHead.getStdrslttp()));
                    result.set("data", "");
                    result.set("code", "-1");
                    return result;
                }
            }
            //0541不成功
            else{
                result.set("status", "-1");
                result.set("msg", res0541Root.getHead().getRetmsg());
                result.set("data", "");
                result.set("code", "-1");
                return result;
            }

        } catch (Exception e) {
            result.set("status", "-1");
            result.set("msg", e.getMessage());
            result.set("data", "");
            result.set("code", "-1");

        }

        return result;
    }

    /**
     * 调用0541-客户身份验证
     * @param req
     * @return
     */
    private Res0541Root invoke_0541(QueryInfoReq req){
        log.info("0541-客户身份验证查询交易 接口请求报文");
        Req0541Root req0541Root = createReq0541Root(req);
        String reqXml = JsonToXmlUtil.jsonStr2XmlStr(net.sf.json.JSONObject.fromObject(req0541Root).toString());
        log.info("xml 请求报文{}",reqXml);
        String retXml = client.invoke(reqXml);
        log.info("0541-客户身份验证查询交易 接口返回报文");
        log.info("xml 返回报文{}",retXml);
        net.sf.json.JSONObject retJson = XmlToJsonUtil.xmlToJson(retXml);
        Res0541Root res0541Root =  (Res0541Root) net.sf.json.JSONObject.toBean(retJson, Res0541Root.class);
        return res0541Root;
    }

    private Req0541Root createReq0541Root(QueryInfoReq req){
        //root head
        Req0541Root req0541Root = new Req0541Root();
        ReqRootHead reqRootHead = new ReqRootHead();
        reqRootHead.setSender("RGRCB02");
        reqRootHead.setReceiver("G01");
        reqRootHead.setAppid("01");
        reqRootHead.setTranscode("410541");
        reqRootHead.setTrantime(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        Random random = new Random();
        String s = random.nextInt(9999 - 1000 + 1) + 1000 + "";
        reqRootHead.setIseqno(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).concat(s));
        req0541Root.setHead(reqRootHead);

        //root body head
        Req0541RootBody req0541RootBody = new Req0541RootBody();
        Req0541RootBodyHead req0541RootBodyHead =  new Req0541RootBodyHead();
        req0541RootBodyHead.setStd400idtp(req.getCertType());
        req0541RootBodyHead.setStd400idno(req.getCertNumber());
        req0541RootBodyHead.setStd400cunm(req.getName());
        req0541RootBodyHead.setStdmersys("0006");
        req0541RootBody.setHead(req0541RootBodyHead);
        req0541Root.setBody(req0541RootBody);

        return req0541Root;
    }


    public Res0542Root invoke_0542(Req0542Root req0542Root) {
        //invoke方法完成 编码压缩、发送、获得返回报文、解压和签名对比
        log.info("0542-客户公积金缴纳信息查询  接口请求报文");
        String reqXml = JsonToXmlUtil.jsonStr2XmlStr(net.sf.json.JSONObject.fromObject(req0542Root).toString());
        log.info("xml 请求报文{}",reqXml);
        String retXml = client.invoke(reqXml);
        log.info("0542-客户公积金缴纳信息查询  接口返回报文");
        log.info("xml 返回报文{}",retXml);
        net.sf.json.JSONObject retJson = XmlToJsonUtil.xmlToJson(retXml);
        Res0542Root res0542Root =  (Res0542Root) net.sf.json.JSONObject.toBean(retJson, Res0542Root.class);
        return res0542Root;
    }

    private Req0542Root creeateReq0542Root(Res0541RootBodyHead res0541RootBodyHead){
        Req0542Root req0542Root = new Req0542Root();
        ReqRootHead reqRootHead = new ReqRootHead();
        reqRootHead.setSender("RGRCB02");
        reqRootHead.setReceiver("G01");
        reqRootHead.setAppid("01");
        reqRootHead.setTranscode("410542");
        reqRootHead.setTrantime(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        Random random = new Random();
        String s = random.nextInt(9999 - 1000 + 1) + 1000 + "";
        reqRootHead.setIseqno(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).concat(s));
        req0542Root.setHead(reqRootHead);

        Req0542RootBody req0542RootBody = new Req0542RootBody();
        Req0542RootBodyHead req0542RootBodyHead = new Req0542RootBodyHead();
        req0542RootBodyHead.setStdmersys(res0541RootBodyHead.getStdmersys());
        req0542RootBodyHead.setStdmerno(res0541RootBodyHead.getStdmerno());
        req0542RootBody.setHead(req0542RootBodyHead);
        req0542Root.setBody(req0542RootBody);
        return  req0542Root;
    }

    private HashMap dealResData(Res0542RootBodyHead head){
        HashMap map = new HashMap();
        map.put("GRZH",head.getStd400grid());
        map.put("XM",head.getStd400cunm());
        if ("0".equals(head.getStd400idtp())){
            map.put("ZJLX","身份证");
        }else {
            map.put("ZJLX","");
        }
        map.put("SFZID",head.getStd400idno());
        map.put("SJHM",head.getStd400mobl());
        map.put("KHRQ",head.getStdgjjrgdt());
        if (StringUtils.isNotEmpty(head.getStdcmprgtm())){
            String rq2 = head.getStdcmprgtm().substring(4,6);
            String rq1 = head.getStdcmprgtm().substring(0,4);
            map.put("CJNY",rq1 + rq2);
        }else {
            map.put("CJNY","");
        }
        map.put("DKBZ",head.getStdgjjdkbh() + "");//贷款编号
        map.put("YJCE","");//目前没有值
        map.put("ZFJCE","");//目前没有值
        String replace2 = head.getStdgjjgram().replace("|", "-");
        String[] split2 = replace2.split("-");
        map.put("GRYJCE",split2[0]);
        String replace3 = head.getStdgjjdwam().replace("|", "-");
        String[] split3 = replace3.split("-");
        map.put("DWYJCE",split3[0]);//单位月缴存额
        map.put("ZFRATE","");//目前没有值
        String replace = head.getStdgjjgrsc().replace("|", "-");
        String[] split = replace.split("-");
        map.put("GRRATE",split[0]);
        String replace1 = head.getStdcmpyjsc().replace("|", "-");
        String[] split1 = replace1.split("-");
        map.put("DWRATE",split1[0]);
        map.put("GRJCJS",head.getStd400sqam());
        if ("11".equals(head.getStdcmpjczt())){ //账户状态
            map.put("ZT","1");
        }else {
            map.put("ZT","0");
        }
        map.put("DWXZ",gjjDwxz(head.getStdcmpprpt()));
        map.put("DWNAME",head.getStdcmpaddr());
        String stdgjjendt = head.getStdgjjendt();
        if (StringUtils.isNotEmpty(stdgjjendt)){
            String rq2 = stdgjjendt.substring(4,6);
            String rq1 = stdgjjendt.substring(0,4);
            map.put("JZNY",rq1 + rq2);
        }else {
            map.put("JZNY","");
        }

        String stdgjjltdt = head.getStdgjjltdt();
        if (StringUtils.isNotEmpty(stdgjjltdt)){
            String rq2 = stdgjjltdt.substring(4,6);
            String rq1 = stdgjjltdt.substring(0,4);
            map.put("ZJJCRQ",rq1 + rq2);
        }else {
            map.put("ZJJCRQ","");
        }
        map.put("JTMHJCS",head.getStdgjjlxjccs());
        map.put("SSGLB",head.getStdcmpkhid());
        map.put("JTMBJCS","");//目前没有值
        return map;
    }

    public String gjjDwxz(String dwxz){
        String gyqy = "04-07-09-12";
        String czjt = "05-08";
        String wstz = "17-18-19-20-21-22-23-24";
        String wstz1 = "11-13-14-15";
        if ("00".equals(dwxz)){
            return "10";
        }else if ("01".equals(dwxz)){
            return "20";
        }else if (gyqy.contains(dwxz)){
            return "30";
        }else if (czjt.contains(dwxz)){
            return "31";
        }else if (wstz.contains(dwxz)){
            return "32";
        }else if (wstz1.contains(dwxz)){
            return "33";
        }else if ("16".equals(dwxz)){
            return "39";
        }else if ("02".equals(dwxz)){
            return "40";
        }else if ("03".equals(dwxz)){
            return "50";
        }else if ("25".equals(dwxz)){
            return "90";
        }else if ("26".equals(dwxz)){
            return "71";
        }else if ("27".equals(dwxz)){
            return "72";
        }
        return "";
    }

    /**
     * 处理不通过的情况
     * Stdrs
     * @return
     */
    private String dealStdrslttp(String stdrslttp){
        if("1".equals(stdrslttp)){
            return "个人编号不存在";
        }
        else if("2".equals(stdrslttp)){
            return "证件信息不匹配";
        }
        else if("3".equals(stdrslttp)){
            return "姓名不匹配";
        }
        return stdrslttp;
    }
}
