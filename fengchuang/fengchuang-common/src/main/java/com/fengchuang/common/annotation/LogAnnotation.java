package com.fengchuang.common.annotation;

import java.lang.annotation.*;

/**
 * @author myseital
 * @date 2022/2/8 16:54
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {
    /**
     * 方法描述
     * @return
     */
    String desc() default "";

    String function() default "";

    String module() default "";
}
