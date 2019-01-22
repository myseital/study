package com.mao.maoyan.api.film;

import com.mao.maoyan.api.film.vo.ActorVO;
import com.mao.maoyan.api.film.vo.FilmDescVO;
import com.mao.maoyan.api.film.vo.ImgVO;

import java.util.List;

/**
 * @author myseital
 */
public interface FilmAsyncServiceApi {

    /**
     * 获取影片描述信息
     * @param filmId
     * @return
     */
    FilmDescVO getFilmDesc(String filmId);

    /**
     * 获取图片信息
     * @param filmId
     * @return
     */
    ImgVO getImgs(String filmId);

    /**
     * 获取导演信息
     * @param filmId
     * @return
     */
    ActorVO getDectInfo(String filmId);

    /**
     * 获取演员信息
     * @param filmId
     * @return
     */
    List<ActorVO> getActors(String filmId);
}
