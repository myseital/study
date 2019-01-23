package com.mao.maoyan.getaway.modular.film.vo;

import com.mao.maoyan.api.film.vo.CatVO;
import com.mao.maoyan.api.film.vo.SourceVO;
import com.mao.maoyan.api.film.vo.YearVO;
import lombok.Data;

import java.util.List;

/**
 * @author myseital
 */
@Data
public class FilmConditionVO {

    private List<CatVO> catInfo;
    private List<SourceVO> sourceInfo;
    private List<YearVO> yearInfo;
}
