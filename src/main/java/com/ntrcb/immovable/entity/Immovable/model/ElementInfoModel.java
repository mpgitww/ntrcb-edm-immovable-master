package com.ntrcb.immovable.entity.Immovable.model;

import lombok.Data;

import java.util.List;

@Data
public class ElementInfoModel {
    //房屋面积
    private String mj;
    //抵押状态
    private String sfdy;
    //查封状态
    private String sfcf;
    //不动产单元号
    private String bdcdyh;
    //坐落
    private String zl;
    //房产证号
    private String fczh;
    //项目id
    private String yxmid;
    //不动产单元编号
    private String bdcdybh;
    //土地证号
    private String tdzh;
    //土地项目id
    private String tdxmid;
    //房源编码
    private String fybm;
    //行政区代码
    private String xzqdm;
    //行政区名称
    private String xzqmc;
    //乡镇街道代码
    private String xzjddm;
    //乡镇街道名称
    private String xzjdmc;
    //是否主房
    private String sfzf;
    //权籍关联代码
    private String qjgldm;
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
    //产权信息
    private List<CqxxModel> cqxx;
    //抵押信息
    private List<DyxxModel> dyxx;
}
