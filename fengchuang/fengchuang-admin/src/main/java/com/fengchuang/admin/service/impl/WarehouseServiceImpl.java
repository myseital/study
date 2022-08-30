package com.fengchuang.admin.service.impl;

import com.fengchuang.admin.dao.mapper.WarehouseMapper;
import com.fengchuang.admin.dao.model.Warehouse;
import com.fengchuang.admin.dto.WarehouseDTO;
import com.fengchuang.admin.service.WarehouseService;
import com.fengchuang.common.ServiceException;
import com.fengchuang.common.constant.AdminConstant;
import com.fengchuang.common.dto.WarehouseQueryPageDTO;
import com.fengchuang.common.dto.WarehouseRequest;
import com.fengchuang.common.dto.WarehouseUpdateRequest;
import com.fengchuang.common.vo.PageResultVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author myseital
 * @date 2022/2/8 16:30
 */
@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Resource
    private WarehouseMapper warehouseMapper;

    @Override
    public PageResultVO<WarehouseDTO> queryByPage(WarehouseQueryPageDTO queryDTO) {
        PageResultVO<WarehouseDTO> resultVO = new PageResultVO<>();
        PageHelper.startPage(queryDTO.getPageIndex() ,queryDTO.getPageSize());
        List<Warehouse> warehouses = warehouseMapper.selectAll();
        PageInfo<Warehouse> page = new PageInfo<>(warehouses);
        if (page.getTotal() > 0) {
            resultVO.setTotal(page.getTotal());
            resultVO.setRows(convert2DTOList(warehouses));
        } else {
            resultVO.setTotal(AdminConstant.ZERO_LONG);
            resultVO.setRows(Lists.newArrayList());
        }

        return resultVO;
    }

    @Override
    public void create(WarehouseRequest request) {
        Warehouse warehouse = new Warehouse();
        warehouse.setCode(request.getCode());
        warehouse.setName(request.getName());
        warehouse.setCreator("system");
        warehouse.setCreatedAt(new Date());
        warehouse.setUpdator("system");
        warehouse.setUpdatedAt(new Date());

        warehouseMapper.insertSelective(warehouse);
    }

    @Override
    public void update(WarehouseUpdateRequest request) {
        Warehouse warehouse = warehouseMapper.selectByPrimaryKey(request.getId());
        if (Objects.isNull(warehouse)) {
            throw new ServiceException(401, "仓库信息不存在");
        }
        warehouse.setCode(request.getCode());
        warehouse.setName(request.getName());
        warehouse.setUpdator("system");
        warehouse.setUpdatedAt(new Date());

        warehouseMapper.updateByPrimaryKey(warehouse);
    }

    private List<WarehouseDTO> convert2DTOList(List<Warehouse> warehouses) {
        List<WarehouseDTO> warehouseDTOList = new ArrayList<>();
        for (Warehouse warehouse : warehouses) {
            warehouseDTOList.add(convert2DTO(warehouse));
        }

        return warehouseDTOList;
    }

    private WarehouseDTO convert2DTO(Warehouse warehouse) {
        WarehouseDTO warehouseDTO = new WarehouseDTO();
        warehouseDTO.setId(warehouse.getId());
        warehouseDTO.setCode(warehouse.getCode());
        warehouseDTO.setName(warehouse.getName());

        return warehouseDTO;
    }
}
