package com.ntrcb.immovable.entity.Immovable.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 证照文件下载接口请求参数
 */
@Data
@ApiModel(value = "CertDownEq", description = "证照文件下载接口请求参数")
public class CertDownEq {

    @ApiModelProperty(value = "证照标识")
    private String zzbs;

    @ApiModelProperty(value = "证照使用目的-水印显示内容")
    private String dzzzsymd;

    @ApiModelProperty(value = "行政区代码")
    private String xzqdm;


}
