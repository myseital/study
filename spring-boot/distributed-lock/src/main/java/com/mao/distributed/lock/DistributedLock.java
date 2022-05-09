package com.mao.distributed.lock;

import java.util.concurrent.TimeUnit;

public interface DistributedLock<T> {

    T getLock(String lockKey);

    T lock(String lockKey);

    T lock(String lockKey, int timeout);

    T lock(String lockKey, TimeUnit unit, int timeout);

    boolean tryLock(String lockKey, TimeUnit unit, int waitTime, int leaseTime);

    void unlock(String lockKey);

    void unlock(T lock);
}