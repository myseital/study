package com.mao.mybatis.service;
import java.util.Date;

import com.mao.mybatis.domain.Supplier;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.mao.mybatis.domain.Customer;
import com.mao.mybatis.mapper.CustomerMapper;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 *
 * @author myseital
 * @date 2022/6/23 13:05
 */
@Service
public class CustomerService{

    @Resource
    private CustomerMapper customerMapper;

    @Resource
    private SupplierService supplierService;
    
    public int deleteByPrimaryKey(Integer id) {
        return customerMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    public void aCallB() {
        Customer customer = new Customer();
        customer.setName("1");
        customer.setMobile("1");
        customer.setPhone("1");
        customer.setAddress("1");
        customer.setCompany("1");
        customer.setCreator("1");
        customer.setCreatedAt(new Date());
        customer.setUpdator("1");
        customer.setUpdatedAt(new Date());
        customerMapper.insert(customer);
        Supplier record = new Supplier();
        supplierService.insert(record);
    }


    public int insert(Customer record) {
        return customerMapper.insert(record);
    }

    
    public int insertSelective(Customer record) {
        return customerMapper.insertSelective(record);
    }

    
    public Customer selectByPrimaryKey(Integer id) {
        return customerMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(Customer record) {
        return customerMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Customer record) {
        return customerMapper.updateByPrimaryKey(record);
    }
}
