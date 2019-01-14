package com.mao.maoyan.getaway;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication(scanBasePackages = {"com.mao.maoyan"})
public class MaoyanGetawayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaoyanGetawayApplication.class, args);
    }
}

