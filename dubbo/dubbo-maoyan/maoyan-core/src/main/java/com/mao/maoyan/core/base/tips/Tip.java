package com.mao.maoyan.core.base.tips;

import lombok.Data;

/**
 * 返回给前台的提示（最终转化为json形式）
 *
 * @author maojiawei
 */
@Data
public abstract class Tip {

    protected Integer code;

    protected String message;
}
