package com.ntrcb.immovable.entity.Immovable.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 贷前查询接口请求参数
 */
@Data
@ApiModel(value = "LoanQueryEq", description = "贷前查询接口请求参数")
public class LoanQueryEq {

    @ApiModelProperty(value = "权利人名称")
    private String qlrmc;

    @ApiModelProperty(value = "权利人名称")
    private String cqzh;

    @ApiModelProperty(value = "行政区代码")
    private String xzqdm;

    @ApiModelProperty(value = "区域代码")
    private String qydm;
}
