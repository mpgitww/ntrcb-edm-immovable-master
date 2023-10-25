package com.ntrcb.immovable.entity.immovableToProvince.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 抵押登记实体
 */
@Data
public class PledgeRegisterEq {

    @ApiModelProperty(value = "抵押合同号（抵押贷款）")
    private String dyhth;

    @ApiModelProperty(value = "产权证号")
    private String cqzh;

    @ApiModelProperty(value = "办件编号")
    private String bjbh;

    @ApiModelProperty(value = "申请登记类型")
    private String sqdjlx;

    @ApiModelProperty(value = "附件url")
    private String fileUrl;

    @ApiModelProperty(value = "抵押人")
    private List<DyrModel> dyr;

    @ApiModelProperty(value = "抵押权利人")
    private List<DyqlrModel> dyqlr;

    @ApiModelProperty(value = "债务人信息")
    private List<ZwrxxModel> zwrxx;

    @ApiModelProperty(value = "抵押信息")
    private List<DyxxModel> dyxx;

    @ApiModelProperty(value = "评估价格")
    private String bdcpgjg;

    @ApiModelProperty(value = "房屋抵押面积")
    private String fwdymj;

    @ApiModelProperty(value = "土地抵押面积")
    private String tddymj;

    @ApiModelProperty(value = "坐落")
    private String zl;

    @ApiModelProperty(value = "不动产单元号")
    private String bdcdyh;

    @ApiModelProperty(value = "不动产单元编号")
    private String bdcdybh;

    @ApiModelProperty(value = "行政区域代码")
    private String qydm;

//    @ApiModelProperty(value = "附件信息")
//    private List<FjxxModel> fjxx;


    /**
     * 抵押人
     */
    @Data
    public static class DyrModel {

        @ApiModelProperty(value = "抵押人名称")
        private String dyrmc;

        @ApiModelProperty(value = "抵押人证件号")
        private String dyrzjh;

        @ApiModelProperty(value = "抵押人证件种类")
        private String dyrzjzl;

        @ApiModelProperty(value = "联系电话")
        private String dyrlxdh;

        @ApiModelProperty(value = "共有方式")
        private String gyfs;

        @ApiModelProperty(value = "权利比例")
        private String qlbl;

        @ApiModelProperty(value = "权利人种类代码")
        private String dyrzldm;
    }

    /**
     * 抵押权利人
     */
    @Data
    public static class DyqlrModel {

        @ApiModelProperty(value = "权利人名称")
        private String qlrmc;

        @ApiModelProperty(value = "权利人证件号")
        private String qlrzjh;

        @ApiModelProperty(value = "权利人证件种类")
        private String qlrzjzl;

        @ApiModelProperty(value = "权利人联系电话")
        private String qlrlxdh;

        @ApiModelProperty(value = "权利人种类代码")
        private String qlrzldm;
    }

    /**
     * 抵押权利人
     */
    @Data
    public static class ZwrxxModel {

        @ApiModelProperty(value = "债务人名称")
        private String zwmc;

        @ApiModelProperty(value = "债务人证件类型")
        private String zwrzjzl;

        @ApiModelProperty(value = "债务人证件号")
        private String zwrzjh;

        @ApiModelProperty(value = "债务人联系电话")
        private String zwrlxdh;

        @ApiModelProperty(value = "债务人种类代码")
        private String zwrzldm;
    }

    /**
     * 抵押信息
     */
    @Data
    public static class DyxxModel {

        @ApiModelProperty(value = "抵押方式")

        private String dyfs;

        @ApiModelProperty(value = "被担保主债权数额（最高债权数额）")
        private BigDecimal bdbzzqse;

        @ApiModelProperty(value = "债务履行开始期限")
        private String zwlxksqx;

        @ApiModelProperty(value = "债务履行结束期限")
        private String zwlxjsqx;

        @ApiModelProperty(value = "附记信息")
        private String fjxx;

        @ApiModelProperty(value = "抵押顺位")
        private String qlsx;

        @ApiModelProperty(value = "抵押范围")
        private String dyfw;

        @ApiModelProperty(value = "抵押证明号")
        private String bdcdjzmh;

        @ApiModelProperty(value = "贷款方式")
        private String dkfs;

        @ApiModelProperty(value = "最高债权额")
        private BigDecimal zgzqe;
    }

//    @Data
//    public static class FjxxModel {
//
//        @ApiModelProperty(value = "材料名称")
//        private String clmc;
//
//        @ApiModelProperty(value = "页数")
//        private String ys;
//
//        @ApiModelProperty(value = "材料代码 ")
//        private String cldm;
//
//        @ApiModelProperty(value = "份数")
//        private String fs;
//
//        @ApiModelProperty(value = "材料内容")
//        private List<ClnrModel> clnr;
//
//        @Data
//        public static class ClnrModel {
//
//            @ApiModelProperty(value = "文件名称")
//            private String fileName;
//
//            @ApiModelProperty(value = "文件地址")
//            private String url;
//
//            @ApiModelProperty(value = "文件类型")
//            private String fileType;
//
//            @ApiModelProperty(value = "附件类型")
//            private String fjlx;
//        }
//    }

}
