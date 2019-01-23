package com.mao.maoyan.getaway.modular.cinema.vo;

import com.mao.maoyan.api.cinema.vo.CinemaVO;
import lombok.Data;

import java.util.List;

@Data
public class CinemaListResponseVO {

    private List<CinemaVO> cinemas;
}
