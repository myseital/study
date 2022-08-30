package com.fengchuang.common.enums;

import lombok.Getter;

/**
 * @author myseital
 * @date 2022/2/8 18:13
 */
public enum ServiceExceptionEnum {

    SYSTEM_EXCEPTION(1000, "system error"),
    ;


    @Getter
    private Integer code;
    @Getter
    private String message;

    ServiceExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
