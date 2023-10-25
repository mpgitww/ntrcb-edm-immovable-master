package com.ntrcb.common.constant;

/*
 * Author:06101675
 * Datetime: 2022/10/26 17:31
 * Description:
 */

import lombok.Getter;

/**
 * 业务操作类型
 */
public enum MethodTypeEnum {
    /**
     * 其它
     */
    OTHER("其他", 0),

    /**
     * 新增
     */
    POST("POST", 1),

    /**
     * 修改
     */
    GET("GET", 2),

    ;
    @Getter
    private final String name;
    @Getter
    private final Integer value;

    MethodTypeEnum(String name, Integer value) {
        this.name = name;
        this.value = value;
    }
}