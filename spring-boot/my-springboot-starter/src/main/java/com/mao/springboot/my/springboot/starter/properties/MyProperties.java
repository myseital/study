package com.mao.springboot.my.springboot.starter.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @author myseital
 * @date 2021/4/30 16:27
 */
@Data
@ConfigurationProperties(prefix = "my")
@PropertySource("classpath:my-property.yml")
public class MyProperties {

    private String sayWhat;

    private String toWho;

}
