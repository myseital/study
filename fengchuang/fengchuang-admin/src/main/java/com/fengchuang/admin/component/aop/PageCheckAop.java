package com.fengchuang.admin.component.aop;

import com.fengchuang.common.annotation.PageCheck;
import com.fengchuang.common.constant.AdminConstant;
import com.fengchuang.common.dto.QueryPageDTO;
import com.fengchuang.common.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author myseital
 * @date 2022/2/7 15:17
 */
@Slf4j
@Aspect
@Component
public class PageCheckAop {

    @Before("execution(* com.fengchuang.admin.web..*.*(..))")
    public void doBefore(JoinPoint point) {
        List<Object> args = null;
        try {
            PageCheck pageCheck = ((MethodSignature)point.getSignature()).getMethod().getAnnotation(PageCheck.class);
            if (Objects.isNull(pageCheck)) {
                return;
            }
            String module = pageCheck.module();
            String methodName = module + point.getSignature().toShortString();
            args = Arrays.asList(point.getArgs());
            String param = null != args ? JsonUtil.obj2String(args) : "";
            for (Object arg : args) {
                if (arg instanceof QueryPageDTO) {
                    if (Objects.isNull(((QueryPageDTO) arg).getPageIndex())) {
                        ((QueryPageDTO) arg).setPageIndex(AdminConstant.defaultPageIndex);
                    }
                    if (Objects.isNull(((QueryPageDTO) arg).getPageSize())) {
                        ((QueryPageDTO) arg).setPageSize(AdminConstant.defaultPageSize);
                    }
                }
            }
            log.info("{}, 参数:{}", methodName, param);
        } catch (Throwable e) {
            log.error("req = {}, 错误信息[{}]", null != args ? JsonUtil.obj2String(args) : "", e.getMessage());
        }
    }
}
