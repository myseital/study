package com.mao.log.record.starter.annotaion;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface DiffLogField {

    String name();

    String function() default "";

    //   String dateFormat() default "";
}
