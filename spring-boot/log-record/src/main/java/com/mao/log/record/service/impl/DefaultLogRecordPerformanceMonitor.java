package com.mao.log.record.service.impl;

import com.mao.log.record.service.ILogRecordPerformanceMonitor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

@Slf4j
public class DefaultLogRecordPerformanceMonitor implements ILogRecordPerformanceMonitor {

    @Override
    public void print(StopWatch stopWatch) {
        log.debug("LogRecord performance={}", stopWatch.prettyPrint());
    }
}
