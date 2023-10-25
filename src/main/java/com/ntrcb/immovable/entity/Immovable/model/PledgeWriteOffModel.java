package com.ntrcb.immovable.entity.Immovable.model;

import lombok.Data;

import java.util.List;

/**
 * 抵押注销接口
 */
@Data
public class PledgeWriteOffModel {

    //抵押合同号
    private String dyhth;
    //证明号
    private String zmh;
    //证明项目Id
    private String zmxmid;
    //证明来源
    private String zmly;
    //办件编号
    private String bjbh;
    //注销原因
    private String zxyy;
    //申请人
    private List<PledgeWriteOffProPoserModel> qlr;
    //附件信息
    private List<ExcursusModel> fjxx;
    //材料名称
    private String clmc;
    //材料内容
    private String clnr;
    //附件地址
    private String fjurl;
    //附件名称
    private String fjmc;
    //不动产单元号
    private String bdcdyh;
    //预约部门编码
    private String yybmbm;
    //不动产单元编号
    private String bdcdybh;
    //产权证号
    private String cqzh;
    //抵押人
    private List<PledgeWriteOffManModel> dyr;
    //受理人
    private String slr;
    //申请登记类型
    private String sqdjlx;
    //登记原因代码
    private String djyydm;
    //登记原因名称
    private String djyymc;
    //预审人
    private String ysr;
    //预审时间
    private String yssj;
    //是否涉税
    private String sfss;
    //预审提示信息
    private String ystsxx;
    //坐落
    private String zl;
    //预约开始时间
    private String yykssj;
    //预约结束时间
    private String yyjssj;
    //自动转发
    private String zdzf;
    //受理来源
    private String slly;
    //是否自动办结
    private String sfzdbj;
    //担保范围
    private String dbfw;
    //roomid
    private String roomid;
    //行政区代码
    private String xzqdm;
    //申请人名称
    private String sqrmc;
    //申请人证件号
    private String sqrzjh;
    //银行标识
    private String yhbs;
    //是否需要云签
    private String sfxyyq;
    //物流信息
    private List<LogisticsMegModel> wlxx;
    //债务人信息
    private List<DebtorModel> zwrxx;
}
