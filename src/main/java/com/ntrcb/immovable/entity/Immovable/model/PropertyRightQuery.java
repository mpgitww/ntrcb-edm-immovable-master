package com.ntrcb.immovable.entity.Immovable.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PropertyRightQuery {

    @ApiModelProperty(value = "授权开始时间")
    private String sqkssj;
    @ApiModelProperty(value = "授权结束时间")
    private String sqjssj;
    @ApiModelProperty(value = "行政区代码")
    private String xzqdm;
    @ApiModelProperty(value = "授权银行名称")
    private String sqyhmc;
    @ApiModelProperty(value = "授权银行证件号")
    private String sqyhzjh;
}
