package com.fengchuang.common.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author myseital
 * @date 2022/2/8 17:53
 */
@Data
public class WarehouseUpdateRequest extends WarehouseRequest {

    @NotNull(message = "仓库信息不能为空")
    private Integer id;
}
