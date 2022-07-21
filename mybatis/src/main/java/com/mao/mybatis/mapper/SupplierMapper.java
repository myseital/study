package com.mao.mybatis.mapper;

import com.mao.mybatis.domain.Supplier;

/**
 * 
 *
 * @author myseital
 * @date 2022/6/23 13:07
 */
public interface SupplierMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    Supplier selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);
}