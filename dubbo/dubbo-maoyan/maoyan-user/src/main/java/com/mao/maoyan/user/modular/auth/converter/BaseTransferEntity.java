package com.mao.maoyan.user.modular.auth.converter;

import lombok.Data;

/**
 * 基础的传输bean
 *
 * @author maojiawei
 */
@Data
public class BaseTransferEntity {

    /**
     * base64编码的json字符串
     */
    private String object;

    /**
     * 签名
     */
    private String sign;
}
