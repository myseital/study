package com.mao.maoyan.cinema.common.persistence.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mao.maoyan.api.cinema.vo.FilmInfoVO;
import com.mao.maoyan.api.cinema.vo.HallInfoVO;
import com.mao.maoyan.cinema.common.persistence.model.MoocFieldT;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 放映场次表 Mapper 接口
 * </p>
 *
 * @author jiangzh
 * @since 2018-09-15
 */
public interface MoocFieldTMapper extends BaseMapper<MoocFieldT> {

    List<FilmInfoVO> getFilmInfos(@Param("cinemaId") int cinemaId);

    HallInfoVO getHallInfo(@Param("fieldId") int fieldId);

    FilmInfoVO getFilmInfoById(@Param("fieldId") int fieldId);

}
