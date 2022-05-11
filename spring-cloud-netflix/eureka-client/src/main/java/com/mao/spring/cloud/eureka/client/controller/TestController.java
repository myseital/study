package com.mao.spring.cloud.eureka.client.controller;

import com.mao.spring.cloud.eureka.client.service.UserClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author myseital
 * @date 2022/5/12 01:41
 */
@RestController
public class TestController {
    @Resource
    private UserClient userClient;

    @GetMapping("/test")
    @HystrixCommand(defaultFallback = "fallback")
    public String findById(Long id) {
        return userClient.findById(id);
    }

    public String fallback() {
        return "fallback";
    }
}
