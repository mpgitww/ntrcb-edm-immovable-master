package com.ntrcb.immovable.entity.Immovable.req;

import com.ntrcb.immovable.entity.Immovable.model.PledgeWriteOffModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class PledgeWriteOffEq {
    @ApiModelProperty("抵押注销请求参数")
    private List<PledgeWriteOffModel>  pledgeWriteOffList;
}
