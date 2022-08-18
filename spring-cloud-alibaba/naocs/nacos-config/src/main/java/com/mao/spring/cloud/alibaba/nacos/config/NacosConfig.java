package com.mao.spring.cloud.alibaba.nacos.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author myseital
 * @date 2022/5/12 15:16
 */
//@Component
//@RefreshScope
public class NacosConfig {

//    @Value("${config-value}")
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
