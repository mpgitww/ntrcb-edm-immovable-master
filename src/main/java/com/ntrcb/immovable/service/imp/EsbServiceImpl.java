package com.ntrcb.immovable.service.imp;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.ntrcb.immovable.service.EsbService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * 访问不动产
 *
 */
@Service
@Slf4j
public class EsbServiceImpl  implements EsbService {

    @Override
    public Map<String, Object> sendPost(String esbUrl, Object head, Object params) {
        JSONObject jsonObj = new JSONObject(false);
        JSONObject inputData= new JSONObject(params);
        JSONObject headData = new JSONObject(head);
        jsonObj.set("head",headData);
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

    @Override
    public Map<String, Object> sendPostForList(String esbUrl, Object head, Object params) {
        JSONObject jsonObj = new JSONObject(false);
        JSONArray inputData= new JSONArray(params);
        JSONObject headData = new JSONObject(head);
        jsonObj.set("head",headData);
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

    @Override
    public Map<String, Object> sendPostForNoData(String esbUrl, Object head, Object params) {
        JSONObject jsonObj = new JSONObject(params);
        JSONObject headData = new JSONObject(head);
        jsonObj.set("head",headData);
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

    @Override
    public Map<String, Object> sendPostToPage(String esbUrl, Object head, Object pageInfo, Object params) {
        JSONObject jsonObj = new JSONObject(false);
        JSONObject inputData= new JSONObject(params);
        JSONObject headData = new JSONObject(head);
        JSONObject pageData = new JSONObject(pageInfo);
        jsonObj.set("head",headData);
        jsonObj.set("data",inputData);
        jsonObj.set("pageInfo",pageData);
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

    /**
     * 请求头
     * @param jsonObj
     * @param
     * @return
     */
    private HttpEntity<Object> aesEncrypt(JSONObject jsonObj) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> requestEntity = new HttpEntity(jsonObj, requestHeaders);
        return requestEntity;
    }


    @Override
    public JSONObject sendPostByJson(String esbUrl, Object head, Object params) {
        JSONObject jsonObj = new JSONObject(false);
        JSONObject inputData= new JSONObject(params);
        JSONObject headData = new JSONObject(head);
        jsonObj.set("head",headData);
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

    @Override
    public JSONObject sendPostForListByJson(String esbUrl, Object head, Object params) {
        JSONObject jsonObj = new JSONObject(false);
        JSONArray inputData= new JSONArray(params);
        JSONObject headData = new JSONObject(head);
        jsonObj.set("head",headData);
        jsonObj.set("data",inputData);

        HttpEntity<Object> requestEntity  =  aesEncrypt(jsonObj);

        RestTemplate restTemplat = new RestTemplate();
        String returnMsgAes = restTemplat.postForObject(esbUrl , requestEntity, String.class);
        //由于fjxx太多，不打印
        ((JSONObject)inputData.get(0)).remove("fjxx");
        log.info("fjxx参数太大了，暂时不打印。" );
        log.info("请求报文：" + jsonObj.toString());
        //解密
        log.info("响应报文：" + returnMsgAes);
        //请求成功解析返回的报文
        JSONObject resObj  = new JSONObject(returnMsgAes);
        return resObj;
    }

    @Override
    public JSONObject sendPostForNoDataByJson(String esbUrl, Object head, Object params) {
        JSONObject jsonObj = new JSONObject(params);
        JSONObject headData = new JSONObject(head);
        jsonObj.set("head",headData);
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

    @Override
    public JSONObject sendPostToPageByJson(String esbUrl, Object head, Object pageInfo, Object params) {
        JSONObject jsonObj = new JSONObject(false);
        JSONObject inputData= new JSONObject(params);
        JSONObject headData = new JSONObject(head);
        JSONObject pageData = new JSONObject(pageInfo);
        jsonObj.set("head",headData);
        jsonObj.set("data",inputData);
        jsonObj.set("pageInfo",pageData);
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

    @Override
    public JSONObject sendPostByJson4tsWwsqFjxx(String esbUrl, Object head, Object params) {
        JSONObject jsonObj = new JSONObject(false);
        JSONObject inputData= new JSONObject(params);
        JSONObject headData = new JSONObject(head);
        jsonObj.set("head",headData);
        jsonObj.set("data",inputData);

        HttpEntity<Object> requestEntity  =  aesEncrypt(jsonObj);
        log.info("请求报文：附件信息上传，附件内容较大，暂不打印日志");
        RestTemplate restTemplat = new RestTemplate();
        String returnMsgAes = restTemplat.postForObject(esbUrl , requestEntity, String.class);
        //解密
        log.info("响应报文：" + returnMsgAes);
        //请求成功解析返回的报文
        JSONObject resObj  = new JSONObject(returnMsgAes);
        return resObj;
    }

    @Override
    public JSONObject sendZhanye(String url, Object params) {
        JSONObject inputData= new JSONObject(params);

        HttpEntity<Object> requestEntity  =  aesEncrypt(inputData);
        log.info("请求报文：" + inputData.toString());
        RestTemplate restTemplat = new RestTemplate();
        String returnMsgAes = restTemplat.postForObject(url , requestEntity, String.class);
        //解密
        log.info("响应报文：" + returnMsgAes);
        //请求成功解析返回的报文
        JSONObject resObj  = new JSONObject(returnMsgAes);
        return resObj;
    }


}
