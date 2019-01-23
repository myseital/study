package com.mao.maoyan.getaway.modular.film.vo;

import com.mao.maoyan.api.film.vo.BannerVO;
import com.mao.maoyan.api.film.vo.FilmInfo;
import com.mao.maoyan.api.film.vo.FilmVO;
import lombok.Data;

import java.util.List;

/**
 * @author myseital
 */
@Data
public class FilmIndexVO {

    private List<BannerVO> banners;
    private FilmVO hotFilms;
    private FilmVO soonFilms;
    private List<FilmInfo> boxRanking;
    private List<FilmInfo> expectRanking;
    private List<FilmInfo> top100;
}
