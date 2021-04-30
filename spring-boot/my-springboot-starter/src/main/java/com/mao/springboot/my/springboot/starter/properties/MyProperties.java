package com.mao.springboot.my.springboot.starter.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author myseital
 * @date 2021/4/30 16:27
 */
@Data
@ConfigurationProperties(prefix = "my")
public class MyProperties {

    private String sayWhat;

    private String toWho;

}
