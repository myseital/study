package com.mao.mybatis.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.mao.mybatis.domain.Supplier;
import com.mao.mybatis.mapper.SupplierMapper;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 *
 * @author myseital
 * @date 2022/6/23 13:07
 */
@Service
public class SupplierService{

    @Resource
    private SupplierMapper supplierMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return supplierMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    public int insert(Supplier record) {
        try {
            int insert = supplierMapper.insert(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    
    public int insertSelective(Supplier record) {
        return supplierMapper.insertSelective(record);
    }

    
    public Supplier selectByPrimaryKey(Integer id) {
        return supplierMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(Supplier record) {
        return supplierMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Supplier record) {
        return supplierMapper.updateByPrimaryKey(record);
    }

}
