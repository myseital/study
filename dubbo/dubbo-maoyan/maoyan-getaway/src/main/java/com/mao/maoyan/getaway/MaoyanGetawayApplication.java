package com.mao.maoyan.getaway;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@EnableDubbo
@EnableHystrix
@EnableCircuitBreaker
@EnableHystrixDashboard
@SpringBootApplication(scanBasePackages = {"com.mao.maoyan"})
public class MaoyanGetawayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaoyanGetawayApplication.class, args);
    }
}

