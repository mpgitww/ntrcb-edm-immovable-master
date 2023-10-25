package com.ntrcb.immovable.service;

import com.ntrcb.immovable.entity.Res0541.Res0541Root;
import com.ntrcb.immovable.entity.Req0541.Req0541Root;
import com.ntrcb.immovable.entity.Req0542.Req0542Root;
import com.ntrcb.immovable.entity.Res0542.Res0542Root;

/**
 * @Org NTRCB
 * @Author: 06101675
 * @Description:
 * @Date: create in 2022/9/8 14:05
 */
public interface IHousing {

    Res0541Root invoke_0541(Req0541Root req);

    Res0542Root invoke_0542(Req0542Root req);
}
