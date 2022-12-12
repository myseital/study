package com.mao.design.design.pattern.behavioral.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * 策略上下文，用于管理策略的注册和获取
 */
public class StrategyContext {
    private static final Map<String, PromotionStrategy> registerMap = new HashMap<>();

    /**
     * 注册策略
     * @param rewardType
     * @param strategy
     */
    public static void registerStrategy(String rewardType, PromotionStrategy strategy) {
        registerMap.putIfAbsent(rewardType, strategy);
    }

    /**
     * 获取策略
     * @param rewardType
     * @return
     */
    public static PromotionStrategy getStrategy(String rewardType) {
        return registerMap.get(rewardType);
    }
}