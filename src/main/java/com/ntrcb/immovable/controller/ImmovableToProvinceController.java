package com.ntrcb.immovable.controller;

import cn.hutool.json.JSONObject;
import com.ntrcb.common.annotation.ClassDescribe;
import com.ntrcb.common.annotation.Log;
import com.ntrcb.common.constant.MethodTypeEnum;
import com.ntrcb.common.constant.ReturnResult;
import com.ntrcb.immovable.entity.Immovable.req.*;
import com.ntrcb.immovable.entity.immovableToProvince.req.*;
import com.ntrcb.immovable.service.ImmovableService;
import com.ntrcb.immovable.service.ImmovableToProvinceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "南通市不动产接口")
@RestController
//@RequestMapping("/zhanye/ntrcbfrontbdc")
@RequestMapping("/ntrcbfrontbdc")
@ClassDescribe("南通市不动产接口")
public class ImmovableToProvinceController {
    @Autowired
    private ImmovableToProvinceService immovableToProvinceService;

    @ApiOperation(value = "贷前查询", consumes = "application/json", produces = "application/json")
    @PostMapping(value = "/cx", consumes = {"application/json"}, produces = {"application/json"})
    @Log(value = "贷前查询", paramsName = {"贷前查询"}, businessType = MethodTypeEnum.POST)
    public JSONObject cx(@RequestBody LoanAgoQueryEq loanAgoQueryEq) {
        return immovableToProvinceService.queryLoanList(loanAgoQueryEq);
    }

    @ApiOperation(value = "抵押登记创建接口", consumes = "application/json", produces = "application/json")
    @PostMapping(value = "/dydjcj", consumes = {"application/json"}, produces = {"application/json"})
    @Log(value = "抵押登记创建接口", paramsName = {"抵押登记创建接口"}, businessType = MethodTypeEnum.POST)
    public JSONObject dydjcj(@RequestBody PledgeRegisterEq pledgeRegisterEq) {
        return immovableToProvinceService.pledgeRegister(pledgeRegisterEq);
    }


    @ApiOperation(value = "抵押注销创建", consumes = "application/json", produces = "application/json")
    @PostMapping(value = "/dyzxcj", consumes = {"application/json"}, produces = {"application/json"})
    @Log(value = "抵押注销创建", paramsName = {"抵押注销创建"}, businessType = MethodTypeEnum.POST)
    public JSONObject dyzxcj(@RequestBody PledgeWriteOffRegisterEq pledgeWriteOffRegisterEq) {
        return immovableToProvinceService.pledgeWriteOffRegister(pledgeWriteOffRegisterEq);
    }

    @ApiOperation(value = "办件进度推送", consumes = "application/json", produces = "application/json")
    @PostMapping(value = "/bjjdts", consumes = {"application/json"}, produces = {"application/json"})
    @Log(value = "办件进度推送", paramsName = {"办件进度推送"}, businessType = MethodTypeEnum.POST)
    public JSONObject bjjdts(@RequestBody PlanPushBdcEq planPushBdcEq) {
        return  immovableToProvinceService.planPushBdc(planPushBdcEq);
    }

    @ApiOperation(value = "办件进度查询", consumes = "application/json", produces = "application/json")
    @PostMapping(value = "/bjjdcx", consumes = {"application/json"}, produces = {"application/json"})
    @Log(value = "办件进度查询", paramsName = {"办件进度查询"}, businessType = MethodTypeEnum.POST)
    public JSONObject bjjdcx(@RequestBody PlanQueryegisterEq planQueryegisterEq) {
        return immovableToProvinceService.queryPlanPushBdc(planQueryegisterEq);
    }


    @ApiOperation(value = "电子证照信息查询", consumes = "application/json", produces = "application/json")
    @PostMapping(value = "/dzzzxxcx", consumes = {"application/json"}, produces = {"application/json"})
    @Log(value = "电子证照信息查询", paramsName = {"电子证照信息查询"}, businessType = MethodTypeEnum.POST)
    public JSONObject dzzzxxcx(@RequestBody CertIdBdcQueryEq certIdBdcQueryEq) {
        return immovableToProvinceService.queryCertIdBdc(certIdBdcQueryEq);
    }

}


