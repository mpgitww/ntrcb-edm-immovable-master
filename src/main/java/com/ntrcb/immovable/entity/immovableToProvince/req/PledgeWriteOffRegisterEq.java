package com.ntrcb.immovable.entity.immovableToProvince.req;

import com.ntrcb.immovable.entity.Immovable.model.PledgeWriteOffModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class PledgeWriteOffRegisterEq {

    @ApiModelProperty(value = "办件编号")
    private String bjbh;

    @ApiModelProperty(value = "抵押证明号")
    private String dyzmh;

    @ApiModelProperty(value = "注销原因")
    private String zxyy;

    @ApiModelProperty(value = "产权证号")
    private String bdcqzh;

    @ApiModelProperty(value = "不动产单元号")
    private String bdcdyh;

    @ApiModelProperty(value = "不动产单元编号")
    private String bdcdybh;

    @ApiModelProperty(value = "预告证明号")
    private String ygzmh;

    @ApiModelProperty(value = "附件url")
    private String fileUrl;

    @ApiModelProperty(value = "抵押人")
    private List<DyrModel> dyr;

    @ApiModelProperty(value = "抵押信息")
    private List<DyxxModel> dyxx;

    @ApiModelProperty(value = "抵押权利人")
    private List<DyxxModel> dyqlr;

    @ApiModelProperty(value = "附记")
    private String fj;

    @ApiModelProperty(value = "行政区域代码")
    private String qydm;


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
     * 抵押信息
     */
    @Data
    public static class DyxxModel {


        @ApiModelProperty(value = "权利人种类代码")
        private String dyfs;

        @ApiModelProperty(value = "权利人种类代码")
        private String bdbzzqse;

        @ApiModelProperty(value = "权利人种类代码")
        private String zwlxksqx;

        @ApiModelProperty(value = "权利人种类代码")
        private String zwlxjsqx;

        @ApiModelProperty(value = "权利人种类代码")
        private String fj;

        @ApiModelProperty(value = "权利人种类代码")
        private String qlsx;

        @ApiModelProperty(value = "权利人种类代码")
        private String dyfw;

        @ApiModelProperty(value = "权利人种类代码")
        private String bdcdjzmh;

        @ApiModelProperty(value = "权利人种类代码")
        private String dkfs;
    }

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
}
