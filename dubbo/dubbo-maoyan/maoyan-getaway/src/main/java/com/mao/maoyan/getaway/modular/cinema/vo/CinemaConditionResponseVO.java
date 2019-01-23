package com.mao.maoyan.getaway.modular.cinema.vo;

import com.mao.maoyan.api.cinema.vo.AreaVO;
import com.mao.maoyan.api.cinema.vo.BrandVO;
import com.mao.maoyan.api.cinema.vo.HallTypeVO;
import lombok.Data;

import java.util.List;

@Data
public class CinemaConditionResponseVO {

    private List<BrandVO> brandList;
    private List<AreaVO> areaList;
    private List<HallTypeVO> halltypeList;
}
