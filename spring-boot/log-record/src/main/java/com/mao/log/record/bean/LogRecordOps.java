package com.mao.log.record.bean;

import lombok.Builder;
import lombok.Data;

/**
 * LogRecord注解信息
 * @author myseital
 * @date 2022/8/19
 */
@Data
@Builder
public class LogRecordOps {
    private String successLogTemplate;
    private String failLogTemplate;
    private String operatorId;
    private String type;
    private String bizNo;
    private String subType;
    private String operateType;
    private String extra;
    private String condition;
}
