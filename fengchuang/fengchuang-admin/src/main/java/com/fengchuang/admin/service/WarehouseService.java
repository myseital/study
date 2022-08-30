package com.fengchuang.admin.service;

import com.fengchuang.admin.dto.WarehouseDTO;
import com.fengchuang.common.dto.WarehouseQueryPageDTO;
import com.fengchuang.common.dto.WarehouseRequest;
import com.fengchuang.common.dto.WarehouseUpdateRequest;
import com.fengchuang.common.vo.PageResultVO;


/**
 * @author myseital
 * @date 2022/2/8 16:30
 */
public interface WarehouseService {

    /**
     * 分页查询仓库列表
     * @param queryDTO
     * @return
     */
    PageResultVO<WarehouseDTO> queryByPage(WarehouseQueryPageDTO queryDTO);

    /**
     * 创建仓库信息
     * @param request
     * @return
     */
    void create(WarehouseRequest request);

    /**
     * 更新仓库信息
     * @param request
     * @return
     */
    void update(WarehouseUpdateRequest request);
}
