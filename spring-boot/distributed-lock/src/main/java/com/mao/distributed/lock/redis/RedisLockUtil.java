package com.mao.distributed.lock.redis;

import org.redisson.api.RLock;

import java.util.concurrent.TimeUnit;

/**
 * @author myseital
 * @date 2022/5/3 01:30
 */
public class RedisLockUtil {

    private static RedissonDistributedLock redisLock;

    public static void setLocker(RedissonDistributedLock locker) {
        redisLock = locker;
    }

    /**
     * 获得锁
     *
     * @return
     */
    public static RLock getLock(String lockKey) {
        return redisLock.getLock(lockKey);
    }

    /**
     * 加锁
     *
     * @return
     */
    public static RLock lock(String lockKey) {
        return redisLock.lock(lockKey);
    }

    /**
     * 释放锁
     */
    public static void unlock(String lockKey) {
        redisLock.unlock(lockKey);
    }

    /**
     * 释放锁
     */
    public static void unlock(RLock lock) {
        redisLock.unlock(lock);
    }

    /**
     * 带超时的锁
     *
     * @param lockKey
     * @param timeout 超时时间  单位：秒
     */
    public static RLock lock(String lockKey, int timeout) {
        return redisLock.lock(lockKey, timeout);
    }

    /**
     * 带超时的锁
     *
     * @param lockKey
     * @param unit    时间单位
     * @param timeout 超时时间
     */
    public static RLock lock(String lockKey, TimeUnit unit, int timeout) {
        return redisLock.lock(lockKey, unit, timeout);
    }

    /**
     * 尝试获取锁
     *
     * @param lockKey
     * @param waitTime  最多等待时间
     * @param leaseTime 上锁后自动释放锁时间
     * @return
     */
    public static boolean tryLock(String lockKey, int waitTime, int leaseTime) {
        return redisLock.tryLock(lockKey, TimeUnit.SECONDS, waitTime, leaseTime);
    }

    /**
     * 尝试获取锁
     *
     * @param lockKey
     * @param unit      时间单位
     * @param waitTime  最多等待时间
     * @param leaseTime 上锁后自动释放锁时间
     * @return
     */
    public static boolean tryLock(String lockKey, TimeUnit unit, int waitTime, int leaseTime) {
        return redisLock.tryLock(lockKey, unit, waitTime, leaseTime);
    }
}