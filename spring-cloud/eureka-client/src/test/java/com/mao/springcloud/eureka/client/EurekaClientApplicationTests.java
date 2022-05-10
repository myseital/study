package com.mao.springcloud.eureka.client;

import com.mao.springcloud.eureka.client.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class EurekaClientApplicationTests {

    @Resource
    private TestService testService;

    @Test
    public void getIdTest() {
        testService.getId();
    }
}
