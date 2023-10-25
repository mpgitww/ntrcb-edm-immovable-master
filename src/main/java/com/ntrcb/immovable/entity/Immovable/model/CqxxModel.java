package com.ntrcb.immovable.entity.Immovable.model;

import lombok.Data;

import java.util.List;

/**
 * 权利人
 */
@Data
public class CqxxModel {

    //合同编号
    private String htbh;
    //合同签订日期
    private String htqdrq;
    //合同状态
    private String htzt;
    //交易价格
    private String jyjg;
    //备案日期
    private String barq;
    //登记小类申请类型
    private String xlsqdjlx;
    //项目id
    private String xmid;
    //登记原因
    private String djyy;
    //付款方式代码
    private String fkfsdm;
    //付款方式名称
    private String fkfsmc;
    //是否资金监管
    private String sfzjjg;
//    //税务信息
//    private List<String> swxx;
    //税务状态
    private String swzt;
    //登记原因代码
    private String djyydm;
    //登记原因名称
    private String djyymc;
    //是否按揭
    private String sfaj;
    //附记
    private String fj;
    //roomid
    private String roomid;
//    //过户信息
//    private List<String> ghxx;
    //是否涉税
    private String sfss;
    //收费信息
//    private List<String> sfxx;
    //备注
    private String bz;
    //不含增值税金额
    private String bhzzsje;
    //增值税金额
    private String zzsje;
    //含增值税金额
    private String hzzsje;
    //房屋结构代码
    private String fwjgdm;
    //房屋结构名称
    private String fwjgmc;
    //房屋性质代码
    private String fwxzdm;
    //房屋性质名称
    private String fwxzmc;
    //登记事由代码
    private String djsydm;
    //土地使用开始时间
    private String tdsykssj;
    //土地使用结束时间
    private String tdsyjssj;
    //土地用途代码
    private String tdytdm;
    //土地用途名称
    private String tdytmc;
    //土地权利性质代码
    private String tdqlxzdm;
    //土地权利性质名称
    private String tdqlxzmc;
    //宗地面积
    private String zdmj;
    //分摊土地面积
    private String fttdmj;
//    //更正信息
//    private List<String> gzxx;
    //权利人信息
    private List<Qlrxx> qlrxx;
    //附记信息
    private List<ExcursusModel> fjxx;
    //物流信息
    private List<LogisticsMegModel>wlxx;


}
