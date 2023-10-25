package com.ntrcb.immovable.entity.Immovable.req;

import com.ntrcb.immovable.entity.Immovable.model.PledgeRegisterModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
@Data
@ApiModel(value = "PledgeReq", description = "抵押登记请求参数")
public class PledgeReq {

    @ApiModelProperty("抵押登记信息上报列表")
    List<PledgeRegisterModel> pledgeList;

}
