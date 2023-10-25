package com.ntrcb.immovable.entity.Immovable.model;

import lombok.Data;

/**
 * 家庭成员信息
 *
 */
@Data
public class JtcyModel {

    //家庭成员名称
    private String jtcymc;
    //家庭成员证件号
    private String jtcyzjh;
    //与买（卖）家关系
    private String jtgx;
    //与买（卖）家关系名称
    private String jtgxmc;
    //家庭成员证件种类
    private String jtcyzjzl;
}
