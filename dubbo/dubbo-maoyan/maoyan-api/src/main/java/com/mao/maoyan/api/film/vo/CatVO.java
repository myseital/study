package com.mao.maoyan.api.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author myseital
 */
@Data
public class CatVO implements Serializable {

    private static final long serialVersionUID = -2914059862514320155L;
    private String catId;
    private String catName;
    private Boolean isActive;
}
