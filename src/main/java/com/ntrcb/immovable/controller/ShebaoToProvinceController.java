package com.ntrcb.immovable.controller;

import cn.hutool.json.JSONObject;
import com.ntrcb.common.annotation.ClassDescribe;
import com.ntrcb.common.annotation.Log;
import com.ntrcb.common.constant.MethodTypeEnum;
import com.ntrcb.immovable.entity.shebao.QueryInfoReq;
import com.ntrcb.immovable.service.IShebaoToProvinceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 社保使用静态数据导入的方式，暂时不用
 */
@Api(tags = "南通市社保接口")
@RestController
@RequestMapping("/zhanye/ntrcbfrontsb")
@ClassDescribe("南通市社保接口")
public class ShebaoToProvinceController {

    @Autowired
    private IShebaoToProvinceService shebaoToProvinceService;

    @ApiOperation(value = "社保信息查询", consumes = "application/json", produces = "application/json")
    @PostMapping(value = "/cx", consumes = {"application/json"}, produces = {"application/json"})
    @Log(value = "社保信息查询", paramsName = {"社保信息查询"}, businessType = MethodTypeEnum.POST)
    public JSONObject cx(@RequestBody QueryInfoReq queryInfoReq) {
        return shebaoToProvinceService.queryInfo(queryInfoReq);
    }
}
