package com.ntrcb.immovable.entity.Immovable.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 抵押信息
 */
@Data
public class PledgeMegModel {
    //抵押方式
    private String dyfs;
    //被担保主债权数额（最高债权数额）
    private String bdbzzqse;
    //债务履行开始期限
    private Date zwlxksqx;
    //债务履行结束期限
    private Date zwlxjsqx;
    //附记
    private String fj;
    //抵押顺位
    private String qlsx;
    //抵押范围
    private String dyfw;
    //抵押证明号
    private String bdcdjzmh;
    //贷款方式
    private String dkfs;
    //抵押套数
    private String dyts;
    //抵押物价值
    private String dywjz;
    //币种代码
    private String bzdm;
    //币种名称
    private String bzmc;
    //担保范围
    private String dbfw;
    //是否禁止抵押期间抵押物转让
    private String sfjzdyqjdywzr;
    //最高债权额
    private BigDecimal zgzqe;
    //权利类型
    private String qllx;
    //权利类型名称
    private String qllxmc;
    //小类申请登记类型
    private String xlsqdjlx;
    //房屋抵押面积
    private String fwdymj;
    //土地抵押面积
    private String tddymj;
}
