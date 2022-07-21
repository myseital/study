package com.mao.mybatis.mapper;

import com.mao.mybatis.domain.Customer;

/**
 * 
 *
 * @author myseital
 * @date 2022/6/23 13:05
 */
public interface CustomerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
}