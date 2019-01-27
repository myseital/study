package com.mao.maoyan.api.order.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author myseital
 */
@Data
public class OrderVO implements Serializable {

    private static final long serialVersionUID = -5457500974075462386L;
    private String orderId;
    private String filmName;
    private String fieldTime;
    private String cinemaName;
    private String seatsName;
    private String orderPrice;
    private String orderTimestamp;
    private String orderStatus;
}
