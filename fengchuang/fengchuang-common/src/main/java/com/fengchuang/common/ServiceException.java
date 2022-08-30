package com.fengchuang.common;

import com.fengchuang.common.constant.AdminConstant;
import com.fengchuang.common.enums.ServiceExceptionEnum;

import java.util.Objects;

/**
 * @author myseital
 * @date 2022/2/8 18:07
 */
public class ServiceException extends RuntimeException {

    private ServiceExceptionEnum serviceExceptionEnum;

    private String[] parameters;
    private int errorCode;
    private String msg;


    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(Throwable cause, ServiceExceptionEnum exceptionType) {
        super(cause);
        this.serviceExceptionEnum = exceptionType;
    }

    public ServiceException(ServiceExceptionEnum exceptionType) {
        this.serviceExceptionEnum = exceptionType;
    }

    public ServiceException(ServiceExceptionEnum exceptionType, String... parameters) {
        this.serviceExceptionEnum = exceptionType;
        this.parameters = parameters;
    }

    public ServiceException(int errorCode, String msg) {
        this.errorCode = errorCode;
        this.msg = msg;
    }

    public ServiceException(Throwable cause, ServiceExceptionEnum exceptionType, String... parameters) {
        super(cause);
        this.serviceExceptionEnum = exceptionType;
        this.parameters = parameters;
    }

    @Override
    public String getMessage() {
        if (Objects.nonNull(serviceExceptionEnum)) {
            String msg = serviceExceptionEnum.getMessage();
            if (parameters != null && parameters.length >= 1) {
                msg = String.format(msg, parameters);
            }
            return msg;
        }
        return msg;
    }

    public Integer getErrCode() {
        return serviceExceptionEnum == null ? AdminConstant.INTERNAL_SERVER_ERROR.getValue() : serviceExceptionEnum.getCode();
    }


}
