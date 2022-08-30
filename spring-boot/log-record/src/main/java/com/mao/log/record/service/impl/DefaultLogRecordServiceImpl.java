package com.mao.log.record.service.impl;

import com.mao.log.record.bean.LogRecord;
import com.mao.log.record.service.ILogRecordService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultLogRecordServiceImpl implements ILogRecordService {

//    @Resource
//    private LogRecordMapper logRecordMapper;

    @Override
    public Boolean record(LogRecord logRecord) {
        log.info("【logRecord】log={}", logRecord);
        return Boolean.TRUE;
    }
}
