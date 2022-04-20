package com.mao.algorithm.util;

import java.util.LinkedHashMap;
import java.util.Map;


public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int CACHE_SIZE;

    // 这里就是传递进来最多能缓存多少数据
    public LRUCache(int cacheSize) {
//  true指linkedhashmap将元素按访问顺序排序
        super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
        CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
// 当KV数据量大于指定缓存个数时，就自动删除最老数据
        return size() > CACHE_SIZE;
    }
}