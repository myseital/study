package com.fengchuang.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author myseital
 * @date 2022/2/8 16:38
 */
@Data
@AllArgsConstructor
public class ApiResultVO<T> implements Serializable {

    /**
     * 业务状态码
     */
    private int code;

    /**
     * 业务状态类型：SUCCESS/ERROR/
     */
    private String type;

    /**
     * 异常消息内容
     */
    private String message;

    /**
     * 业务数据
     */
    private T data;

    /**
     * 构建不带业务数据的成功结果
     */
    public static ApiResultVO buildSuccess() {
        return new ApiResultVO(0, "SUCCESS", "", null);
    }
}
