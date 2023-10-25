package com.ntrcb.immovable.entity.xmlReq;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Org NTRCB
 * @Author: 06101675
 * @Description:
 * @Date: create in 2022/8/26 12:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqRootHead{
    @ApiModelProperty(value = "发送方",required = true,example = "BOJ01")
    private String sender;
    @ApiModelProperty(value = "接收方",required = true,example = "G01")
    private String receiver;
    @ApiModelProperty(value = "渠道",required = true,example = "01")
    private String appid;
    @ApiModelProperty(value = "报文交易代码",required = true,notes = "两位银行代码+0541",example = "0541-客户身份验证查询交易：340541，0542-客户公积金缴纳信息查询：340542")
    private String transcode;
    @ApiModelProperty(value = "发送时间(yyyyMMddhhmmss)",required = true, example = "20110710150312")
    private String trantime;
    @ApiModelProperty(value = "报文流水号(yyMMddHHmmss + 4位随机数)",required = true)
    private String iseqno;
}
