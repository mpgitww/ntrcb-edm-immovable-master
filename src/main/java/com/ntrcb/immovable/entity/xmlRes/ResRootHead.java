package com.ntrcb.immovable.entity.xmlRes;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Org NTRCB
 * @Author: 06101675
 * @Description:
 * @Date: create in 2022/8/26 13:01
 */
@Data
public class ResRootHead {
    @ApiModelProperty(value = "发送方",required = true)
    private String sender;
    @ApiModelProperty(value = "接收方",required = true)
    private String receiver;
    @ApiModelProperty(value = "渠道",required = true)
    private String appid;
    @ApiModelProperty(value = "报文交易代码",required = true)
    private String transcode;
    @ApiModelProperty(value = "发送时间",required = true)
    private String trantime;
    @ApiModelProperty(value = "报文流水号",required = true)
    private String iseqno;
    @ApiModelProperty(value = "应答代码")
    private String retcode;
    @ApiModelProperty(value = "应答信息",required = true)
    private String retmsg;
    @ApiModelProperty(value = "报文响应流水号",required = false)
    private String oseqno;
}
