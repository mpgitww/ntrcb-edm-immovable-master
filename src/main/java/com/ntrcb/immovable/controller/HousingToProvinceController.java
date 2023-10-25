package com.ntrcb.immovable.controller;

import cn.hutool.json.JSONObject;
import com.ntrcb.common.annotation.ClassDescribe;
import com.ntrcb.common.annotation.Log;
import com.ntrcb.common.constant.MethodTypeEnum;
import com.ntrcb.immovable.entity.gjj.req.QueryInfoReq;
import com.ntrcb.immovable.service.IHousingToProvinceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Org NTRCB
 * @Author: 06101758
 * @Description:
 * @Date: create in 2023/08/16 16:49
 */
@Api(tags = "南通市公积金中心接口")
@RestController
//生产url
//@RequestMapping("/zhanye/ntrcbfrontgjj")
@RequestMapping("/ntrcbfrontgjj")
@ClassDescribe("南通市公积金中心")
public class HousingToProvinceController {
    @Resource
    IHousingToProvinceService iHousingToProvinceService;

    @ApiOperation(value = "公积金查询", consumes = "application/json", produces = "application/json")
    @PostMapping(value = "/cx", consumes = {"application/json"}, produces = {"application/json"})
    @Log(value = "公积金查询", paramsName = {"公积金查询"}, businessType = MethodTypeEnum.POST)
    public JSONObject cx(@RequestBody QueryInfoReq queryInfoReq) {
        return iHousingToProvinceService.queryInfo(queryInfoReq);
    }
}
