package com.mao.springboot.mydemo.controller;

import com.mao.springboot.my.springboot.starter.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author myseital
 * @date 2021/4/30 17:39
 */
@RestController
public class MyController {

    @Resource
    private MyService myService;

    @GetMapping("/say")
    public String sayWhat() {
        return myService.say();
    }
}
