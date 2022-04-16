package com.mao.leaf.common.enums;

public enum Id4BizTagEnum {

    B2C_ORDER("b2c-order-info", "B2C订单信息"),
    ;

    private String code;

    private String desc;

    Id4BizTagEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}