package com.mao.maoyan.api.cinema;

import com.baomidou.mybatisplus.plugins.Page;
import com.mao.maoyan.api.cinema.vo.*;

import java.util.List;

public interface CinemaServiceAPI {

    /**
     * 根据CinemaQueryVO，查询影院列表
     * @param cinemaQueryVO
     * @return
     */
    Page<CinemaVO> getCinemas(CinemaQueryVO cinemaQueryVO);

    /**
     * 根据条件获取品牌列表[除了就99以外，其他的数字为isActive]
     * @param brandId
     * @return
     */
    List<BrandVO> getBrands(int brandId);

    /**
     * 获取行政区域列表
     * @param areaId
     * @return
     */
    List<AreaVO> getAreas(int areaId);

    /**
     * 获取影厅类型列表
     * @param hallType
     * @return
     */
    List<HallTypeVO> getHallTypes(int hallType);

    /**
     * 根据影院编号，获取影院信息
     * @param cinemaId
     * @return
     */
    CinemaInfoVO getCinemaInfoById(int cinemaId);

    /**
     * 获取所有电影的信息和对应的放映场次信息，根据影院编号
     * @param cinemaId
     * @return
     */
    List<FilmInfoVO> getFilmInfoByCinemaId(int cinemaId);

    /**
     * 根据放映场次ID获取放映信息
     * @param fieldId
     * @return
     */
    HallInfoVO getFilmFieldInfo(int fieldId);

    /**
     * 根据放映场次查询播放的电影编号，然后根据电影编号获取对应的电影信息
     * @param fieldId
     * @return
     */
    FilmInfoVO getFilmInfoByFieldId(int fieldId);

    /**
     * 该部分是订单模块需要的内容
     * @param fieldId
     * @return
     */
    OrderQueryVO getOrderNeeds(int fieldId);
}
