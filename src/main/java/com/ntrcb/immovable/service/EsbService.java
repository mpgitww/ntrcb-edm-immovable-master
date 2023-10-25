package com.ntrcb.immovable.service;

import cn.hutool.json.JSONObject;

import java.util.Map;

public interface EsbService  {
    /**
     * 一般推送
     * @param esbUrl
     * @param head
     * @param params
     * @return
     */
    Map<String, Object> sendPost(String esbUrl , Object head, Object params);

    /**
     * 列表推送
     * @param esbUrl
     * @param head
     * @param params
     * @return
     */
    Map<String, Object> sendPostForList(String esbUrl , Object head, Object params);

    /**
     * 没有Date 参数和head同级
     * @param esbUrl
     * @param head
     * @param params
     * @return
     */
    Map<String, Object> sendPostForNoData(String esbUrl , Object head, Object params);

    /**
     * 带分页的查询
     * @param esbUrl
     * @param head
     * @param pageInfo
     * @param params
     * @return
     */
    Map<String, Object> sendPostToPage(String esbUrl , Object head,Object pageInfo, Object params);


















    /**
     * 一般推送
     * @param esbUrl
     * @param head
     * @param params
     * @return
     */
    JSONObject sendPostByJson(String esbUrl , Object head, Object params);

    /**
     * 列表推送
     * @param esbUrl
     * @param head
     * @param params
     * @return
     */
    JSONObject sendPostForListByJson(String esbUrl , Object head, Object params);

    /**
     * 没有Date 参数和head同级
     * @param esbUrl
     * @param head
     * @param params
     * @return
     */
    JSONObject  sendPostForNoDataByJson(String esbUrl , Object head, Object params);

    /**
     * 带分页的查询
     * @param esbUrl
     * @param head
     * @param pageInfo
     * @param params
     * @return
     */
    JSONObject sendPostToPageByJson(String esbUrl , Object head,Object pageInfo, Object params);

    /**
     * 附件上传专用
     * 因为附件bytes 文件base64太大了，日志容易过大
     * @param esbUrl
     * @param head
     * @param params
     * @return
     */
    JSONObject sendPostByJson4tsWwsqFjxx(String esbUrl , Object head, Object params);

    /**
     * 发送到展业凭条
     * @param url
     * @param params
     * @return
     */
    JSONObject sendZhanye(String url , Object params);
}
