package com.mao.maoyan.order;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication(scanBasePackages = {"com.mao.maoyan"})
public class MaoyanOrderApplication {

    public static void main(String[] args) {

        SpringApplication.run(MaoyanOrderApplication.class, args);
    }
}
