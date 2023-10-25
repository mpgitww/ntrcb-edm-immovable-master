package com.ntrcb.immovable.entity.immovableToProvince.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class PlanQueryegisterEq {

    @ApiModelProperty(value = "受理编号")
    private String slbh;

    @ApiModelProperty(value = "行政区域代码")
    private String qydm;



}
