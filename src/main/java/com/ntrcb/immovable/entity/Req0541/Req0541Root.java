package com.ntrcb.immovable.entity.Req0541;

import lombok.Data;
import com.ntrcb.immovable.entity.xmlReq.ReqRootHead;

/**
 * @Org NTRCB
 * @Author: 06101675
 * @Description: 0541-客户身份验证查询交易 请求根文件
 * @Date: create in 2022/8/26 15:18
 */
@Data
public class Req0541Root{
    private ReqRootHead head;
    private Req0541RootBody body;
}
