package com.ntrcb.immovable.entity.Immovable.req;

import lombok.Data;

/**
 * 预警查询接口
 */
@Data
public class EarlyWarningQueryEq {

    //抵押人姓名
    private String dyrxm;
    //抵押银行名称
    private String dyyhmc;
    //产权证号
    private String cqzh;
    //抵押登记证明号
    private String dydjzmh;
    //区县代码
    private String qxdm;

}
