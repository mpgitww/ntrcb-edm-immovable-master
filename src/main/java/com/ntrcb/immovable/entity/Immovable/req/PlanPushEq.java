package com.ntrcb.immovable.entity.Immovable.req;

import lombok.Data;

/**
 * 不动产办件进度推送接口参数
 */
@Data
public class PlanPushEq {

    //受理编号
    private String centerNumber;
    //办结时间yyyyMMdd HH:mm:ss
    private String actionTime;
    //办理结果 1成功 2失败
    private String result;
    //抵押电子证明号（仅办理成功有值）
    private String cardNumber;
    //办理失败信息（仅办理失败有值）
    private String message;
    //行政区代码
    private String xzqdm;

}
