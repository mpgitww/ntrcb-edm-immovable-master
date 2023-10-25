package com.ntrcb.immovable.controller;

import com.ntrcb.common.annotation.ClassDescribe;
import com.ntrcb.common.annotation.Log;
import com.ntrcb.common.constant.MethodTypeEnum;
import com.ntrcb.common.constant.ReturnResult;
import com.ntrcb.immovable.entity.Immovable.model.AdvanceNoticeRegisterModel;
import com.ntrcb.immovable.entity.Immovable.req.*;
import com.ntrcb.immovable.service.ImmovableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "南通市不动产接口")
@RestController
@RequestMapping("/realEstate")
@ClassDescribe("南通市不动产接口")
public class ImmovableController {
    @Autowired
    private ImmovableService immovableService;

    @ApiOperation(value = "贷前查询", consumes = "application/json", produces = "application/json")
    @PostMapping(value = "/bdcfyxx", consumes = {"application/json"}, produces = {"application/json"})
    @Log(value = "贷前查询", paramsName = {"贷前查询"}, businessType = MethodTypeEnum.POST)
    public ReturnResult bdcfyxx(@RequestBody LoanQueryEq loanQueryEq) {
        return immovableService.queryLoanList(loanQueryEq);
    }

    @ApiOperation(value = "获取产权信息接口", consumes = "application/json", produces = "application/json")
    @PostMapping(value = "/bdczscx", consumes = {"application/json"}, produces = {"application/json"})
    @Log(value = "获取产权信息接口", paramsName = {"获取产权信息接口"}, businessType = MethodTypeEnum.POST)
    public ReturnResult bdczscx(@RequestBody ProductRightInfoEq productRightInfoEq) {
        return immovableService.queryProductRightInfo(productRightInfoEq);
    }

    @ApiOperation(value = "抵押设立项目创建接口", consumes = "application/json", produces = "application/json")
    @PostMapping(value = "/dydj", consumes = {"application/json"}, produces = {"application/json"})
    @Log(value = "抵押设立项目创建接口", paramsName = {"抵押设立项目创建接口"}, businessType = MethodTypeEnum.POST)
    public ReturnResult dydj(@RequestBody PledgeReq pledgeReq) {
        return immovableService.pledgeRegister(pledgeReq);
    }

    @ApiOperation(value = "抵押注销流程获取抵押证明接口", consumes = "application/json", produces = "application/json")
    @PostMapping(value = "/bdczmcx", consumes = {"application/json"}, produces = {"application/json"})
    @Log(value = "抵押注销流程获取抵押证明接口", paramsName = {"抵押注销流程获取抵押证明接口"}, businessType = MethodTypeEnum.POST)
    public ReturnResult bdczmcx(@RequestBody PledgeWriteOffQueryEq pledgeWriteOffQueryEq) {
        return immovableService.queryPledgeWriteOff(pledgeWriteOffQueryEq);
    }

    @ApiOperation(value = "抵押注销项目创建接口", consumes = "application/json", produces = "application/json")
    @PostMapping(value = "/dyzx", consumes = {"application/json"}, produces = {"application/json"})
    @Log(value = "抵押注销项目创建接口", paramsName = {"抵押注销项目创建接口"}, businessType = MethodTypeEnum.POST)
    public ReturnResult dyzx(@RequestBody PledgeWriteOffEq pledgeWriteOffEq) {
        return immovableService.pledgeWriteOff(pledgeWriteOffEq);
    }


    @ApiOperation(value = "不动产办件进度推送接口", consumes = "application/json", produces = "application/json")
    @PostMapping(value = "/dylcjgtz", consumes = {"application/json"}, produces = {"application/json"})
    @Log(value = "不动产办件进度推送接口", paramsName = {"不动产办件进度推送接口"}, businessType = MethodTypeEnum.POST)
    public ReturnResult dylcjgtz(@RequestBody PlanPushEq planPushEq) {
        return immovableService.planPush(planPushEq);
    }

    @ApiOperation(value = "业务办结接口", consumes = "application/json", produces = "application/json")
    @PostMapping(value = "/ywbj", consumes = {"application/json"}, produces = {"application/json"})
    @Log(value = "业务办结接口", paramsName = {"业务办结接口"}, businessType = MethodTypeEnum.POST)
    public ReturnResult ywbj(@RequestBody BusinessFinishEq businessFinishEq) {
        return immovableService.businessFinish(businessFinishEq);
    }


    @ApiOperation(value = "证照信息查询接口", consumes = "application/json", produces = "application/json")
    @PostMapping(value = "/zzjs", consumes = {"application/json"}, produces = {"application/json"})
    @Log(value = "证照信息查询接口", paramsName = {"证照信息查询接口"}, businessType = MethodTypeEnum.POST)
    public ReturnResult zzjs(@RequestBody CertIdQueryEq certIdQueryEq) {
        return immovableService.queryCert(certIdQueryEq);
    }


    @ApiOperation(value = "证照文件下载接口", consumes = "application/json", produces = "application/json")
    @PostMapping(value = "/zzwjxz", consumes = {"application/json"}, produces = {"application/json"})
    @Log(value = "证照文件下载接口", paramsName = {"证照文件下载接口"}, businessType = MethodTypeEnum.POST)
    public ReturnResult zzwjxz(@RequestBody CertDownEq certDownEq) {
        return immovableService.certDown(certDownEq);
    }


    @ApiOperation(value = "附件上传接口/电子签名交互", consumes = "application/json", produces = "application/json")
    @PostMapping(value = "/tsWwsqFjxx", consumes = {"application/json"}, produces = {"application/json"})
    @Log(value = "附件上传接口/电子签名交互", paramsName = {"附件上传接口/电子签名交互"}, businessType = MethodTypeEnum.POST)
    public ReturnResult tsWwsqFjxx(@RequestBody AttachmentUploadEq attachmentUploadEq) {
        return immovableService.attachmentUpload(attachmentUploadEq);
    }

    @ApiOperation(value = "申请书/抵押合同下载接口", consumes = "application/json", produces = "application/json")
    @PostMapping(value = "/sqsxz", consumes = {"application/json"}, produces = {"application/json"})
    @Log(value = "申请书/抵押合同下载接口", paramsName = {"申请书/抵押合同下载接口"}, businessType = MethodTypeEnum.POST)
    public ReturnResult sqsxz(@RequestBody ContractDownEq contractDownEq) {
        return immovableService.contractDown(contractDownEq);
    }

    @ApiOperation(value = "银行撤件推送接口", consumes = "application/json", produces = "application/json")
    @PostMapping(value = "/cjts", consumes = {"application/json"}, produces = {"application/json"})
    @Log(value = "银行撤件推送接口", paramsName = {"银行撤件推送接口"}, businessType = MethodTypeEnum.POST)
    public ReturnResult cjts(@RequestBody ContractDownEq contractDownEq) {
        return immovableService.withdrawalPush(contractDownEq);
    }

    @ApiOperation(value = "授权产权查询接口", consumes = "application/json", produces = "application/json")
    @PostMapping(value = "/sqcqxxcx", consumes = {"application/json"}, produces = {"application/json"})
    @Log(value = "授权产权查询接口", paramsName = {"授权产权查询接口"}, businessType = MethodTypeEnum.POST)
    public ReturnResult sqcqxxcx(@RequestBody PropertyRightQueryEq propertyRightQueryEq) {
        return immovableService.queryPropertyRight(propertyRightQueryEq);
    }

    @ApiOperation(value = "查询不动产单元信息接口", consumes = "application/json", produces = "application/json")
        @PostMapping(value = "/queryBdcdyxx", consumes = {"application/json"}, produces = {"application/json"})
    @Log(value = "查询不动产单元信息接口", paramsName = {"查询不动产单元信息接口"}, businessType = MethodTypeEnum.POST)
    public ReturnResult queryBdcdyxx(@RequestBody ElementQueryEq elementQueryEq) {
        return immovableService.queryElement(elementQueryEq);
    }

    @ApiOperation(value = "查询预告证明接口", consumes = "application/json", produces = "application/json")
    @PostMapping(value = "/getYgxx", consumes = {"application/json"}, produces = {"application/json"})
    @Log(value = "查询预告证明接口", paramsName = {"查询预告证明接口"}, businessType = MethodTypeEnum.POST)
    public ReturnResult getYgxx(@RequestBody AdvanceNoticeQueryEq advanceNoticeQueryEq) {
        return immovableService.queryAdvanceNotice(advanceNoticeQueryEq);
    }

    @ApiOperation(value = "预告预抵押项目创建接口", consumes = "application/json", produces = "application/json")
    @PostMapping(value = "/initWwsqxxAndFj", consumes = {"application/json"}, produces = {"application/json"})
    @Log(value = "预告预抵押项目创建接口", paramsName = {"预告预抵押项目创建接口"}, businessType = MethodTypeEnum.POST)
    public ReturnResult initWwsqxxAndFj(@RequestBody AdvanceNoticeRegisterEq advanceNoticeRegisterEq) {
        return immovableService.insertAdvanceNoticeRegister(advanceNoticeRegisterEq);
    }

    @ApiOperation(value = "银行下载附件信息接口", consumes = "application/json", produces = "application/json")
    @PostMapping(value = "/fjxz", consumes = {"application/json"}, produces = {"application/json"})
    @Log(value = "银行下载附件信息接口", paramsName = {"银行下载附件信息接口"}, businessType = MethodTypeEnum.POST)
    public ReturnResult fjxz(@RequestBody DownFjxxEq downFjxxEq) {
        return immovableService.downFjxx(downFjxxEq);
    }

    @ApiOperation(value = "附件更新", consumes = "application/json", produces = "application/json")
    @PostMapping(value = "/WwsqFjxx", consumes = {"application/json"}, produces = {"application/json"})
    @Log(value = "附件更新", paramsName = {"附件更新"}, businessType = MethodTypeEnum.POST)
    public ReturnResult WwsqFjxx(@RequestBody UpdateFjxxEq updateFjxxEq) {
        return immovableService.updateFjxx(updateFjxxEq);
    }
    
    @ApiOperation(value = "预警查询接口", consumes = "application/json", produces = "application/json")
    @PostMapping(value = "/dyyjcx", consumes = {"application/json"}, produces = {"application/json"})
    @Log(value = "预警查询接口", paramsName = {"预警查询接口"}, businessType = MethodTypeEnum.POST)
    public ReturnResult dyyjcx(@RequestBody EarlyWarningQueryEq earlyWarningQueryEq) {
        return immovableService.queryEarlyWarning(earlyWarningQueryEq);
    }

    @ApiOperation(value = "贷后查询接口", consumes = "application/json", produces = "application/json")
    @PostMapping(value = "/dhqlxxcx", consumes = {"application/json"}, produces = {"application/json"})
    @Log(value = "贷后查询接口", paramsName = {"附件更新"}, businessType = MethodTypeEnum.POST)
    public ReturnResult dhqlxxcx(@RequestBody LoansLaterQueryEq loansLaterQueryEq) {
        return immovableService.queryLoansLater(loansLaterQueryEq);
    }

}
