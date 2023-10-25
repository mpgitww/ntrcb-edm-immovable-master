package com.ntrcb.immovable.service.imp;

import com.finstone.house.iface.ws.client.FrameInvokeServiceClient;
import com.ntrcb.common.util.JsonToXmlUtil;
import com.ntrcb.common.util.XmlToJsonUtil;
import com.ntrcb.immovable.entity.Req0541.Req0541Root;
import com.ntrcb.immovable.entity.Req0542.Req0542Root;
import com.ntrcb.immovable.entity.Res0541.Res0541Root;
import com.ntrcb.immovable.entity.Res0542.Res0542Root;
import com.ntrcb.immovable.service.IHousing;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Org NTRCB
 * @Author: 06101675
 * @Description:
 * @Date: create in 2022/9/8 14:06
 */
@Service
@Slf4j
public class HousingImp implements IHousing {
    @Resource
    FrameInvokeServiceClient client;

    @Override
    public Res0541Root invoke_0541(Req0541Root req0541Root) {
        //invoke方法完成 编码压缩、发送、获得返回报文、解压和签名对比
        log.info("0541-客户身份验证查询交易 接口请求报文");
        String reqXml = JsonToXmlUtil.jsonStr2XmlStr(JSONObject.fromObject(req0541Root).toString());
        log.info("xml 请求报文{}",reqXml);
        String retXml = client.invoke(reqXml);
        log.info("0541-客户身份验证查询交易 接口返回报文");
        log.info("xml 返回报文{}",retXml);
        JSONObject retJson = XmlToJsonUtil.xmlToJson(retXml);
        Res0541Root res0541Root =  (Res0541Root) JSONObject.toBean(retJson, Res0541Root.class);
        return res0541Root;
    }

    @Override
    public Res0542Root invoke_0542(Req0542Root req0542Root) {
        //invoke方法完成 编码压缩、发送、获得返回报文、解压和签名对比
        log.info("0542-客户公积金缴纳信息查询  接口请求报文");
        String reqXml = JsonToXmlUtil.jsonStr2XmlStr(JSONObject.fromObject(req0542Root).toString());
        log.info("xml 请求报文{}",reqXml);
        String retXml = client.invoke(reqXml);
        log.info("0542-客户公积金缴纳信息查询  接口返回报文");
        log.info("xml 返回报文{}",retXml);
        JSONObject retJson = XmlToJsonUtil.xmlToJson(retXml);
        Res0542Root res0542Root =  (Res0542Root) JSONObject.toBean(retJson, Res0542Root.class);
        return res0542Root;
    }
}
