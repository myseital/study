package com.mao.mybatis.domain;

import java.util.Date;
import lombok.Data;

/**
 * 
 *
 * @author myseital
 * @date 2022/6/23 13:07
 */
/**
    * 供应商表
    */
@Data
public class Supplier {
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
    * 收款单位名称
    */
    private String accountName;

    /**
    * 税号
    */
    private String taxNumber;

    /**
    * 收款单位开户银行名称
    */
    private String bankName;

    /**
    * 收款单位开户银行账号
    */
    private String bankAccount;

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