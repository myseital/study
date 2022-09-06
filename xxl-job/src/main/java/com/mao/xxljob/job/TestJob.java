//package com.mao.xxljob.job;
//
//import com.xxl.job.core.executor.XxlJobExecutor;
//import com.xxl.job.core.handler.IJobHandler;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
///**
// * @author myseital
// * @date 2022/9/6
// */
//@Slf4j
//@Component
//public class TestJob extends IJobHandler {
//
//    public TestJob() {
//        XxlJobExecutor.registJobHandler("testJob", this);
//    }
//
//    @Override
//    public void execute() throws Exception {
//        log.info("test job ================");
//    }
//}
