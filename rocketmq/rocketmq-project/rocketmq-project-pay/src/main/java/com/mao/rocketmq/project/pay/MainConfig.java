package com.mao.rocketmq.project.pay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.mao.rocketmq.project.pay.mapper")
@ComponentScan(basePackages = {"com.mao.rocketmq.project.pay.*", "com.mao.rocketmq.project.pay.config.*"})
public class MainConfig {

}
