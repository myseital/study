package com.mao.leaf.service;

import com.mao.leaf.common.enums.Id4BizTagEnum;
import com.sankuai.inf.leaf.common.Result;
import com.sankuai.inf.leaf.common.Status;
import com.sankuai.inf.leaf.service.SegmentService;
import com.sankuai.inf.leaf.service.SnowflakeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.Random;

/**
 * @author myseital
 * @date 2022/04/16 22:39
 */
@Slf4j
@Service
public class IdService {

    @Resource
    private SnowflakeService snowflakeService;

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
            int i = new Random().nextInt();
            Result result;
            if (i % 2 ==0) {
                log.info("segmentService invoker");
                result = segmentService.getId(code);
            } else {
                result = snowflakeService.getId(code);
                log.info("snowflakeService invoker");
            }
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
