package com.mao.maoyan.api.user.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author maojiawei
 */
@Data
public class UserModel implements Serializable {

    private static final long serialVersionUID = 7257339994068493145L;

    private String userName;
    private String password;
    private String email;
    private String phone;
    private String address;
}
