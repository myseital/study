package com.mao.maoyan.api.film.vo;

import lombok.Data;

/**
 * @author myseital
 */
@Data
public class InfoRequestVO {

    private String biography;
    private ActorRequestVO actors;
    private ImgVO imgVO;
    private String filmId;

}
