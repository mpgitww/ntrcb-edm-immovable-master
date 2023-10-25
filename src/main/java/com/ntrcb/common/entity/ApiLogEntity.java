package com.ntrcb.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
@TableName("zyapi.house_api_log")
public class ApiLogEntity {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 备注
     */
    @TableField("description")
    private String description;

    /**
     * 类型
     */
    @TableField("type")
    private Integer type;

    /**
     * 操作ip
     */
    @TableField("ip")
    private String ip;

    /**
     * 状态
     */
    @TableField("status")
    private String status;

    /**
     * 请求地址
     */
    @TableField("request_url")
    private String requestUrl;

    /**
     * 请求方法
     */
    @TableField("request_method")
    private String requestMethod;

    /**
     * 操作方法
     */
    @TableField("method")
    private String method;

    /**
     * 请求参数
     */
    @TableField("request_params")
    private String requestParams;

    /**
     * 响应参数
     */
    @TableField("request_result")
    private String requestResult;

    /**
     * 错误信息
     */
    @TableField("error_message")
    private String errorMessage;

    /**
     * 日志时间
     */
    @TableField("log_time")
    private Date logTime;
}
