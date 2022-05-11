package com.mao.spring.cloud.alibaba.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author myseital
 * @date 2022/5/12 04:11
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosClientApplication.class, args);
    }

    @RestController
    class EchoController {
        @GetMapping(value = "/echo/{string}")
        public String echo(@PathVariable String string) {
            return "Hello Nacos Discovery " + string;
        }
    }
}
