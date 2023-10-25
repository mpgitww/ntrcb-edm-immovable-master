package com.ntrcb.immovable.entity.Immovable.model;

import lombok.Data;

/**
 * 抵押注销抵押人信息
 */
@Data
public class PledgeWriteOffManModel {
    //申请人名称
    private String qlrmc;
    //申请人证件号
    private String qlrzjh;
    //证件种类
    private String qlrzjzl;
    //联系电话
    private String qlrlxdh;
    //代理人姓名
    private String qlrdlrmc;
    //代理人证件号
    private String qlrdlrzjh;
    //代理人证件种类
    private String qlrdlrzjzl;
    //代理人联系电话
    private String qlrdlrlxdh;
    //权利人证件名称
    private String qlrzjmc;
    //权利人种类代码
    private String qlrzldm;
    //权利人种类名称
    private String qlrzlmc;
    //共有方式
    private String gyfs;
    //共有方式名称
    private String gyfsmc;
    //权利比例
    private Integer qlbl;
}
