package com.ntrcb.immovable.entity.Req0541;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Org NTRCB
 * @Author: 06101675
 * @Description:
 * @Date: create in 2022/8/26 15:09
 */
@Data
public class Req0541RootBodyHead {
    @ApiModelProperty(value = "证件类型",required = true,notes = "0:居民身份证")
    private String std400idtp;
    @ApiModelProperty(value = "证件号码",required = true)
    private String std400idno;
    @ApiModelProperty(value = "姓名",required = true)
    private String std400cunm;
    @ApiModelProperty(value = "商户平台",required = false,notes = "取值为固定值，根据具体业务分配编码")
    private String stdmersys;

}
