package com.mao.springboot.mydemo.service;

import com.mao.log.record.starter.annotaion.LogRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author myseital
 * @date 2022/8/30
 */
@Slf4j
@Service
public class LogService {

    @LogRecord(
            success = "测试【{{#name}}】,操作结果: {{#_ret ? '成功' : '失败'}}",
            operateType = "测试",
            type = "测试", bizNo = "{{#id}}")
    public Boolean testLog(Long id, String name) {
        log.info("记录日志 {}, {}", id, name);

        return Boolean.TRUE;
    }
}
