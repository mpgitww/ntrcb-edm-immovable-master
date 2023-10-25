package com.ntrcb.immovable.entity.immovableToProvince.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 证照信息查询接口参数
 */
@Data
public class CertIdBdcQueryEq {

    @ApiModelProperty(value = "受理编号")
    private String slbh;

    @ApiModelProperty(value = "抵押证明号")
    private String bdctxzmh;

    @ApiModelProperty(value = "权利人名称")
    private String qlrmc;

    @ApiModelProperty(value = "权利人证件号")
    private String qlrzjh;

    @ApiModelProperty(value = "行政区域代码")
    private String qydm;


}
