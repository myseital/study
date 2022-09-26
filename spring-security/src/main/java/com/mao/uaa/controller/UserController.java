package com.mao.uaa.controller;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author myseital
 * @date 2022/6/23 13:06
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/greeting")
    public String greeting() {
        return "hello world";
    }


    @GetMapping("/public")
    public String testPublic() {
        return "public";
    }

    @GetMapping("/principal")
    public String getPrincipal(Principal principal) {
        log.info("principal: {}", JSONUtil.toJsonStr(principal));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("principal: {}", JSONUtil.toJsonStr(authentication.getPrincipal()));
        return authentication.getName();
    }

    @GetMapping("/authentication")
    public Authentication getAuthentication(Authentication auth) {
        log.info("auth: {}", JSONUtil.toJsonStr(auth));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("auth: {}", JSONUtil.toJsonStr(authentication));
        return authentication;
    }
}
