package com.ntrcb.immovable.service.imp;

import cn.hutool.json.JSONObject;
import com.ntrcb.immovable.entity.shebao.QueryInfoReq;
import com.ntrcb.immovable.service.IShebaoToProvinceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
@Slf4j
public class ShebaoToProvinceServiceImpl implements IShebaoToProvinceService {

    @Resource
    private ShebaoServiceImpl shebaoService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Value("${property.url.shebaoUrl}")
    private  String shebaoUrl;

    @Override
    public JSONObject queryInfo(QueryInfoReq req) {
        JSONObject result = new JSONObject();
        try {
            result.set("code","0000");

            //先看缓存有没有
            String redisRes = redisTemplate.opsForValue().get(req.getIdcard());
            if(null != redisRes){
                result.set("data",new JSONObject(redisRes));
                return result;
            }else{
                JSONObject json = shebaoService.sendPostByJson(shebaoUrl, req);
                JSONObject data = new JSONObject();
                data.set("grbh",json.getStr("userId"));//个人编号
                data.set("xm",json.getStr("userName"));//姓名
                data.set("zjlx","");//证件类型
                data.set("zjhm",json.getStr("certId"));//证件号码
                data.set("dwbh",json.getStr("companyId"));//单位编号
                data.set("dwmc",json.getStr("companyName"));//单位名称
                data.set("dwlb",json.getStr("companyType"));//单位类别
                data.set("xzlx",json.getStr("insureType"));//险种类型
                data.set("grbrq",json.getStr("personInsureDate"));//个人保日期
                data.set("sccbrq",json.getStr("firstInsureDate"));//首次参保日期
                data.set("cbzt",json.getStr("insureState"));//参保状态
                data.set("jfrq","");//缴费日期
                data.set("dwjn",json.getStr("companyPay"));//单位缴纳
                data.set("grjn",json.getStr("personPay"));//个人缴纳
                data.set("jfjs",json.getStr("paymentBase"));//缴费基数

                data.set("jsq","");//结算期
                data.set("dyjsq","");//对应结算期
                data.set("sndjfze","");//上年度缴费总额
                data.set("ljjfys_36","");//累计缴费月数（近3年）
                data.set("ljjfys_24","");//累计缴费月数（近2年）
                data.set("ljjfys_12","");//累计缴费月数（近1年）
                data.set("ljjfys_bn","");//累计缴费月数（本年）
                data.set("ljjfys","");//本单位累计缴纳月数
                data.set("ljyjys","");//累计应缴月数
                data.set("ljsjys","");//累计实缴月数
                data.set("dbbs","");//大病标志
                result.set("data",data);
                redisTemplate.opsForValue().set(req.getIdcard(),data.toString());
            }

        } catch (Exception e) {
            result.set("status", "-1");
            result.set("msg", e.getMessage());
            result.set("data", "");
            result.set("code", "-1");

        }

        return result;
    }


}
