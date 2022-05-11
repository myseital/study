package com.mao.spring.cloud.alibaba.nacos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author myseital
 * @date 2022/5/12 05:07
 */
@RestController
public class UserController {

    @GetMapping("/user")
    public String getUser() {
        return "user";
    }
}
