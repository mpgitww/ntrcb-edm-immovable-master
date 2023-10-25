package com.ntrcb.immovable.entity.Immovable.req;

import lombok.Data;

import java.util.List;

/**
 * 银行下载附件信息接口请求参数
 */
@Data
public class DownFjxxEq {

    private String slbh;
    private String sqlx;
    private List<FjxxToDown> fjxxList;

    @Data
    private static class FjxxToDown {

        private String fjlx;
    }
}
