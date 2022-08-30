package com.fengchuang.admin.component.aop;

import com.fengchuang.common.ServiceException;
import com.fengchuang.common.annotation.LogAnnotation;
import com.fengchuang.common.constant.AdminConstant;
import com.fengchuang.common.enums.ServiceExceptionEnum;
import com.fengchuang.common.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

import java.util.Objects;

/**
 * @author myseital
 * @date 2022/2/7 15:17
 */
@Aspect
@Configuration
@Slf4j
public class LogAop {

    private final String POINT_CUT = "execution(* *(..))  && @annotation(logAnnotation)";

    @Around(value = POINT_CUT)
    public Object Around(ProceedingJoinPoint pjp, LogAnnotation logAnnotation) {
        Object resultDTO;
        String methodName = pjp.getSignature().toShortString();
        String logTextPrefix = Objects.nonNull(logAnnotation) ?
                "[".concat(logAnnotation.module()).concat(":" + logAnnotation.function()).concat("]") : methodName;
        log.info("{} 参数:{}", logTextPrefix, null != pjp.getArgs() ?
                JsonUtil.obj2String(pjp.getArgs()) : AdminConstant.EMPTY_STRING);
        StopWatch stopWatch = new StopWatch("耗时统计");
        try {
            stopWatch.start();
            resultDTO = pjp.proceed();
        } catch (Throwable throwable) {
            if (throwable instanceof ServiceException) {
                log.warn("系统异常message[{}]", throwable.getMessage(), throwable);
                ServiceException base = (ServiceException) throwable;
                throw new ServiceException(base.getErrCode(), base.getMessage());
            }
            log.error("系统异常message[{}]", throwable.getMessage(), throwable);
            throw new ServiceException(ServiceExceptionEnum.SYSTEM_EXCEPTION.getCode(), throwable.getMessage());
        }
        stopWatch.stop();
        log.info("{} 耗时[{}] 响应结果[{}]", logTextPrefix, stopWatch.getLastTaskTimeMillis(),
                null != resultDTO ? JsonUtil.obj2String(resultDTO) : AdminConstant.EMPTY_STRING);

        return resultDTO;
    }

}
