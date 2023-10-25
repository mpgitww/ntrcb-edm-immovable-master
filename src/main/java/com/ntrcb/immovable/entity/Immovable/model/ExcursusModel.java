package com.ntrcb.immovable.entity.Immovable.model;

import lombok.Data;

import java.util.List;

/**
 * 附记详情
 */
@Data
public class ExcursusModel {
    //材料名称
    private String clmc;
    //材料内容
    private List<MaterialsMegModel> clnr;
    //附件地址
    private String fjurl;
    //附件名称
    private String fjmc;
    //页数
    private String ys;
    //默认附件页数
    private String mrfjys;
    //份数
    private String fs;
    //附件类型
    private String fjlx;

    @Data
    public static class MaterialsMegModel {
        //附件名称
        private String fjmc;
        // base64
        private String bytes;

        private String fjurl;

        private String fjid;


    }

}
