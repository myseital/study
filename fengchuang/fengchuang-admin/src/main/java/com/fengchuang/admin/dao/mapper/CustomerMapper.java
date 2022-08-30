package com.fengchuang.admin.dao.mapper;

import com.fengchuang.admin.dao.model.Customer;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface CustomerMapper extends Mapper<Customer>, MySqlMapper<Customer> {
}