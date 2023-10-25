package com.ntrcb.common.annotation;

import java.lang.annotation.*;

/*
 * Author:06101675
 * Datetime: 2022/10/25 11:11
 * Description:
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface ClassDescribe {
    String value() default "";
}
