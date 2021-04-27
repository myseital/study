package com.mao.rocketmq.project.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.mao.rocketmq.project.order.mapper")
@ComponentScan(basePackages = {"com.mao.rocketmq.project.order.*", "com.mao.rocketmq.project.order.config.*"})
public class MainConfig {

}
