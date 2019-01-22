package com.mao.maoyan.api.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author myseital
 */
@Data
public class FilmInfo implements Serializable {

    private static final long serialVersionUID = -2271178568273922094L;
    private String filmId;
    private Integer filmType;
    private String imgAddress;
    private String filmName;
    private String filmScore;
    private Integer expectNum;
    private String showTime;
    private Integer boxNum;
    private String score;
}
