package com.mao.maoyan.cinema;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication(scanBasePackages = {"com.mao.maoyan"})
public class MaoyanCinemaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaoyanCinemaApplication.class, args);
    }
}
