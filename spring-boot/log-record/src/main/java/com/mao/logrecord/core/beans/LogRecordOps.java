package com.mao.logrecord.core.beans;

import lombok.Builder;
import lombok.Data;

/**
 * LogRecord注解内容
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
    private String extra;
    private String condition;
}
