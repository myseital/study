package com.mao.log.record.service.impl;


import com.mao.log.record.bean.Operator;
import com.mao.log.record.service.IOperatorGetService;

public class DefaultOperatorGetServiceImpl implements IOperatorGetService {

    @Override
    public Operator getUser() {
        Operator operator = new Operator();
        operator.setAppCode("ERP");
        operator.setTenantId(1L);
        operator.setOperatorId("1");
        operator.setOperatorName("jay");
        operator.setIp("127.0.0.1");

        return operator;
    }
}
