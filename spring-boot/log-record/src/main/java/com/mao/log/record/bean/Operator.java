package com.mao.log.record.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 操作员信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Operator {
    /**
     * 应用id
     */
    private String appCode;
    /**
     * 租户id
     */
    private Long tenantId;
    /**
     * 操作员id
     */
    private String operatorId;
    /**
     * 操作员名称
     */
    private String operatorName;
    /**
     * ip
     */
    private String ip;
}
