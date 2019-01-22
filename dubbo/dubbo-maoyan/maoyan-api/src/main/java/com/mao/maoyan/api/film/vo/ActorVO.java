package com.mao.maoyan.api.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author myseital
 */
@Data
public class ActorVO implements Serializable {

    private static final long serialVersionUID = -7595031567659910163L;
    private String imgAddress;
    private String directorName;
    private String roleName;
}
