package com.ntrcb.immovable.entity.Immovable.req;

import lombok.Data;

/**
 * 证照信息查询接口参数
 */
@Data
public class CertIdQueryEq {

    //证照类型代码
    private String zzlxdm;

    //不动产权证号
    private String bdcqzh;

    //行政区代码
    private String xzqdm;


}
