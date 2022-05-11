package com.mao.springcloud.eureka.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author myseital
 * @date 2022/5/11 01:08
 */
@RestController
@RequestMapping(path = "/user")
public class UserController {

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id) {
        return "get: " + id.toString();
    }
}
