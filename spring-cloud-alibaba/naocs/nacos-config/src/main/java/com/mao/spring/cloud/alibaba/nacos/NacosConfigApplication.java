package com.mao.spring.cloud.alibaba.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * ${prefix}-${spring.profiles.active}.${file-extension}
 *
 * @author myseital
 * @date 2022/5/12 05:19
 */
@SpringBootApplication
public class NacosConfigApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(NacosConfigApplication.class, args);
        ConfigurableEnvironment environment = run.getEnvironment();
        System.out.println("dd: " + environment.getProperty("config-value"));
    }
}
