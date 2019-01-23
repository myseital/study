package com.mao.maoyan.getaway.modular.cinema.vo;

import com.mao.maoyan.api.cinema.vo.CinemaInfoVO;
import com.mao.maoyan.api.cinema.vo.FilmInfoVO;
import lombok.Data;

import java.util.List;

@Data
public class CinemaFieldsResponseVO {

    private CinemaInfoVO cinemaInfo;
    private List<FilmInfoVO> filmList;
}
