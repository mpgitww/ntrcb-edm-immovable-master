package com.ntrcb.immovable.entity.Immovable.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 业务办结接口请求参数
 */
@Data
@ApiModel(value = "BusinessFinishEq", description = "业务办结接口请求参数")
public class ContractDownEq {

    @ApiModelProperty(value = "受理编号")
    private String slbh;

}
