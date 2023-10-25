package com.ntrcb.immovable.entity.shebao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 社保信息查询请求参数
 */
@Data
@ApiModel(value = "QueryInfoReq", description = "社保查询请求参数")
public class QueryInfoReq {


    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "证件号码")
    private String  idcard;

}
