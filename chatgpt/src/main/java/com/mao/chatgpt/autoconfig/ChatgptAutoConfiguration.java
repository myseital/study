package com.mao.chatgpt.autoconfig;

import com.mao.chatgpt.property.ChatgptProperties;
import com.mao.chatgpt.service.ChatgptService;
import com.mao.chatgpt.service.impl.DefaultChatgptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@EnableConfigurationProperties(ChatgptProperties.class)
public class ChatgptAutoConfiguration {

    @Autowired
    private ChatgptProperties chatgptProperties;

    public ChatgptAutoConfiguration(){
        log.debug("chatgpt-springboot-starter loaded.");
    }

    @Bean
    @ConditionalOnMissingBean(ChatgptService.class)
    public ChatgptService chatgptService(){
        return new DefaultChatgptService(chatgptProperties);
    }

}
