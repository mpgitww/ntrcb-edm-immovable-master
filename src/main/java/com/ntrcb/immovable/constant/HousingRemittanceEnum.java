package com.ntrcb.immovable.constant;

/**
 * @Org NTRCB
 * @Author: 06101675
 * @Description: 公积金"汇缴类型枚举
 * @Date: create in 2022/9/11 16:17
 */
public enum HousingRemittanceEnum {
    REMIT_00("00","待审批"),
    REMIT_01("01","职工开户"),
    REMIT_11("11","正常汇缴"),
    REMIT_12("12","正常汇缴"),
    REMIT_13("13","正常汇缴"),
    REMIT_14("14","正常汇缴"),
    REMIT_15("15","正常汇缴"),
    REMIT_21("21","封存状态"),
    REMIT_22("22","封存状态"),
    REMIT_23("23","封存状态"),
    REMIT_31("31","销户状态"),
    REMIT_32("32","销户状态"),
    REMIT_33("33","销户状态"),
    REMIT_34("34","销户状态"),

    ;
    private String code;
    private String desc;

    HousingRemittanceEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
