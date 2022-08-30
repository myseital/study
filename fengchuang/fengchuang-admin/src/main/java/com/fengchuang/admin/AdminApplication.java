package com.fengchuang.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author myseital
 * @date 2022/2/7 14:11
 */
@EnableAsync
@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = {"com.fengchuang.admin.dao.mapper"})
public class AdminApplication {

    public static void main(String[] args) {
        System.setProperty("generic.include.class", "false");
        SpringApplication.run(AdminApplication.class, args);
    }
}
