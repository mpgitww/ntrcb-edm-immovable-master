package com.ntrcb.immovable.entity.Immovable.model;

import lombok.Data;

import java.util.List;

/**
 * 抵押登记实体
 */
@Data
public class PledgeRegisterModel {
    //抵押合同号
    private String dyhth;
    //产权证号
    private String cqzh;
    //证书项目ID
    private String zsxmid;
    //证书来源
    private String zsly;
    //办件编号
    private String bjbh;
    //抵押人
    private List<PledgeterModel> qlr;
    //抵押权利人
    private List<PledgeRighterModel> dyqlr;
    //抵押信息
    private List<PledgeMegModel> dyxx;
    //附记
    private List<ExcursusModel> fjxx;
    //坐落
    private String zl;
    //不动产单元号
    private String bdcdyh;
    //预约部门编码
    private String yybmbm;
    //不动产单元编号
    private String bdcdybh;
    //受理人
    private String slr;
    //申请登记类型
    private String sqdjlx;
    //登记原因代码
    private String djyydm;
    //登记原因名称
    private String djyymc;
    //创建验证 是否需要创建前验证，0不需要；1需要
    //登记3.0此字段作废
    private String cjyz;
    //预审人
    private String ysr;
    //预审时间
    private String yssj;
    //是否涉税
    private String sfss;
    //预审提示信息
    private String ystsxx;
    //预约开始时间
    private String yykssj;
    //预约结束时间
    private String yyjssj;
    //自动转发
    private String zdzf;
    //受理来源
    private String slly;
    //不动产评估价格
    private String bdcpgjg;
    //跳过节点数
    private String tgjds;
    //土地信息
    private List<LandDetailModel> gltdzxx;
    //是否主房
    private String sfzf;
    //行政区代码
    private String xzqdm;
    //roomid
    private String roomid;
    //银行标识
    private String yhbs;
    //借款人
    private List<BorrowMoneyManModel> jkr;
    //是否需要云签
    private String sfxyyq;
    //物流信息
    private List<LogisticsMegModel> wlxx;
    //物流信息
    private List<DebtorModel> zwrxx;
}
