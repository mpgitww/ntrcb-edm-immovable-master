package com.ntrcb.immovable.entity.Immovable.req;

import com.ntrcb.immovable.entity.Immovable.model.PageInfo;
import com.ntrcb.immovable.entity.Immovable.model.PropertyRightQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 查询预告证明接口
 */
@Data
@ApiModel(value = "AdvanceNoticeQueryEq", description = "查询预告证明接口")
public class AdvanceNoticeQueryEq {
    @ApiModelProperty("关系人名称")
    private String qlrmc;
    @ApiModelProperty("关系人证件号")
    private String qlrzjh;
    @ApiModelProperty("预告证明号")
    private String ygzmh;
    @ApiModelProperty("不动产单元号")
    private String bdcdyh;
    @ApiModelProperty("坐落")
    private String zl;


}
