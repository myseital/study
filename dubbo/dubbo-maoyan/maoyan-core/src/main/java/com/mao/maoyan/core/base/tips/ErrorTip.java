package com.mao.maoyan.core.base.tips;

import lombok.AllArgsConstructor;

/**
 * 返回给前台的错误提示
 *
 * @author maojiawei
 */
@AllArgsConstructor
public class ErrorTip extends Tip {

    public ErrorTip(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }
}
