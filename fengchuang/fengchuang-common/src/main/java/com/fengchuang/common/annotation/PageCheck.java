package com.fengchuang.common.annotation;

import java.lang.annotation.*;

/**
 * @author myseital
 * @date 2022/2/8 16:54
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PageCheck {
    /**
     *  模块
     */
    String module() default "";
}
