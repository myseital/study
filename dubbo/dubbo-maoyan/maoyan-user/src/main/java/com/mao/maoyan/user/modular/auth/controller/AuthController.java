package com.mao.maoyan.user.modular.auth.controller;

import com.mao.maoyan.core.exception.BizExceptionEnum;
import com.mao.maoyan.core.exception.GunsException;
import com.mao.maoyan.user.modular.auth.controller.dto.AuthRequest;
import com.mao.maoyan.user.modular.auth.controller.dto.AuthResponse;
import com.mao.maoyan.user.modular.auth.util.JwtTokenUtil;
import com.mao.maoyan.user.modular.auth.validator.IReqValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 请求验证的
 *
 * @author maojiawei
 */
@RestController
public class AuthController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Resource(name = "simpleValidator")
    private IReqValidator reqValidator;

    @RequestMapping(value = "${jwt.auth-path}")
    public ResponseEntity<?> createAuthenticationToken(AuthRequest authRequest) {
        boolean validate = reqValidator.validate(authRequest);
        if (validate) {
            final String randomKey = jwtTokenUtil.getRandomKey();
            final String token = jwtTokenUtil.generateToken(authRequest.getUserName(), randomKey);
            return ResponseEntity.ok(new AuthResponse(token, randomKey));
        } else {
            throw new GunsException(BizExceptionEnum.AUTH_REQUEST_ERROR);
        }
    }
}
