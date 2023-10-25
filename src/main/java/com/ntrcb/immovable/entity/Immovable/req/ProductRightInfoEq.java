package com.ntrcb.immovable.entity.Immovable.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 获取产权信息
 */
@Data
@ApiModel(value = "ProductRightInfoEq", description = "获取产权信息请求参数")
public class ProductRightInfoEq {
    @ApiModelProperty(value = "产权证号")
    private String cqzh;
    @ApiModelProperty(value = "权利人名称")
    private String dyr;
    @ApiModelProperty(value = "坐落")
    private String zl;
}
