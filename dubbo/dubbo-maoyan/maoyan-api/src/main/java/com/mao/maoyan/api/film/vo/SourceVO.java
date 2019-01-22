package com.mao.maoyan.api.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author myseital
 */
@Data
public class SourceVO implements Serializable {

    private static final long serialVersionUID = 1348401225145322909L;
    private String sourceId;
    private String sourceName;
    private Boolean isActive;

}
