package com.mao.uaa.domain.dto;

import com.mao.uaa.validation.annotation.ValidPassword;
import lombok.Data;

/**
 * @author myseital
 * @date 2022/8/30
 */
@Data
public class PasswordDto {
    private String oldPassword;

    @ValidPassword
    private String newPassword;
}
