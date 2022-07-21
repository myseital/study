package com.mao.mybatis.domain;

import java.util.Date;
import lombok.Data;

/**
 * 
 *
 * @author myseital
 * @date 2022/6/23 13:05
 */
/**
    * 客户表
    */
@Data
public class Customer {
    /**
    * 自增主键ID
    */
    private Integer id;

    /**
    * 姓名
    */
    private String name;

    /**
    * 手机
    */
    private String mobile;

    /**
    * 电话
    */
    private String phone;

    /**
    * 地址
    */
    private String address;

    /**
    * 公司名称
    */
    private String company;

    /**
    * 创建人
    */
    private String creator;

    /**
    * 创建时间
    */
    private Date createdAt;

    /**
    * 更新人
    */
    private String updator;

    /**
    * 更新时间
    */
    private Date updatedAt;
}