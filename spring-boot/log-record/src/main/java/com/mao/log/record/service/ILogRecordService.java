package com.mao.log.record.service;

import com.mao.log.record.bean.LogRecord;

/**
 * 操作日志服务
 */
public interface ILogRecordService {
    /**
     * 保存log
     *
     * @param logRecord 日志实体
     */
    Boolean record(LogRecord logRecord);
}
