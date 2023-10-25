package com.ntrcb.immovable.service.imp;

import com.ntrcb.common.constant.ReturnResult;
import com.ntrcb.immovable.entity.Immovable.model.HttpHeadModel;
import com.ntrcb.immovable.entity.Immovable.req.*;
import com.ntrcb.immovable.service.EsbService;
import com.ntrcb.immovable.service.ImmovableService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 不动产
 */
@Service
@Slf4j
public class ImmovableServiceImpl implements ImmovableService {
    @Resource
    private EsbService esbService;

    @Override
    public ReturnResult queryLoanList(LoanQueryEq loanQueryEq) {
        String url = "http://66.143.97.99:8091/exchange/rest/v2/wwsq/bdcfyxx";
        HttpHeadModel token = getToken();
        token.setQydm("320600");
        token.setUserId("b63527dbff7d45b29658c96b6cc2d7b7");
        Map<String, Object> resMap = esbService.sendPost(url, token, loanQueryEq);
        return getResData(resMap);
    }

    @Override
    public ReturnResult queryProductRightInfo(ProductRightInfoEq productRightInfoEq) {
        String url = "http://66.143.97.99:8091/exchange/rest/v2/yhwwsq/bdczscx";
        HttpHeadModel token = getToken();
        token.setQydm("320600");
        token.setUserId("b63527dbff7d45b29658c96b6cc2d7b7");
        Map<String, Object> resMap = esbService.sendPost(url, token, productRightInfoEq);
        return getResData(resMap);

    }


    @Override
    public ReturnResult pledgeRegister(PledgeReq pledgeReq) {
        String url = "http://66.143.97.99:8091/exchange/rest/v2/yhwwsq/dydj";
        HttpHeadModel token = getToken();
        token.setQydm("320600");
        token.setUserId("b63527dbff7d45b29658c96b6cc2d7b7");
        Map<String, Object> resMap = esbService.sendPostForList(url, token, pledgeReq.getPledgeList());
        return getResData(resMap);
    }

    @Override
    public ReturnResult queryPledgeWriteOff(PledgeWriteOffQueryEq pledgeWriteOffQueryEq) {
        String url = "http://66.143.97.99:8091/exchange/rest/v2/yhwwsq/bdczmcx";
        HttpHeadModel token = getToken();
        token.setQydm("320600");
        token.setUserId("b63527dbff7d45b29658c96b6cc2d7b7");
        Map<String, Object> resMap = esbService.sendPost(url, token, pledgeWriteOffQueryEq);
        return getResData(resMap);
    }

    @Override
    public ReturnResult pledgeWriteOff(PledgeWriteOffEq pledgeWriteOffEq) {
        String url = "http://66.143.97.99:8091/exchange/rest/v2/yhwwsq/dyzx";
        HttpHeadModel token = getToken();
        token.setQydm("320600");
        token.setUserId("b63527dbff7d45b29658c96b6cc2d7b7");
        Map<String, Object> resMap = esbService.sendPostForList(url, token, pledgeWriteOffEq.getPledgeWriteOffList());
        return getResData(resMap);
    }


    @Override
    public ReturnResult planPush(PlanPushEq planPushEq) {
        String url = "http://66.143.97.99:8091/exchange/rest/v2/yhwwsq/dyzx";
        HttpHeadModel token = getToken();
        token.setQydm("320600");
        token.setUserId("b63527dbff7d45b29658c96b6cc2d7b7");
        Map<String, Object> resMap = esbService.sendPostForNoData(url, token, planPushEq);
        return getResData(resMap);
    }

    @Override
    public ReturnResult businessFinish(BusinessFinishEq businessFinishEq) {
        String url = "http://66.143.97.99:8091/exchange/rest/v2/yhwwsq/ywbj";
        HttpHeadModel token = getToken();
        token.setQydm("320600");
        token.setUserId("b63527dbff7d45b29658c96b6cc2d7b7");
        Map<String, Object> resMap = esbService.sendPost(url, token, businessFinishEq);
        return getResData(resMap);
    }

    @Override
    public ReturnResult queryCert(CertIdQueryEq certIdQueryEq) {
        String url = "http://66.143.97.99:8091/exchange/rest/v2/yhwwsq/zzjs";
        HttpHeadModel token = getToken();
        token.setQydm("320600");
        token.setUserId("b63527dbff7d45b29658c96b6cc2d7b7");
        Map<String, Object> resMap = esbService.sendPost(url, token, certIdQueryEq);
        return getResData(resMap);
    }

    @Override
    public ReturnResult certDown(CertDownEq certDownEq) {
        String url = "http://66.143.97.99:8091/exchange/rest/v2/yhwwsq/zzwjxz";
        HttpHeadModel token = getToken();
        token.setQydm("320600");
        token.setUserId("b63527dbff7d45b29658c96b6cc2d7b7");
        Map<String, Object> resMap = esbService.sendPost(url, token, certDownEq);
        return getResData(resMap);
    }

    @Override
    public ReturnResult attachmentUpload(AttachmentUploadEq attachmentUploadEq) {
        String url = "http://66.143.97.99:8091/exchange/rest/v2/yhwwsq/tsWwsqFjxx";
        HttpHeadModel token = getToken();
        token.setQydm("320600");
        token.setUserId("b63527dbff7d45b29658c96b6cc2d7b7");
        Map<String, Object> resMap = esbService.sendPost(url, token, attachmentUploadEq);
        return getResData(resMap);
    }

    @Override
    public ReturnResult contractDown(ContractDownEq contractDownEq) {
        String url = "http://66.143.97.99:8091/exchange/rest/v2/yhwwsq/sqsxz";
        HttpHeadModel token = getToken();
        token.setQydm("320600");
        token.setUserId("b63527dbff7d45b29658c96b6cc2d7b7");
        Map<String, Object> resMap = esbService.sendPost(url, token, contractDownEq);
        return getResData(resMap);
    }

    @Override
    public ReturnResult withdrawalPush(ContractDownEq contractDownEq) {
        String url = "http://66.143.97.99:8091/exchange/rest/v2/yhwwsq/cjts";
        HttpHeadModel token = getToken();
        token.setQydm("320600");
        token.setUserId("b63527dbff7d45b29658c96b6cc2d7b7");
        Map<String, Object> resMap = esbService.sendPost(url, token, contractDownEq);
        return getResData(resMap);
    }

    @Override
    public ReturnResult queryPropertyRight(PropertyRightQueryEq propertyRightQueryEq) {
        String url = "http://66.143.97.99:8091/exchange/rest/v2/yhwwsq/sqcqxxcx";
        HttpHeadModel token = getToken();
        token.setQydm("320600");
        token.setUserId("b63527dbff7d45b29658c96b6cc2d7b7");
        Map<String, Object> resMap = esbService.sendPostToPage(url, token, propertyRightQueryEq.getPageInfo(), propertyRightQueryEq.getPropertyRightQuery());
        return getResData(resMap);
    }

    @Override
    public ReturnResult queryElement(ElementQueryEq elementQueryEq) {
        String url = "http://66.143.97.99:8091/exchange/rest/v2/yhwwsq/sqcqxxcx";
        HttpHeadModel token = getToken();
        token.setQydm("320600");
        token.setUserId("b63527dbff7d45b29658c96b6cc2d7b7");
        Map<String, Object> resMap = esbService.sendPost(url, token, elementQueryEq);
        return getResData(resMap);
    }

    @Override
    public ReturnResult queryAdvanceNotice(AdvanceNoticeQueryEq advanceNoticeQueryEq) {
        String url = "http://66.143.97.99:8091/exchange/rest/v2/yhwwsq/getYgxx";
        HttpHeadModel token = getToken();
        token.setQydm("320600");
        token.setUserId("b63527dbff7d45b29658c96b6cc2d7b7");
        Map<String, Object> resMap = esbService.sendPost(url, token, advanceNoticeQueryEq);
        return getResData(resMap);
    }

    @Override
    public ReturnResult insertAdvanceNoticeRegister(AdvanceNoticeRegisterEq advanceNoticeRegisterEq) {
        String url = "http://66.143.97.99:8091/exchange/rest/v2/yhwwsq/initWwsqxxAndFj";
        HttpHeadModel token = getToken();
        token.setQydm("320600");
        token.setUserId("b63527dbff7d45b29658c96b6cc2d7b7");
        Map<String, Object> resMap = esbService.sendPost(url, token, advanceNoticeRegisterEq.getAdvanceNoticeRegisterModel());
        return getResData(resMap);
    }

    @Override
    public ReturnResult downFjxx(DownFjxxEq downFjxxEq) {
        String url = "http://66.143.97.99:8091/exchange/rest/v2/yhwwsq/fjxz";
        HttpHeadModel token = getToken();
        token.setQydm("320600");
        token.setUserId("b63527dbff7d45b29658c96b6cc2d7b7");
        Map<String, Object> resMap = esbService.sendPost(url, token, downFjxxEq);
        return getResData(resMap);
    }

    @Override
    public ReturnResult updateFjxx(UpdateFjxxEq updateFjxxEq) {
        String url = "http://66.143.97.99:8091/exchange/rest/v2/yhwwsq/WwsqFjxx";
        HttpHeadModel token = getToken();
        token.setQydm("320600");
        token.setUserId("b63527dbff7d45b29658c96b6cc2d7b7");
        Map<String, Object> resMap = esbService.sendPost(url, token, updateFjxxEq);
        return getResData(resMap);
    }

    @Override
    public ReturnResult queryEarlyWarning(EarlyWarningQueryEq earlyWarningQueryEq) {
        String url = "http://66.143.97.99:8091/exchange/rest/v2/wwsq/dyyjcx";
        HttpHeadModel token = getToken();
        token.setQydm("320600");
        token.setUserId("b63527dbff7d45b29658c96b6cc2d7b7");
        Map<String, Object> resMap = esbService.sendPost(url, token, earlyWarningQueryEq);
        return getResData(resMap);
    }

    @Override
    public ReturnResult queryLoansLater(LoansLaterQueryEq loansLaterQueryEq) {
        String url = "http://66.143.97.99:8091/exchange/rest/v2/wwsq/dhqlxxcx";
        HttpHeadModel token = getToken();
        token.setQydm("320600");
        token.setUserId("b63527dbff7d45b29658c96b6cc2d7b7");
        Map<String, Object> resMap = esbService.sendPost(url, token, loansLaterQueryEq);
        return getResData(resMap);
    }

    /**
     * 获取token
     *
     * @return
     */
    private HttpHeadModel getToken() {
        HttpHeadModel headModel = new HttpHeadModel();
        String url = "http://66.143.97.99:8091/exchange/rest/auth/token";
        Map<String, Object> headMap = new HashMap<>();
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("lxDh", "18021659209");
        dataMap.put("userPwd", getPassword("Ntnsh123456"));
        dataMap.put("loginType", "organize");
        Map<String, Object> resMap = esbService.sendPost(url, headMap, dataMap);
        //判断head是否存在
        if (resMap.containsKey("head")) {
            Map<String, Object> resTokenMap = (Map<String, Object>) resMap.get("head");
            //是否返回token
            if (resTokenMap.containsKey("access_token")) {
                headModel.setAccess_token(resTokenMap.get("access_token").toString());
                headModel.setSign(resTokenMap.get("sign").toString());
            }

        }

        return headModel;
    }

    /**
     * 获取加密后的密码
     *
     * @return
     */
    private String getPassword(String password) {
        String encodeValue = "";
        String url = "http://66.143.97.99:8091/estateplat-olcommon/api/v2/queryModel/encrypt";
        Map<String, Object> headMap = new HashMap<>();
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("encodeKey", password);
        Map<String, Object> resMap = esbService.sendPost(url, headMap, dataMap);
        //判断data是否存在
        if (resMap.containsKey("data")) {
            Map<String, Object> resPasswordMap = (Map<String, Object>) resMap.get("data");
            //是否返回token
            if (resPasswordMap.containsKey("encodeValue")) {
                encodeValue = resPasswordMap.get("encodeValue").toString();
            }
        }
        return encodeValue;
    }


    /**
     * 转换为自己响应值，响应码，响应信息
     *
     * @return
     */
    private ReturnResult getResData(Map<String, Object> resMap) {
        ReturnResult returnResult = new ReturnResult();
        if (resMap.containsKey("head")) {
            Map<String, Object> headMap = (Map<String, Object>) resMap.get("head");
            if (headMap.containsKey("code")) {
                returnResult.setCode(headMap.get("code").toString());
                returnResult.setMessage(headMap.containsKey("msg") ? headMap.get("msg").toString() : "");
                returnResult.setData(resMap.get("data"));
            } else if (headMap.containsKey("statusCode")) {
                returnResult.setCode(headMap.get("statusCode").toString());
                returnResult.setMessage(headMap.containsKey("msg") ? headMap.get("msg").toString() : "");
                returnResult.setData(headMap.containsKey("msg") ? headMap.get("msg").toString() : null);
            }
        } else {
            if (resMap.containsKey("code")) {
                returnResult.setCode(resMap.get("code").toString());
                if (resMap.containsKey("msg")) {
                    returnResult.setMessage(resMap.get("msg").toString());
                } else if (resMap.containsKey("message")) {
                    returnResult.setMessage(resMap.get("message").toString());
                }
                if(resMap.containsKey("data")){
                    returnResult.setData(resMap.get("data"));
                }
            } else if (resMap.containsKey("error")) {
                returnResult.setCode(resMap.get("status").toString());
                returnResult.setMessage(resMap.get("message").toString());
            }
        }
        return returnResult;
    }

}
