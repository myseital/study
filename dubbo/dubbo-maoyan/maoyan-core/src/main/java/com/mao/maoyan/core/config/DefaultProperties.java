package com.mao.maoyan.core.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 默认的配置
 *
 * @author maojiawei
 */
@Configuration
@PropertySource("classpath:/default-config.properties")
public class DefaultProperties {

//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DruidProperties druidProperties() {
//        return new DruidProperties();
//    }

}
