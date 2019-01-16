package com.mao.maoyan.user.config.properties;

        import lombok.Data;
        import org.springframework.boot.context.properties.ConfigurationProperties;
        import org.springframework.context.annotation.Configuration;

/**
 * 项目相关配置
 *
 * @author maojiawei
 */
@Data
@Configuration
@ConfigurationProperties(prefix = RestProperties.REST_PREFIX)
public class RestProperties {

    public static final String REST_PREFIX = "rest";

    private Boolean authOpen = true;

    private Boolean signOpen = true;
}
