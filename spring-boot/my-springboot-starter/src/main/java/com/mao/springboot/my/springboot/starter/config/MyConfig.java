package com.mao.springboot.my.springboot.starter.config;

import com.mao.springboot.my.springboot.starter.properties.MyProperties;
import com.mao.springboot.my.springboot.starter.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author myseital
 * @date 2021/4/30 17:31
 */
@Configuration
@EnableConfigurationProperties(MyProperties.class)
@ConditionalOnProperty(
        prefix = "my",
        name = "isopen",
        havingValue = "true"
)
public class MyConfig {

    @Autowired
    private MyProperties myProperties;

    @Bean(name = "my")
    @ConditionalOnMissingBean()
    public MyService myService() {
        return new MyService(myProperties.getSayWhat(), myProperties.getToWho());
    }
}
