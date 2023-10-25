package com.ntrcb.immovable.entity.Immovable.model;

import lombok.Data;

/**
 * 债务人信息
 */
@Data
public class DebtorModel {

    //债务人姓名
    private String zwrmc;
    //债务人身份证件种类
    private String zwrsfzjzl;
    // 债务人证件号
    private String zwrzjh;
    // 债务人联系电话
    private String zwrlxdh;
    // 债务人种类代码
    private String zwrzldm;
    // 债务人种类名称
    private String zwrzlmc;
}
