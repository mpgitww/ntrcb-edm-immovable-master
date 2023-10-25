package com.ntrcb.immovable.service;

import com.ntrcb.immovable.entity.gjj.req.QueryInfoReq;
import cn.hutool.json.JSONObject;

/**
 * @Org NTRCB
 * @Author: 06101758
 * @Description:
 * @Date: create in 2023、08、15
 */
public interface IHousingToProvinceService {

    JSONObject queryInfo(QueryInfoReq req);
}
