package com.mao.xxljob.config;

import com.mao.xxljob.properties.XxlAdminProperties;
import com.mao.xxljob.properties.XxlExecutorProperties;
import com.mao.xxljob.properties.XxlJobProperties;
import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author myseital
 * @date 2022/9/6
 */
@Slf4j
//@Configuration
//@EnableConfigurationProperties(XxlJobProperties.class)
public class XxlJobConfig {

//    @Bean(initMethod = "start", destroyMethod = "destroy")
//    public XxlJobSpringExecutor xxlJobExecutor(XxlJobProperties xxlJobProperties) {
//        log.info(">>>>>>>>>>> xxl-job config init.");
//        XxlExecutorProperties executor = xxlJobProperties.getExecutor();
//        XxlAdminProperties admin = xxlJobProperties.getAdmin();
//        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
//        xxlJobSpringExecutor.setAdminAddresses(admin.getAddresses());
//        xxlJobSpringExecutor.setAppname(executor.getAppname());
//        xxlJobSpringExecutor.setIp(executor.getIp());
//        xxlJobSpringExecutor.setPort(executor.getPort());
//        xxlJobSpringExecutor.setAccessToken(executor.getAccessToken());
//        xxlJobSpringExecutor.setLogPath(executor.getLogPath());
//        xxlJobSpringExecutor.setLogRetentionDays(executor.getLogRetentionDays());
//
//        return xxlJobSpringExecutor;
//    }


    @Value("${xxl.job.admin.addresses}")
    private String adminAddresses;

    @Value("${xxl.job.accessToken}")
    private String accessToken;

    @Value("${xxl.job.executor.appname}")
    private String appname;

    @Value("${xxl.job.executor.address}")
    private String address;

    @Value("${xxl.job.executor.ip}")
    private String ip;

    @Value("${xxl.job.executor.port}")
    private int port;

    @Value("${xxl.job.executor.logpath}")
    private String logPath;

    @Value("${xxl.job.executor.logretentiondays}")
    private int logRetentionDays;

    @Bean(initMethod = "start", destroyMethod = "destroy")
    public XxlJobSpringExecutor xxlJobExecutor() {
        log.info(">>>>>>>>>>> xxl-job config init.");
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAdminAddresses(adminAddresses);
        xxlJobSpringExecutor.setAppname(appname);
        xxlJobSpringExecutor.setIp(ip);
        xxlJobSpringExecutor.setPort(port);
        xxlJobSpringExecutor.setAccessToken(accessToken);
        xxlJobSpringExecutor.setLogPath(logPath);
        xxlJobSpringExecutor.setLogRetentionDays(logRetentionDays);

        return xxlJobSpringExecutor;
    }
}
