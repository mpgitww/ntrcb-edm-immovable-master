package com.ntrcb.immovable.entity.Immovable.req;

import com.ntrcb.immovable.entity.Immovable.model.PageInfo;
import com.ntrcb.immovable.entity.Immovable.model.PropertyRightQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 授权产权查询接口请求参数
 */
@Data
@ApiModel(value = "PropertyRightQueryEq", description = "授权产权查询接口请求参数")
public class PropertyRightQueryEq {
    @ApiModelProperty("授权产权查询接口请求参数主体")
    private PropertyRightQuery propertyRightQuery;
    @ApiModelProperty("分页信息")
    private PageInfo pageInfo;

}
