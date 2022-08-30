package com.mao.log.record.starter.support.aop;

import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * 拦截器的切点
 */
public class LogRecordPointcut extends StaticMethodMatcherPointcut implements Serializable {

    private LogRecordOperationSource logRecordOperationSource;

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return !CollectionUtils.isEmpty(logRecordOperationSource.computeLogRecordOperations(method, targetClass));
    }

    void setLogRecordOperationSource(LogRecordOperationSource logRecordOperationSource) {
        this.logRecordOperationSource = logRecordOperationSource;
    }
}