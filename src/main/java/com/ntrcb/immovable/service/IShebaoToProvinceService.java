package com.ntrcb.immovable.service;

import cn.hutool.json.JSONObject;
import com.ntrcb.immovable.entity.shebao.QueryInfoReq;

/**
 * @Org NTRCB
 * @Author: 06101758
 * @Description:
 * @Date: create in 2023、08、29
 */
public interface IShebaoToProvinceService {

    JSONObject queryInfo(QueryInfoReq req);
}
