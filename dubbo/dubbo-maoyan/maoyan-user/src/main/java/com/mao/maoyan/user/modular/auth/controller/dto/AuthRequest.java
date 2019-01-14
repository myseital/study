package com.mao.maoyan.user.modular.auth.controller.dto;


import com.mao.maoyan.user.modular.auth.validator.dto.Credence;
import lombok.Data;

/**
 * 认证的请求dto
 *
 * @author maojiawei
 */
@Data
public class AuthRequest implements Credence {

    private String userName;
    private String password;

    @Override
    public String getCredenceName() {
        return this.userName;
    }

    @Override
    public String getCredenceCode() {
        return this.password;
    }
}
