package com.mao.design.design.pattern.behavioral.strategy;

public abstract class AbstractStrategy implements PromotionStrategy {

    public void register() {
        // 类注册方法
        StrategyContext.registerStrategy(getClass().getSimpleName(), this);
    }
}