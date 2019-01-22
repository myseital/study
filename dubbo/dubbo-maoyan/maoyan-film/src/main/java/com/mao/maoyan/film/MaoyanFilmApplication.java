package com.mao.maoyan.film;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication(scanBasePackages = {"com.mao.maoyan"})
public class MaoyanFilmApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaoyanFilmApplication.class, args);
    }

}

