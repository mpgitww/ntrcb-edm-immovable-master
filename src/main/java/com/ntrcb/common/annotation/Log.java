package com.ntrcb.common.annotation;

import com.ntrcb.common.constant.MethodTypeEnum;

import java.lang.annotation.*;

/*
 * Author:06101675
 * Datetime: 2022/10/26 17:30
 * Description:
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Log {
    /**
     * 是否启用 操作日志
     *
     * @return 是否启用
     */
    boolean enabled() default true;

    /**
     * 描述
     *
     * @return {String}
     */
    String value() default "";

    /**
     * 需要拦截的参数名称
     *
     * @return 参数名称
     */
    String[] paramsName() default {};


    /**
     * 业务参数类型
     *
     * @return {@link MethodTypeEnum}
     */
    MethodTypeEnum businessType() default MethodTypeEnum.OTHER;

    /**
     * 是否拼接Controller类上的描述值
     *
     * @return 是否拼接
     */
    boolean controllerApiValue() default true;

    /**
     * 记录执行参数
     *
     * @return 是否记录
     */
    boolean request() default true;

    /**
     * 当 request = false时， 方法报错记录请求参数
     *
     * @return 是否记录
     */
    boolean requestByError() default true;

    /**
     * 记录返回参数
     *
     * @return 是否记录
     */
    boolean response() default true;
}
