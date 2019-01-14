package com.mao.maoyan.core.exception;

import lombok.Data;

/**
 * 封装guns的异常
 *
 * @author maojiawei
 */
@Data
public class GunsException extends RuntimeException {

    private Integer code;

    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public GunsException(ServiceExceptionEnum serviceExceptionEnum) {
        this.code = serviceExceptionEnum.getCode();
        this.message = serviceExceptionEnum.getMessage();
    }
}
