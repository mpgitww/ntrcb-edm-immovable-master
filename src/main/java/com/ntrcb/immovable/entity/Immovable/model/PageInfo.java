package com.ntrcb.immovable.entity.Immovable.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PageInfo {
    @ApiModelProperty(value = "每页数量")
    private String pageSize;
    @ApiModelProperty(value = "页号")
    private String pageNumber;

}