package com.mao.log.record.starter.annotaion;


import java.lang.annotation.*;

/**
 * @author myseital
 * @date 2022/8/19
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface LogRecord {
    /**
     * @return 方法执行成功后的日志模版
     */
    String success();

    /**
     * @return 方法执行失败后的日志模版
     */
    String fail() default "";

    /**
     * @return 日志的操作人
     */
    String operator() default "";

    /**
     * @return 操作日志的类型，比如：订单类型、商品类型
     */
    String type();

    /**
     * @return 日志的子类型，比如订单的C端日志，和订单的B端日志，type都是订单类型，但是子类型不一样
     */
    String subType() default "";

    /**
     * @return 日志的操作类型
     */
    String operateType() default "";

    /**
     * @return 日志绑定的业务标识
     */
    String bizNo();

    /**
     * @return 日志的额外信息
     */
    String extra() default "";

    /**
     * @return 是否记录日志
     */
    String condition() default "";
}
