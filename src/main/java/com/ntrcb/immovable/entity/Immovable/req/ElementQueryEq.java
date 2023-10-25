package com.ntrcb.immovable.entity.Immovable.req;

import com.ntrcb.immovable.entity.Immovable.model.PageInfo;
import com.ntrcb.immovable.entity.Immovable.model.PropertyRightQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 查询不动产单元信息接口
 */
@Data
@ApiModel(value = "ElementQueryEq", description = "查询不动产单元信息接口")
public class ElementQueryEq {
    @ApiModelProperty("预售房屋编码")
    private String ysfwbm;
    @ApiModelProperty("坐落")
    private String zl;
    @ApiModelProperty("不动产单元号")
    private String bdcdyh;
}
