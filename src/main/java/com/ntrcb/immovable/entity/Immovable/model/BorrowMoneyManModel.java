package com.ntrcb.immovable.entity.Immovable.model;

import lombok.Data;

/**
 * 借款人
 */
@Data
public class BorrowMoneyManModel {
    // 借款人姓名
    private String jkrmc;
    //借款人身份证件种类
    private String jkrsfzjzl;
    //借款人证件号
    private String jkrzjh;
    // 借款人联系电话
    private String jkrlxdh;
}
