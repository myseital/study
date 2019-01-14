package com.mao.maoyan.user.common.aop;

import com.mao.maoyan.core.aop.BaseControllerExceptionHandler;
import com.mao.maoyan.core.base.tips.ErrorTip;
import com.mao.maoyan.user.common.exception.BizExceptionEnum;
import io.jsonwebtoken.JwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 全局的的异常拦截器（拦截所有的控制器）（带有@RequestMapping注解的方法上都会拦截）
 *
 * @author maojiawei
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends BaseControllerExceptionHandler {

    /**
     * 拦截jwt相关异常
     */
    @ResponseBody
    @ExceptionHandler(JwtException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorTip jwtException(JwtException e) {
        log.error(e.getMessage());
        return new ErrorTip(BizExceptionEnum.TOKEN_ERROR.getCode(), BizExceptionEnum.TOKEN_ERROR.getMessage());
    }
}
