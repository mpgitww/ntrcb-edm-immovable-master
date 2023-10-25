package com.ntrcb.immovable.service;

import com.ntrcb.common.constant.ReturnResult;
import com.ntrcb.immovable.entity.Immovable.req.*;

/**
 * 黄圣彦
 * 不动产
 */
public interface ImmovableService {

    /**
     * 贷前查询
     */
    ReturnResult queryLoanList(LoanQueryEq loanQueryEq);

    /**
     * 产权查询
     * @param productRightInfoEq
     * @return
     */
    ReturnResult queryProductRightInfo(ProductRightInfoEq productRightInfoEq);

    /**
     * 抵押登记
     * @param pledgeReq
     * @return
     */
    ReturnResult pledgeRegister(PledgeReq pledgeReq);

    /**
     * 抵押注销流程获取抵押证明
     * @param pledgeWriteOffQueryEq
     * @return
     */
    ReturnResult queryPledgeWriteOff(PledgeWriteOffQueryEq pledgeWriteOffQueryEq);

    /**
     * 抵押注销
     * @param pledgeWriteOffEq
     * @return
     */
    ReturnResult  pledgeWriteOff(PledgeWriteOffEq pledgeWriteOffEq);

    /**
     * 不动产办件进度推送接口
     * @param planPushEq
     * @return
     */
    ReturnResult planPush(PlanPushEq planPushEq);

    /**
     * 业务办结接口
     * @param businessFinishEq
     * @return
     */
    ReturnResult businessFinish(BusinessFinishEq businessFinishEq);

    /**
     * 业务办结接口
     * @param certIdQueryEq
     * @return
     */
    ReturnResult queryCert(CertIdQueryEq certIdQueryEq);

    /**
     * 证照文件下载
     * @param certDownEq
     * @return
     */
    ReturnResult certDown(CertDownEq certDownEq);

    /**
     * 附件上传接口/电子签名交互
     * @param attachmentUploadEq
     * @return
     */
    ReturnResult attachmentUpload(AttachmentUploadEq attachmentUploadEq);

    /**
     * 申请书/抵押合同下载接口
     * @param contractDownEq
     * @return
     */
    ReturnResult contractDown(ContractDownEq contractDownEq);


    /**
     * 银行撤件推送
     * @param contractDownEq
     * @return
     */
    ReturnResult withdrawalPush(ContractDownEq contractDownEq);


    /**
     * 授权产权查询接口
     * @param propertyRightQueryEq
     * @return
     */
    ReturnResult queryPropertyRight(PropertyRightQueryEq propertyRightQueryEq);
    /**
     * 查询不动产单元信息接口
     * @param elementQueryEq
     * @return
     */
    ReturnResult queryElement(ElementQueryEq elementQueryEq);

    /**
     * 查询预告证明接口
     * @param advanceNoticeQueryEq
     * @return
     */
    ReturnResult queryAdvanceNotice(AdvanceNoticeQueryEq advanceNoticeQueryEq);

    /**
     * 预告预抵押项目创建接口
     * @param  advanceNoticeRegisterEq
     * @return
     */
    ReturnResult insertAdvanceNoticeRegister(AdvanceNoticeRegisterEq advanceNoticeRegisterEq);

    /**
     * 银行下载附件信息接口
     * @param downFjxxEq
     * @return
     */
    ReturnResult downFjxx(DownFjxxEq downFjxxEq);
    /**
     * 银行下载附件信息接口
     * @param updateFjxxEq
     * @return
     */
    ReturnResult updateFjxx(UpdateFjxxEq updateFjxxEq);

    /**
     * 银行下载附件信息接口
     * @param earlyWarningQueryEq
     * @return
     */
    ReturnResult queryEarlyWarning(EarlyWarningQueryEq earlyWarningQueryEq);

    /**
     * 贷后查询接口
     * @param loansLaterQueryEq
     * @return
     */
    ReturnResult queryLoansLater(LoansLaterQueryEq loansLaterQueryEq);
}
