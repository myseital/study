package com.mao.maoyan.film.common.persistence.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mao.maoyan.api.film.vo.ActorVO;
import com.mao.maoyan.film.common.persistence.model.MoocActorT;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 演员表 Mapper 接口
 * </p>
 *
 * @author jiangzh
 * @since 2018-08-26
 */
public interface MoocActorTMapper extends BaseMapper<MoocActorT> {

    List<ActorVO> getActors(@Param("filmId") String filmId);
}
