package com.mao.springcloud.eureka.client.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author myseital
 * @date 2022/5/11 17:35
 */
@FeignClient(value = "spring-cloud-eureka-server")
@RequestMapping(path = "/user")
public interface UserClient {

    @GetMapping("/{id}")
//    @HystrixCommand(defaultFallback = "fallback")
    String findById(@PathVariable("id") Long id);

}
