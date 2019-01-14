package com.mao.maoyan.getaway.modular.auth.validator.dto;

/**
 * 验证的凭据
 *
 * @author maojiawei
 */
public interface Credence {

    /**
     * 凭据名称
     */
    String getCredenceName();

    /**
     * 密码或者是其他的验证码之类的
     */
    String getCredenceCode();
}
