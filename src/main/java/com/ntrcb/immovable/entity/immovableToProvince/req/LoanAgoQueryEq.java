package com.ntrcb.immovable.entity.immovableToProvince.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 贷前查询接口请求参数
 */
@Data
@ApiModel(value = "LoanQueryEq", description = "贷前查询接口请求参数")
public class LoanAgoQueryEq {


    @ApiModelProperty(value = "查询类型")
    private String lx;

    @ApiModelProperty(value = "权利人姓名")
    private String qlrName;

    @ApiModelProperty(value = "权利人证件类型")
    private String qlrCertType;

    @ApiModelProperty(value = "权利人证件号码")
    private String qlrCertId;

    @ApiModelProperty(value = "权利人类型")
    private String qlrlx;

    @ApiModelProperty(value = "不动产权证号")
    private String bzcqzh;

    @ApiModelProperty(value = "不动产单元号")
    private String bdcdyh;

    @ApiModelProperty(value = "不动产坐落")
    private String bdzl;

    @ApiModelProperty(value = "抵押证明号")
    private String dyzmh;

    @ApiModelProperty(value = "行政区域代码")
    private String qydm;

    @ApiModelProperty(value = "授权书")
    private String sqcl;
}
