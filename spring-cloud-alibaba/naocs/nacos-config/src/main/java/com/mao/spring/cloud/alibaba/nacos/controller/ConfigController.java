package com.mao.spring.cloud.alibaba.nacos.controller;

import com.mao.spring.cloud.alibaba.nacos.config.NacosConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author myseital
 * @date 2022/5/12 14:02
 */
@RestController
@RefreshScope
public class ConfigController {

//    @Autowired
//    private NacosConfig config;
//
//    @Value("${config-value}")
//    private String value;

    @GetMapping(value = "/config")
    public String config() {
        return null;
//        return config.getValue() + "\n" + value;
    }
}
