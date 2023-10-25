package com.ntrcb.immovable.entity.Immovable.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 抵押注销流程获取抵押证明接口参数
 */
@Data
@ApiModel(value = "PledgeWriteOffQueryEq", description = "抵押注销流程获取抵押证明接口参数")
public class PledgeWriteOffQueryEq {

    @ApiModelProperty(value = "抵押证明号")
    private String bdcdjzmh;

    @ApiModelProperty(value = "抵押权人")
    private String dyqr;

    @ApiModelProperty(value = "抵押权人证件号")
    private String dyqrzjh;

    @ApiModelProperty(value = "抵押证明号简称")
    private String bdcdjzmhjc;

    @ApiModelProperty(value = "行政区代码")
    private String xzqdm;

    @ApiModelProperty(value = "抵押人名称")
    private String dyrmc;

    @ApiModelProperty(value = "抵押证明号(精确)")
    private String bdcdjzmhjq;


}
