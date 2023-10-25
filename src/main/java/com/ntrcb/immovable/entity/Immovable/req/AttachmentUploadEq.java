package com.ntrcb.immovable.entity.Immovable.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 业务办结接口请求参数
 */
@Data
@ApiModel(value = "BusinessFinishEq", description = "业务办结接口请求参数")
public class AttachmentUploadEq {

    @ApiModelProperty(value = "项目id")
    private String proid;

    @ApiModelProperty(value = "上传附件信息")
    private List<AttachmentDetail> fjxx;

    @ApiModelProperty(value = "小类登记申请类型")
    private String xldjsqlx;

    @Data
    public static class AttachmentDetail {

        @ApiModelProperty(value = "序号")
        private String xh;
        @ApiModelProperty(value = "材料名称")
        private String clmc;
        @ApiModelProperty(value = "份数")
        private String fs;
        @ApiModelProperty(value = "页数")
        private String ys;
        @ApiModelProperty(value = "Byte内容")
        private String bytes;
        @ApiModelProperty(value = "附件类型")
        private String fjlx;
        @ApiModelProperty(value = "附件名称")
        private String fjmc;
        @ApiModelProperty(value = "附件url")
        private String fjurl;
    }
}
