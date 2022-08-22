package com.mao.logrecord.core.service.impl;

import com.google.common.collect.Lists;
import com.mao.logrecord.core.beans.LogRecord;
import com.mao.logrecord.core.service.ILogRecordService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author muzhantong
 * create on 2020/4/29 4:34 下午
 */
@Slf4j
public class DefaultLogRecordServiceImpl implements ILogRecordService {

//    @Resource
//    private LogRecordMapper logRecordMapper;

    @Override
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void record(LogRecord logRecord) {
        log.info("【logRecord】log={}", logRecord);
        //throw new RuntimeException("sss");
//        logRecordMapper.insertSelective(logRecord);
    }

    @Override
    public List<LogRecord> queryLog(String bizNo, String type) {
        return Lists.newArrayList();
    }

    @Override
    public List<LogRecord> queryLogByBizNo(String bizNo, String type, String subType) {
        return Lists.newArrayList();
    }


}
