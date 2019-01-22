package com.mao.maoyan.api.film.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author myseital
 */
@Data
public class FilmVO  implements Serializable {

    private static final long serialVersionUID = -4164673158390968408L;
    private Integer filmNum;
    private Integer nowPage;
    private Integer totalPage;
    private List<FilmInfo> filmInfo;
}
