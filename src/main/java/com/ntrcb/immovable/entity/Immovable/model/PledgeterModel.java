package com.ntrcb.immovable.entity.Immovable.model;

import lombok.Data;

/**
 * 抵押人信息
 */
@Data
public class PledgeterModel {
    //姓名（名称）
    private String qlrmc;
    //证件号
    private String qlrzjh;
    //证件种类
    private String qlrzjzl;
    //联系电话
    private String qlrlxdh;
    //共有方式
    private Integer gyfs;
    //权利比例
    private Integer  qlbl;
    //顺序号
    private Integer sxh;
    //权利人种类代码
    private String qlrzldm;
    //权利人种类名称
    private String qlrzlmc;
    //共有方式名称
    private String gyfsmc;
}
