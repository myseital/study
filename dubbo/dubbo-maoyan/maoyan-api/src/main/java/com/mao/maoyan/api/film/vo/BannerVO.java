package com.mao.maoyan.api.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author myseital
 */
@Data
public class BannerVO implements Serializable {

    private static final long serialVersionUID = 7393544510830165667L;
    private String bannerId;
    private String bannerAddress;
    private String bannerUrl;
}
