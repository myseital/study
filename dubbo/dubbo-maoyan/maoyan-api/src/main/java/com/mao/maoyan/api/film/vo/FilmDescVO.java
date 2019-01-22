package com.mao.maoyan.api.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author myseital
 */
@Data
public class FilmDescVO implements Serializable {

    private static final long serialVersionUID = -792172873883617091L;
    private String biography;
    private String filmId;
}
