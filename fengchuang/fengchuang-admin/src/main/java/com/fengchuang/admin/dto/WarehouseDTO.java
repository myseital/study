package com.fengchuang.admin.dto;

import lombok.Data;

/**
 * @author myseital
 * @date 2022/2/8 16:44
 */
@Data
public class WarehouseDTO {
    private Integer id;
    /**
     * 编码
     */
    private String code;
    /**
     * 名称
     */
    private String name;
}
