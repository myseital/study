package com.mao.rocketmq.project.store;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.mao.rocketmq.project.store.mapper")
@ComponentScan(basePackages = {"com.mao.rocketmq.project.store.*", "com.mao.rocketmq.project.store.config.*"})
public class MainConfig {

}
