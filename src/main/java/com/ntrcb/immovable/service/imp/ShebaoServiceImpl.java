package com.ntrcb.immovable.service.imp;

import cn.hutool.json.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * 访问社保
 *
 */
@Service
@Slf4j
public class ShebaoServiceImpl{

    public Map<String, Object> sendPost(String esbUrl, Object head, Object params) {
        JSONObject jsonObj = new JSONObject(false);
        JSONObject inputData= new JSONObject(params);
        jsonObj.set("data",inputData);

        HttpEntity<Object> requestEntity  =  aesEncrypt(jsonObj);
        log.info("请求报文：" + jsonObj.toString());
        RestTemplate restTemplat = new RestTemplate();
        String returnMsgAes = restTemplat.postForObject(esbUrl , requestEntity, String.class);
        //解密
        log.info("响应报文：" + returnMsgAes);
        //请求成功解析返回的报文
        JSONObject resObj  = new JSONObject(returnMsgAes);
        return resObj;
    }

    public JSONObject sendPostByJson(String esbUrl, Object params) {
        JSONObject jsonObj = new JSONObject(false);
        JSONObject inputData= new JSONObject(params);
        jsonObj.set("data",inputData);

        HttpEntity<Object> requestEntity  =  aesEncrypt(jsonObj);
        log.info("请求报文：" + jsonObj.toString());
        RestTemplate restTemplat = new RestTemplate();
        String returnMsgAes = restTemplat.postForObject(esbUrl , requestEntity, String.class);
        //解密
        log.info("响应报文：" + returnMsgAes);
        //请求成功解析返回的报文
        JSONObject resObj  = new JSONObject(returnMsgAes);
        return resObj;
    }

    private HttpEntity<Object> aesEncrypt(JSONObject jsonObj) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> requestEntity = new HttpEntity(jsonObj, requestHeaders);
        return requestEntity;
    }

}
