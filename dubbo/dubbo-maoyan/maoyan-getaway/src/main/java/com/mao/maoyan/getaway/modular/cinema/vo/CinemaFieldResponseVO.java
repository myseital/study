package com.mao.maoyan.getaway.modular.cinema.vo;

import com.mao.maoyan.api.cinema.vo.CinemaInfoVO;
import com.mao.maoyan.api.cinema.vo.FilmInfoVO;
import com.mao.maoyan.api.cinema.vo.HallInfoVO;
import lombok.Data;

@Data
public class CinemaFieldResponseVO {

    private CinemaInfoVO cinemaInfo;
    private FilmInfoVO filmInfo;
    private HallInfoVO hallInfo;
}
