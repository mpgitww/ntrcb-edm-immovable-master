package com.ntrcb.immovable.entity.gjj.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 公积金查询请求参数
 */
@Data
@ApiModel(value = "QueryInfoReq", description = "公积金查询请求参数")
public class QueryInfoReq {


    @ApiModelProperty(value = "证件类型")
    private String certType;

    @ApiModelProperty(value = "证件号码")
    private String  certNumber;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "客户姓名")
    private String name;

    @ApiModelProperty(value = "个人公积金帐号")
    private String account;

}
