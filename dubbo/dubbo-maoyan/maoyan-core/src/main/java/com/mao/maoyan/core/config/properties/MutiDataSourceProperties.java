//package com.mao.maoyan.core.config.properties;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import lombok.Data;
//
///**
// * 默认多数据源配置
// *
// * @author maojiawei
// */
//@Data
//public class MutiDataSourceProperties {
//
//    private String url = "jdbc:mysql://120.55.63.0:3306/biz?autoReconnect=true&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull";
//
//    private String username = "root";
//
//    private String password = "Mao213344.";
//
//    private String driverClassName = "com.mysql.cj.jdbc.Driver";
//
//    private String validationQuery = "SELECT 'x'";
//
//    private String[] dataSourceNames = {"dataSourceGuns", "dataSourceBiz"};
//
//    public void config(DruidDataSource dataSource) {
//        dataSource.setUrl(url);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        dataSource.setDriverClassName(driverClassName);
//        dataSource.setValidationQuery(validationQuery);
//    }
//}
