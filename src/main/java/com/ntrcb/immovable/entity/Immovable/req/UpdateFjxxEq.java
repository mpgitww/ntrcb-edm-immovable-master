package com.ntrcb.immovable.entity.Immovable.req;

import lombok.Data;

import java.util.List;

/**
 * 附件更新
 */
@Data
public class UpdateFjxxEq {
    //序号
    private String proid;
    //材料名称
    private List<FjxxToUpdate> fjxx;
    //份数
    private String xldjsqlx;

    @Data
    private static class FjxxToUpdate {


        //序号
        private String xh;

        //材料名称
        private String clmc;

        //份数
        private String fs;

        //页数
        private String ys;

        //Byte内容
        private String bytes;

        //附件类型
        private String fjlx;

        //附件名称
        private String fjmc;

        //附件url
        private String fjurl;

    }
}
