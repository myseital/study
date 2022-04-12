package com.mao.dubbo.consumer;

import com.mao.dubbo.demo.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author myseital
 * @date 2022/4/12 19:18
 */
@EnableAutoConfiguration
//@SpringBootApplication
public class DubboDemoConsumer {

    @Reference
    private DemoService demoService;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DubboDemoConsumer.class, args);

        DemoService demoService = context.getBean(DemoService.class);
        String sss = demoService.sayHello("sss");
        System.out.println(sss);
    }
}
