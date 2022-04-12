package com.mao.dubbo.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * @author myseital
 * @date 2022/4/12 19:18
 */
@EnableAutoConfiguration
public class DubboDemoProvider {

    public static void main(String[] args) {
        SpringApplication.run(DubboDemoProvider.class, args);
    }
}
