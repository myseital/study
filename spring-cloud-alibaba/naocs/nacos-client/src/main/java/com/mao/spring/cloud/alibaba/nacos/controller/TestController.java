package com.mao.spring.cloud.alibaba.nacos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author myseital
 * @date 2022/5/12 04:11
 */
@RestController
public class TestController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string) {
        return "Hello Nacos Discovery " + string;
    }

    @GetMapping(value = "/user")
    public String user() {
        return this.restTemplate.getForObject("http://nacos-service/user", String.class);
    }



}