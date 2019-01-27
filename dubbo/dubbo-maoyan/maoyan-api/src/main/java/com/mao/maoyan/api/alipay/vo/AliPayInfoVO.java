package com.mao.maoyan.api.alipay.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class AliPayInfoVO implements Serializable {

    private static final long serialVersionUID = -2101514788966548171L;
    private String orderId;
    private String QRCodeAddress;
}
