package com.ntrcb.common.constant;

import lombok.Data;

/**
 * @Org NTRCB
 * @Author: 06101675
 * @Description: 封装统一返回值
 * @Date: create in 2022/9/11 16:43
 */
@Data
public class    ReturnResult<T> {
    private String code;
    private String message;
    private T data;

    public ReturnResult() {
    }

    public ReturnResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T>ReturnResult<T> success(T data) {
        return new ReturnResult(ReturnResultEnum.RET_SUCCESS.getCode(), ReturnResultEnum.RET_SUCCESS.getDesc(), data);
    }

    public static <T>ReturnResult<T> error(T data) {
        return new ReturnResult(ReturnResultEnum.RET_FAIL.getCode(), ReturnResultEnum.RET_FAIL.getDesc(), data);
    }

    /**
     * 接口返回枚举类
     */
    public enum ReturnResultEnum {
        RET_SUCCESS("000000","成功"),
        RET_FAIL("E99999","失败"),
        ;
        private String code;
        private String desc;

        ReturnResultEnum(String code, String desc) {
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

}
