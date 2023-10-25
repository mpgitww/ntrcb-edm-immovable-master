package com.ntrcb.immovable.constant;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Optional;

/**
 * @Org NTRCB
 * @Author: 06101675
 * @Description: 公积金-接口枚举类
 * @Date: create in 2022/9/11 15:51
 */
@Slf4j
public enum HousingApiEnum {
    API_0541("0541","340541","客户身份验证查询交易"),
    API_0542("0542","340542","客户公积金缴纳信息查询"),
    ;
    private String code;
    private String housing_code;
    private String description;

    HousingApiEnum(String code, String housing_code, String description) {
        this.code = code;
        this.housing_code = housing_code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getHousing_code() {
        return housing_code;
    }

    public void setHousing_code(String housing_code) {
        this.housing_code = housing_code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static HousingApiEnum getByCode(String code) {
        Optional<? extends HousingApiEnum> optional = Arrays.stream(HousingApiEnum.class.getEnumConstants()).filter(api -> api.getCode().equals(code)).findAny();
        return optional.orElse(null);
    }

    public static HousingApiEnum getByHousingCode(String housing_code) {
        Optional<? extends HousingApiEnum> optional = Arrays.stream(HousingApiEnum.class.getEnumConstants()).filter(api -> api.getHousing_code().equals(housing_code)).findAny();
        return optional.orElse(null);
    }

    public static void main(String[] args) {
        HousingApiEnum housingApiEnum_1 = getByCode("0541");
        log.info("{}",housingApiEnum_1);
        HousingApiEnum housingApiEnum_2 = getByHousingCode("340542");
        log.info("{}",housingApiEnum_2);

    }
}
