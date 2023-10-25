package com.ntrcb.immovable.entity.Immovable.model;

import lombok.Data;

/**
 * 不动产中心（国图）请求头
 */
@Data
public class HttpHeadModel {
    /**
        token值
     */
    private String access_token;
    /**
     * 数字验签 (固定)
     */
    private String sign;
    /**
     * 数据来源
     */
    private String origin;
    /**
     * 用户Id
     */
    private String userId;
    /**
     * 区域代码(各地区产权所在行政区代码)
     */
    private String qydm;
}
