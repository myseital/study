package com.mao.maoyan.film.modular.auth.controller.dto;

import com.mao.maoyan.film.modular.auth.validator.dto.Credence;
import lombok.Data;

/**
 * 认证的请求dto
 *
 * @author fengshuonan
 * @Date 2017/8/24 14:00
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
