package com.ntrcb.immovable.entity.Res0541;

import lombok.Data;
import com.ntrcb.immovable.entity.xmlRes.ResRootHead;

/**
 * @Org NTRCB
 * @Author: 06101675
 * @Description: 0541-客户身份验证查询交易 返回根文件
 * @Date: create in 2022/8/26 15:26
 */
@Data
public class Res0541Root{
    private ResRootHead head;
    private Res0541RootBody body;
}
