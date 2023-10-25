package com.ntrcb.immovable.constant;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Org NTRCB
 * @Author: 06101675
 * @Description: 公积金-机构代码数据字典
 * @Date: create in 2022/9/11 16:08
 */
public enum HousingOrgEnum {
    ORG_CCB01("01","CCB01","建设银行"),
    ORG_ICBC01("02","ICBC01","工商银行"),
    ORG_BOC01("03","BOC01","中国银行"),
    ORG_ABC01("04","ABC01","农业银行"),
    ORG_BOCOM01("05","BOCOM01","交通银行"),
    ORG_BOJ01("06","BOJ01","江苏银行"),
    ORG_JRCB01("07","JRCB01","江南银行"),
    ORG_PSBC01("08","PSBC01","邮政储蓄银行"),
    ORG_CMB01("09","CMB01","招商银行"),
    ORG_SPDB01("11","SPDB01","浦发银行"),
    ORG_SZB01("24","SZB01","苏州银行"),
    ORG_SNB01("25","SNB01","苏宁银行"),
    ORG_CGB01("26","CGB01","广发银行"),
    ORG_CIB01("27","CIB01","兴业银行"),
    ORG_RRCB01("28","RRCB01","江苏如东农村商业银行"),
    ORG_CZBANK("29","CZBANK","浙商银行"),
    ORG_HARCB01("30","HARCB01","江苏海安农村商业银行"),
    ORG_RGRCB01("31","RGRCB01","江苏如皋农村商业银行"),
    ORG_HMRCB01("32","HMRCB01","江苏海门农村商业银行"),
    ORG_BOS01("33","BOS01","上海银行"),
    ORG_NTRCB01("34","NTRCB01","江苏南通农村商业银行"),

    ;

    @ApiModelProperty(value = "前缀代码")
    private String prefix;
    @ApiModelProperty(value = "发送方缩写")
    private String abbr;
    @ApiModelProperty(value = "含义")
    private String desc;

    HousingOrgEnum(String prefix, String abbr, String desc) {
        this.prefix = prefix;
        this.abbr = abbr;
        this.desc = desc;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
