package com.mao.logrecord.core.service.impl;

import com.mao.logrecord.core.service.ILogRecordPerformanceMonitor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

/**
 * @author muzhantong
 * create on 2022/7/17 10:49 PM
 */
@Slf4j
public class DefaultLogRecordPerformanceMonitor implements ILogRecordPerformanceMonitor {

    @Override
    public void print(StopWatch stopWatch) {
        log.debug("LogRecord performance={}", stopWatch.prettyPrint());
    }
}
