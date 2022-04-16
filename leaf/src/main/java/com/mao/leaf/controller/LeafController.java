package com.mao.leaf.controller;

import com.mao.leaf.common.enums.Id4BizTagEnum;
import com.mao.leaf.service.IdService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author myseital
 * @date 2022/4/16 23:22
 */
@RestController
public class LeafController {

    @Resource
    private IdService idService;

    @GetMapping("/leaf")
    public String getId() {
        Long orderDistributedId = idService.getOrderDistributedId(Id4BizTagEnum.B2C_ORDER);
        return orderDistributedId.toString();
    }
}
