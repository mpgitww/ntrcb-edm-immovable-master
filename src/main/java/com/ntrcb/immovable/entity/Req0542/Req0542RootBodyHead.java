package com.ntrcb.immovable.entity.Req0542;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Org NTRCB
 * @Author: 06101675
 * @Description:
 * @Date: create in 2022/9/11 14:28
 */
@Data
public class Req0542RootBodyHead {
    @ApiModelProperty(value = "商户平台",required = true,notes = "取值为固定值，根据具体业务分配编码")
    private String stdmersys;
    @ApiModelProperty(value = "个人公积金账号",required = true)
    private String stdmerno;
}
