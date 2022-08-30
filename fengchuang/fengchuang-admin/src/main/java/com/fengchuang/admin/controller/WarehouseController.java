package com.fengchuang.admin.controller;

import com.fengchuang.admin.dto.WarehouseDTO;
import com.fengchuang.admin.service.WarehouseService;
import com.fengchuang.common.annotation.LogAnnotation;
import com.fengchuang.common.annotation.PageCheck;
import com.fengchuang.common.dto.WarehouseQueryPageDTO;
import com.fengchuang.common.dto.WarehouseRequest;
import com.fengchuang.common.dto.WarehouseUpdateRequest;
import com.fengchuang.common.vo.ApiResultVO;
import com.fengchuang.common.vo.PageResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author myseital
 * @date 2022/2/7 14:59
 */
@Slf4j
@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    @Resource
    private WarehouseService warehouseService;

    @GetMapping("/list")
    @PageCheck
    @LogAnnotation(module = "仓库模块", function = "查询仓库列表")
    public PageResultVO<WarehouseDTO> list(WarehouseQueryPageDTO queryDTO) {
        return warehouseService.queryByPage(queryDTO);
    }

    @PostMapping("/create")
    public ApiResultVO create(@Valid WarehouseRequest request) {
        warehouseService.create(request);
        return ApiResultVO.buildSuccess();
    }

    @PostMapping("/update")
    public ApiResultVO<WarehouseDTO> update(@Valid WarehouseUpdateRequest request) {
        warehouseService.update(request);
        return ApiResultVO.buildSuccess();
    }
}
