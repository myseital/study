package com.mao.leaf.service;

import com.mao.leaf.common.enums.Id4BizTagEnum;
import com.sankuai.inf.leaf.common.Result;
import com.sankuai.inf.leaf.common.Status;
import com.sankuai.inf.leaf.service.SegmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author myseital
 * @date 2022/04/16 22:39
 */
@Service
public class IdService {

    @Resource
    private SegmentService segmentService;

    private final int MAX_RETRY_NUM = 10;

    /**
     * 获取分布式ID - 订单模块
     *
     * @param id4BizTagEnum
     * @return
     */
    public Long getOrderDistributedId(Id4BizTagEnum id4BizTagEnum) {
        return generateDistributedId(id4BizTagEnum.getCode());
    }

    private Long generateDistributedId(String code) {
        boolean success = true;
        long id = 0L;
        int retryNum = 1;
        while (success && retryNum <= MAX_RETRY_NUM) {
            Result result = segmentService.getId(code);
            if (Objects.equals(result.getStatus(), Status.SUCCESS)) {
                success = false;
                id = result.getId();
            } else {
                retryNum++;
            }
        }
        if (id == 0L) {
            throw new RuntimeException();
        }
        return id;
    }
}
