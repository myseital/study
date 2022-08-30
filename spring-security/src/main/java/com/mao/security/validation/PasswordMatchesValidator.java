package com.mao.security.validation;

import com.mao.security.domain.dto.UserDto;
import com.mao.security.validation.annotation.PasswordMatches;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author myseital
 * @date 2022/8/30
 */
public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, UserDto> {

    @Override
    public void initialize(final PasswordMatches constraintAnnotation) { }

    @Override
    public boolean isValid(final UserDto obj, final ConstraintValidatorContext context) {
        return obj.getPassword().equals(obj.getMatchingPassword());
    }
}
