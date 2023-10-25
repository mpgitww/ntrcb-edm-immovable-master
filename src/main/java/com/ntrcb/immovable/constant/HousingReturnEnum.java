package com.ntrcb.immovable.constant;

/**
 * @Org NTRCB
 * @Author: 06101675
 * @Description: 公积金-return code枚举类
 * @Date: create in 2022/9/11 16:01
 */
public enum HousingReturnEnum {
    RET_0001("0001","正确"),
    RET_0002("0002","交易代码不存在"),
    RET_0010("0010","总包长错误"),
    RET_0020("0020","存储过程调用失败"),
    RET_0021("0021","文件读取时失败"),
    RET_0022("0022","导入数据失败"),
    RET_0023("0023","XML 格式错误"),
    RET_0024("0024","重复提交"),
    RET_0025("0025","数据库连接失败"),
    RET_9001("9001","没有该条报文记录"),
    RET_9002("9002","该报文尚未处理"),
    RET_9098("9098","网络连接超时"),
    RET_9999("9999","其它异常错误"),
    ;
    private String code;
    private String desc;

    HousingReturnEnum(String code, String desc) {
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
