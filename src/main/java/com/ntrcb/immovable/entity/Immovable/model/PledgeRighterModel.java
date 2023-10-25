package com.ntrcb.immovable.entity.Immovable.model;


import lombok.Data;

/**
 * 抵押权利人
 */
@Data
public class PledgeRighterModel {

    //权利人名称
    private String qlrmc;
    //权利人证件号
    private String qlrzjh;
    //权利人证件种类
    private String qlrzjzl;
    //权利人联系电话
    private String qlrlxdh;
    //权利人代理人姓名
    private String qlrdlrmc;
    //权利人代理人证件号
    private String qlrdlrzjh;
    //权利人代理人证件种类
    private String qlrdlrzjzl;
    // 权利人代理人联系电话
    private String qlrdlrlxdh;
    //权利人种类代码
    private String qlrzldm;
    //权利人种类名称
    private String qlrzlmc;
    //权利人法定代表人
    private String qlrfddbr;
    //权利人法定代表人证件种类代码
    private String qlrfddbrzjzl;
    //权利人法定代表人证件种类名称
    private String qlrfddbrzjzlmc;
    //权利人法定代表人证件号
    private String qlrfddbrzjh;
    //是否月结
    private String sfyj;
    //共有方式代码
    private String gyfsdm;
    //共有方式名称
    private String gyfsmc;
}
