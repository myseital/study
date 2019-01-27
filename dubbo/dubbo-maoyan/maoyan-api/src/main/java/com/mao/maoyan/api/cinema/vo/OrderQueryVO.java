package com.mao.maoyan.api.cinema.vo;

import lombok.Data;
import sun.plugin2.message.Serializer;

import java.io.Serializable;

/**
 * @author myseital
 */
@Data
public class OrderQueryVO implements Serializable{

    private String cinemaId;
    private String filmPrice;
}
