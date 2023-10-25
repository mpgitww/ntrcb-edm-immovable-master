package com.ntrcb.immovable.service;

import cn.hutool.json.JSONObject;
import com.ntrcb.immovable.entity.immovableToProvince.req.*;

public interface ImmovableToProvinceService {


    /**
     * 贷前查询
     */
    JSONObject queryLoanList(LoanAgoQueryEq loanAgoQueryEq);

    /**
     * 抵押登记
     * @param pledgeRegisterEq
     * @return
     */
    JSONObject pledgeRegister(PledgeRegisterEq pledgeRegisterEq);

    /**
     * 抵押注销登记
     * @param pledgeWriteOffRegisterEq
     * @return
     */
    JSONObject pledgeWriteOffRegister(PledgeWriteOffRegisterEq pledgeWriteOffRegisterEq);

    /**
     * 推送
     * @param planPushBdcEq
     * @return
     */
    JSONObject planPushBdc(PlanPushBdcEq planPushBdcEq);

    /**
     * 办件查询
     * @param planQueryegisterEq
     * @return
     */
    JSONObject queryPlanPushBdc(PlanQueryegisterEq planQueryegisterEq);


    /**
     *电子证照信息查询
     * @param certIdBdcQueryEq
     * @return
     */
    JSONObject queryCertIdBdc(CertIdBdcQueryEq certIdBdcQueryEq);
}
