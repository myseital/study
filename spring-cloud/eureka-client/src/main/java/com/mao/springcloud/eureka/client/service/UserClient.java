package com.mao.springcloud.eureka.client.service;

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
    String findById(@PathVariable("id") Long id);

}
