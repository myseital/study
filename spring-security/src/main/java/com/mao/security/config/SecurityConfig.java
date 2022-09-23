package com.mao.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mao.security.filter.RestAuthenticationFilter;
import com.mao.security.handler.MyAuthenticationSuccessHandler;
import com.mao.security.service.userdetails.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.zalando.problem.spring.web.advice.security.SecurityProblemSupport;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author myseital
 * @date 2022/8/17
 */
@Slf4j
@EnableWebSecurity(debug = false)
@RequiredArgsConstructor
@Order(99)
@Import(SecurityProblemSupport.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final ObjectMapper objectMapper;

    private final SecurityProblemSupport securityProblemSupport;

    private final DataSource dataSource;

    private final UserDetailsService userDetailsService;

    private final UserDetailsPasswordService userDetailsPasswordService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .requestMatchers(req -> req.mvcMatchers("/api/**", "/admin/**", "/authorize/**"))
                .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling(exceptionHandling -> exceptionHandling
                .authenticationEntryPoint(securityProblemSupport)
                .accessDeniedHandler(securityProblemSupport))
                .authorizeRequests(req -> req
                        .antMatchers("/authorize/**").permitAll()
                        .antMatchers("/admin/**").hasRole("ADMIN")
                        .antMatchers("/api/**").hasRole("USER")
                        .anyRequest().authenticated())
                    .addFilterAt(restAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults());
//                .csrf(csrf -> csrf.ignoringAntMatchers("/api/**", "/admin/**", "/authorize/**"))
        ;
    }

    private RestAuthenticationFilter restAuthenticationFilter() throws Exception {
        RestAuthenticationFilter filter = new RestAuthenticationFilter(objectMapper);
        filter.setAuthenticationSuccessHandler(jsonLoginSuccessHandler());
        filter.setAuthenticationFailureHandler(jsonLoginFailureHandler());
        filter.setAuthenticationManager(authenticationManager());
        filter.setFilterProcessesUrl("/authorize/login");
        return filter;
    }

    private AuthenticationSuccessHandler jsonLoginSuccessHandler() {
        return (req, res, auth) -> {
            ObjectMapper objectMapper = new ObjectMapper();
            res.setStatus(HttpStatus.OK.value());
            res.getWriter().println(objectMapper.writeValueAsString(auth));
            log.info("认证成功");
        };
    }

    private AuthenticationFailureHandler jsonLoginFailureHandler() {
        return (req, res, exp) -> {
            res.setStatus(HttpStatus.UNAUTHORIZED.value());
            res.setContentType(MediaType.APPLICATION_JSON_VALUE);
            res.setCharacterEncoding("UTF-8");
            Map<String, String> errData = ImmutableMap.of(
                    "title", "认证失败",
                    "details", exp.getMessage()
                    );
            res.getWriter().println(objectMapper.writeValueAsString(errData));
        };
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/public/**", "/api/public/**", "/error/**", "/h2-console/**");
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                // 配置 AuthenticationManager 使用 userService
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder())
                // 配置密码自动升级服务
                .userDetailsPasswordManager(userDetailsPasswordService)


//        auth.jdbcAuthentication()
////                .withDefaultSchema()
//                .dataSource(dataSource)
////                .usersByUsernameQuery("select * from users where username = ?")
////                .authoritiesByUsernameQuery("select * from authorities where username = ?")
//                .passwordEncoder(passwordEncoder())

//        auth.inMemoryAuthentication()
//                .withUser("user")
//                .password(passwordEncoder().encode("123456"))
//                .roles("USER", "ADMIN")
//                .and()
//                .withUser("zhangsan")
//                .password(passwordEncoder().encode("12345678"))
//                .roles("USER", "ADMIN")
        ;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        String defaultEncode = "bcrypt";
        Map<String, PasswordEncoder> encoders = ImmutableMap.of(
                defaultEncode, new BCryptPasswordEncoder(),
                "SHA-1", new MessageDigestPasswordEncoder("SHA-1")
        );

        return new DelegatingPasswordEncoder(defaultEncode, encoders);
//        return new BCryptPasswordEncoder();
    }
}
