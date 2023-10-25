package com.ntrcb.immovable.entity.Immovable.model;

import lombok.Data;

import java.util.List;

/**
 * 预告预抵押项目创建主体
 */
@Data
public class AdvanceNoticeRegisterModel {
    //业务号
    private String ywh;
    //申请登记类型
    private String sqdjlx;
    //预约部门编码
    private String yybmbm;
    //证书来源
    private String zsly;
    //是否涉税
    private String sfss;
    //预审提示信息
    private String ystsxx;
    //送达时间
    private String sdss;
    //预审人
    private String ysr;
    //预审时间
    private String yssj;
    //预约开始时间
    private String yykssj;
    //预约结束时间
    private String yyjssj;
    //申请人id
    private String sqrid;
    //单位代码
    private String dwdm;
    //自动转发
    private String zdzf;
    //特殊标记
    private String tsbj;
    //创建人角色名称
    private String cjrjsmc;
    //房源编号
    private String fybh;
    //跳过节点数
    private String tgjds;
    //受理来源
    private String slly;
    //受理人
    private String slr;
    //申请人证件号
    private String sqrzjh;
    //不动产单元信息
    private List<ElementInfoModel> bdcdyxx;

}