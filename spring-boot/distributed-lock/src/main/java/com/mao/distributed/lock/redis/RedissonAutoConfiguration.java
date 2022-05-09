package com.mao.distributed.lock.redis;

import com.mao.distributed.lock.DistributedLock;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonAutoConfiguration {

    @Value("${redisson.address}")
    private String addressUrl;

    /**
     * 单机模式自动装配
     */
    @Bean
    public RedissonClient getRedisson() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress(addressUrl)
                .setRetryInterval(5000)
                .setTimeout(10000)
                .setConnectTimeout(10000);
        return Redisson.create(config);
    }


    /**
     * 装配locker类，并将实例注入到RedissLockUtil中
     */
    @Bean
    DistributedLock distributedLocker(RedissonClient redissonClient) {
        RedissonDistributedLock locker = new RedissonDistributedLock();
        locker.setRedissonClient(redissonClient);
        RedisLockUtil.setLocker(locker);
        return locker;
    }

}