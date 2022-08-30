package com.fengchuang.common.dto;

import lombok.Data;

/**
 * @author myseital
 * @date 2022/2/8 16:38
 */
@Data
public class WarehouseQueryPageDTO extends QueryPageDTO {

    /**
     * 仓库编码
     */
    private String code;
    /**
     * 仓库名称
     */
    private String name;
}
