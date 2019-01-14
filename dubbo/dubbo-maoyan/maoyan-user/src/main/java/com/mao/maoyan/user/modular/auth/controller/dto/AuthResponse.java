package com.mao.maoyan.user.modular.auth.controller.dto;

import java.io.Serializable;

/**
 * 认证的响应结果
 *
 * @author maojiawei
 */
public class AuthResponse implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;

    /**
     * jwt token
     */
    private final String token;

    /**
     * 用于客户端混淆md5加密
     */
    private final String randomKey;

    public AuthResponse(String token, String randomKey) {
        this.token = token;
        this.randomKey = randomKey;
    }

    public String getToken() {
        return this.token;
    }

    public String getRandomKey() {
        return randomKey;
    }
}
