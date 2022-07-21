package com.mao.mybatis.controller;

import com.mao.mybatis.domain.Customer;
import com.mao.mybatis.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author myseital
 * @date 2022/6/23 13:06
 */
@RestController
public class TestController {

    @Resource
    private CustomerService customerService;

    @GetMapping("/test")
    public String test() {
        customerService.aCallB();
        return null;
    }
}
