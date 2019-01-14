package com.mao.maoyan.getaway.config;

import com.mao.maoyan.getaway.config.properties.RestProperties;
import com.mao.maoyan.getaway.modular.auth.filter.AuthFilter;
import com.mao.maoyan.getaway.modular.auth.security.DataSecurityAction;
import com.mao.maoyan.getaway.modular.auth.security.impl.Base64SecurityAction;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * web配置
 *
 * @author maojiawei
 */
@Configuration
public class WebConfig {

    @Bean
    @ConditionalOnProperty(prefix = RestProperties.REST_PREFIX, name = "auth-open", havingValue = "true", matchIfMissing = true)
    public AuthFilter jwtAuthenticationTokenFilter() {
        return new AuthFilter();
    }

    @Bean
    public DataSecurityAction dataSecurityAction() {
        return new Base64SecurityAction();
    }
}
