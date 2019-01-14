package com.mao.maoyan.core.aop;

import com.mao.maoyan.core.base.tips.ErrorTip;
import com.mao.maoyan.core.exception.GunsException;
import com.mao.maoyan.core.exception.GunsExceptionEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 全局的的异常拦截器（拦截所有的控制器）（带有@RequestMapping注解的方法上都会拦截）
 *
 * @author maojiawei
 */
@Slf4j
public class BaseControllerExceptionHandler {

    /**
     * 拦截业务异常
     */
    @ResponseBody
    @ExceptionHandler(GunsException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorTip notFount(GunsException e) {
        log.error("业务异常:", e);
        return new ErrorTip(e.getCode(), e.getMessage());
    }

    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorTip notFount(RuntimeException e) {
        log.error("运行时异常:", e);
        return new ErrorTip(GunsExceptionEnum.SERVER_ERROR.getCode(), GunsExceptionEnum.SERVER_ERROR.getMessage());
    }

}
