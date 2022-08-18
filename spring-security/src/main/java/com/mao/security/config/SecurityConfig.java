package com.mao.security.config;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

/**
 * @author myseital
 * @date 2022/8/17
 */
@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests(req -> req.mvcMatchers("/test").hasRole("ADMIN"));
        http
                .authorizeRequests(req -> req.anyRequest().authenticated())
//                .formLogin(AbstractHttpConfigurer::disable)
                // 自定义登陆页
                .formLogin(form -> form.loginPage("/login")
                        // 登录信息用户名传参设置
                        .usernameParameter("userName1")
                        // 防止重定向过多
                        .permitAll())
                .httpBasic(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 忽略静态资源或者公开数据
        web.ignoring().mvcMatchers("/api/public/**");
    }
}
