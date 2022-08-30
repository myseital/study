package com.fengchuang.common.constant;

import lombok.Getter;

/**
 * @author myseital
 * @date 2022/2/8 16:50
 */
public class AdminConstant {

    public static final Integer defaultPageIndex = 1;
    public static final Integer defaultPageSize = 10;
    public static final Long ZERO_LONG = 0L;
    public static final String EMPTY_STRING = "";
    public static final HttpStatus INTERNAL_SERVER_ERROR = HttpStatus.INTERNAL_SERVER_ERROR;

    public enum HttpStatus {
        INTERNAL_SERVER_ERROR(500, "Internal Server Error"),;
        @Getter
        private final int value;
        private final String reasonPhrase;

        private HttpStatus(int value, String reasonPhrase) {
            this.value = value;
            this.reasonPhrase = reasonPhrase;
        }
    }

}
