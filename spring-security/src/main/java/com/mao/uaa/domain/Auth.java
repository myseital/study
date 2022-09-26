package com.mao.uaa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author myseital
 * @date 2022/9/26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Auth implements Serializable {
    private String accessToken;
    private String refreshToken;
}
