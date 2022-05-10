package com.mao.springcloud.eureka.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author myseital
 * @date 2022/5/11 00:56
 */
@Service
public class TestService {

    @Autowired
    private RestTemplate restTemplate;

    public void getId() {
        String data = this.restTemplate.getForObject("http://spring-cloud-eureka-server/simple/" + 1, String.class);
        System.out.println(data);
    }
}
