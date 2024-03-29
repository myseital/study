package com.mao.spring.cloud.eureka.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author myseital
 * @date 2022/5/11 01:08
 */
@RestController
@RequestMapping(path = "/user")
public class UserController {

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id) {
        int i = new Random().nextInt(2);
        if (i % 2 == 0) {
            return "get: " + id.toString();
        } else {
            throw new RuntimeException("请求失败！");
        }
    }
}
