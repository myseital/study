package com.fengchuang.common.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author myseital
 * @date 2022/2/8 17:53
 */
@Data
public class WarehouseRequest implements Serializable {
    private static final long serialVersionUID = 7265086037822674112L;

    /**
     * 仓库编码
     */
    @NotBlank(message = "仓库编码不能为空")
    private String code;
    /**
     * 仓库名称
     */
    @NotBlank(message = "仓库名称不能为空")
    private String name;
}
