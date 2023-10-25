package com.ntrcb.immovable.entity.Immovable.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 预约-抵押信息
 */
@Data
public class DyxxModel {
    //被担保主债权数额（最高债权数额）
    private String bdbzzqse;
    //抵押方式
    private String dyfs;
    //债务履行开始期限
    private Date zwlxksqx;
    //债务履行结束期限
    private Date zwlxjsqx;
    //登记小类申请类型
    private String xlsqdjlx;
    //项目id
    private String xmid;
    //登记原因
    private String djyy;
    //抵押顺位
    private String dysw;
    //备注
    private String bz;
    //评估价值
    private String pgjz;
    //登记原因代码
    private String djyydm;
    //登记原因名称
    private String djyymc;
    //抵押证明号
    private String bdcqzh;
    //债务人
    private String zwr;
    //不动产价值（抵押物价值）
    private String bdcjz;
    //贷款方式
    private String dkfs;
    //贷款方式名称
    private String dkfsmc;
    //最高债权确定事实
    private String zgzqqdss;
    //抵押面积（房屋面积）
    private String dymj;
    //抵押面积其中土地（土地面积）
    private String dymjqztd;
    //被担保债权数额其中土地
    private String bdbzzqseqztd;
    //抵押物价值其中土地
    private String dywjzqztd;
    //是否涉税
    private String sfss;
    //债务人信息
    private List<DebtorModel> zwrxx;
    //担保范围
    private String dbfw;
    //收费信息
//    private String sfxx;
    //顺序
    private String sx;
    //附记
    private String fj;
    //是否禁止抵押期间抵押物转让
    private String sfjzdyqjdywzr;
    //最高债权额
    private BigDecimal zgzqe;
    //登记事由代码
    private String djsydm;
    //权利人
    private List<Qlrxx> qlrxx;
    //附记
    private List<ExcursusModel> fjxx;
    //物流信息
    private List<LogisticsMegModel> wlxx;
}
