package com.mao.maoyan.api.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author myseital
 */
@Data
public class YearVO implements Serializable {

    private static final long serialVersionUID = 705271386700182933L;
    private String yearId;
    private String yearName;
    private Boolean active;

}
