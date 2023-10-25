package com.ntrcb.immovable.entity.Res0541;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Org NTRCB
 * @Author: 06101675
 * @Description:
 * @Date: create in 2022/8/26 15:27
 */
@Data
public class Res0541RootBodyHead {
    @ApiModelProperty(value = "商户平台",required = true)
    private String stdmersys;
    @ApiModelProperty(value = "个人公积金账号",required = true)
    private String stdmerno;
    @ApiModelProperty(value = "信息校验结果",required = true,example = "1:通过；0不通过")
    private String stdmerrslt;
    @ApiModelProperty(
            value = "申请人信息未通过项",
            required = true,
            example = "1:个人编号不存在; 2:证件信息不匹配;3:姓名不匹配"
    )
    private String stdrslttp;
}
