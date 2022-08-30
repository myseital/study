package com.fengchuang.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author myseital
 * @date 2022/2/8 16:32
 */
@Data
public class QueryPageDTO implements Serializable {
    private static final long serialVersionUID = 2549513589359202984L;
    /**
     * 分页查询起始页
     */
    protected Integer pageIndex = 1;

    /**
     * 分页查询每页行数
     */
    protected Integer pageSize = 10;
}
