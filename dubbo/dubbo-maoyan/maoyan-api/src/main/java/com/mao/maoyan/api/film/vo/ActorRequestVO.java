package com.mao.maoyan.api.film.vo;

import lombok.Data;

import java.util.List;

/**
 * @author myseital
 */
@Data
public class ActorRequestVO {

    private ActorVO director;
    private List<ActorVO> actors;
}
