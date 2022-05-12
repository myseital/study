package com.mao.spring.cloud.alibaba.sentinel.config;

import com.alibaba.csp.sentinel.datasource.WritableDataSource;
import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;

/**
 * @author myseital
 * @date 2022/5/13 02:25
 */
public class NacosWritableDataSource<T> implements WritableDataSource<T> {

    @Override
    public void write(T t) throws Exception {
        String remoteAddress = "localhost:8848";
        String groupId = "Sentinel_Demo";
        String dataId = "com.alibaba.csp.sentinel.demo.flow.rule";
        ConfigService configService = NacosFactory.createConfigService(remoteAddress);
        configService.publishConfig(dataId, groupId, encodeJson(t));
    }

    @Override
    public void close() throws Exception {

    }

    private <T> String encodeJson(T t) {
        return JSON.toJSONString(t);
    }
}
