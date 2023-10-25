package com.ntrcb.immovable.controller;

import com.ntrcb.common.annotation.ClassDescribe;
import com.ntrcb.common.annotation.Log;
import com.ntrcb.common.constant.MethodTypeEnum;
import com.ntrcb.immovable.entity.Req0541.Req0541Root;
import com.ntrcb.immovable.entity.Req0542.Req0542Root;
import com.ntrcb.immovable.entity.Res0541.Res0541Root;
import com.ntrcb.immovable.entity.Res0542.Res0542Root;
import com.ntrcb.immovable.service.IHousing;
import com.ntrcb.common.constant.ReturnResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Org NTRCB
 * @Author: 06101675
 * @Description:
 * @Date: create in 2022/9/11 16:49
 */
@Api(tags = "南通市公积金中心接口")
@RestController
@RequestMapping("/housing")
@ClassDescribe("南通市公积金中心")
public class HousingController {
    @Resource
    IHousing housing;

    @ApiOperation(value = "0541-客户身份验证查询交易", consumes = "application/json", produces = "application/json")
    @PostMapping(value = "/invoke_0541", consumes = {"application/json"}, produces = {"application/json"})
    @Log(value = "0541-客户身份验证查询交易", paramsName = {"req0541Root"}, businessType = MethodTypeEnum.GET)
    public ReturnResult<Res0541Root> invoke_0541(@RequestBody @Validated Req0541Root req0541Root) {
        return ReturnResult.success(housing.invoke_0541(req0541Root));
    }

    @ApiOperation(value = "0542-客户公积金缴纳信息查询", consumes = "application/json", produces = "application/json")
    @PostMapping(value = "/invoke_0542", consumes = {"application/json"}, produces = {"application/json"})
    @Log(value = "0542-客户公积金缴纳信息查询", paramsName = {"req0542Root"}, businessType = MethodTypeEnum.GET)
    public ReturnResult<Res0542Root> invoke_0542(@RequestBody @Validated Req0542Root req0542Root) {
        return ReturnResult.success(housing.invoke_0542(req0542Root));
    }
}
