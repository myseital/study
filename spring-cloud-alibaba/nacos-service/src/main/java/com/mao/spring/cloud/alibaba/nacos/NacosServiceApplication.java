package com.mao.spring.cloud.alibaba.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author myseital
 * @date 2022/5/12 05:06
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosServiceApplication.class, args);
    }
}
