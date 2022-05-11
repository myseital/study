package com.mao.spring.cloud.eureka.client;

import com.mao.spring.cloud.eureka.client.service.TestService;
import com.mao.spring.cloud.eureka.client.service.UserClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class EurekaClientApplicationTests {

    @Resource
    private TestService testService;

    @Resource
    private UserClient userClient;

    @Test
    public void findByIdTest() {
        String data = userClient.findById(1L);
        System.out.println(data);
    }

    @Test
    public void getIdTest() {
        testService.getId();
    }
}
