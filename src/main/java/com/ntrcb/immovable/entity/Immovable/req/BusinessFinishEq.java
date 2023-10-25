package com.ntrcb.immovable.entity.Immovable.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 业务办结接口请求参数
 */
@Data
@ApiModel(value = "BusinessFinishEq", description = "业务办结接口请求参数")
public class BusinessFinishEq {

    @ApiModelProperty(value = "受理编号")
    private String slbh;

    @ApiModelProperty(value = "受理人")
    private String slr;

    @ApiModelProperty(value = "权证印刷序列号列表")
    private List<Warrant> zslist;

    @ApiModelProperty(value = "行政区代码")
    private String xzqdm;

    @Data
    public static class Warrant{

        @ApiModelProperty(value = "证书id")
        private String zsid;
        @ApiModelProperty(value = "权证印刷序列号（印制号）")
        private String qzysxlh;

    }
}
