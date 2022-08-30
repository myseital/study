package com.mao.log.record.starter.configuration;//package com.ydm.log.starter.configuration;
//
//import com.ydm.log.service.IFunctionService;
//import com.ydm.log.service.ILogRecordPerformanceMonitor;
//import com.ydm.log.service.IParseFunction;
//import com.ydm.log.service.impl.DefaultFunctionServiceImpl;
//import com.ydm.log.service.impl.DefaultLogRecordPerformanceMonitor;
//import com.ydm.log.service.impl.DefaultParseFunction;
//import com.ydm.log.service.impl.ParseFunctionFactory;
//import com.ydm.log.starter.support.aop.BeanFactoryLogRecordAdvisor;
//import com.ydm.log.starter.support.aop.LogRecordInterceptor;
//import com.ydm.log.starter.support.aop.LogRecordOperationSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.config.BeanDefinition;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Role;
//
//import java.util.List;
//
///**
// * @author myseital
// * @date 2022/8/19
// */
//@Configuration
//public class LogRecordConfig {
//
//    @Bean
//    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
//    public LogRecordOperationSource logRecordOperationSource() {
//        return new LogRecordOperationSource();
//    }
//
//    @Bean
//    @ConditionalOnMissingBean(ILogRecordPerformanceMonitor.class)
//    public ILogRecordPerformanceMonitor logRecordPerformanceMonitor() {
//        return new DefaultLogRecordPerformanceMonitor();
//    }
//
//    @Bean
//    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
//    public LogRecordInterceptor logRecordInterceptor() {
//        LogRecordInterceptor interceptor = new LogRecordInterceptor();
//        interceptor.setLogRecordOperationSource(logRecordOperationSource());
//        //interceptor.setLogFunctionParser(logFunctionParser(functionService));
//        //interceptor.setDiffParseFunction(diffParseFunction);
//        interceptor.setLogRecordPerformanceMonitor(logRecordPerformanceMonitor());
//        return interceptor;
//    }
//
//    @Bean
//    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
//    public BeanFactoryLogRecordAdvisor logRecordAdvisor() {
//        BeanFactoryLogRecordAdvisor advisor = new BeanFactoryLogRecordAdvisor();
//        advisor.setLogRecordOperationSource(logRecordOperationSource());
//        advisor.setAdvice(logRecordInterceptor());
//        return advisor;
//    }
//
//    @Bean
//    @ConditionalOnMissingBean(IFunctionService.class)
//    public IFunctionService functionService(ParseFunctionFactory parseFunctionFactory) {
//        return new DefaultFunctionServiceImpl(parseFunctionFactory);
//    }
//
//    @Bean
//    public ParseFunctionFactory parseFunctionFactory(@Autowired List<IParseFunction> parseFunctions) {
//        return new ParseFunctionFactory(parseFunctions);
//    }
//
//    @Bean
//    @ConditionalOnMissingBean(IParseFunction.class)
//    public DefaultParseFunction parseFunction() {
//        return new DefaultParseFunction();
//    }
//}
