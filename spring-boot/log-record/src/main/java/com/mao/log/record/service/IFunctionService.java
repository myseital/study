package com.mao.log.record.service;

public interface IFunctionService {

    String apply(String functionName, Object value);

    boolean beforeFunction(String functionName);
}
