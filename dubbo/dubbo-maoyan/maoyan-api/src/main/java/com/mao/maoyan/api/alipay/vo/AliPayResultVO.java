package com.mao.maoyan.api.alipay.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class AliPayResultVO implements Serializable {

    private static final long serialVersionUID = -370350629749422323L;
    private String orderId;
    private Integer orderStatus;
    private String orderMsg;
}
