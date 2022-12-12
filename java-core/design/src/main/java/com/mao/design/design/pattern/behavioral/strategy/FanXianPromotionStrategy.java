package com.mao.design.design.pattern.behavioral.strategy;

/**
 * @author maojiawei
 */
public class FanXianPromotionStrategy extends AbstractStrategy {

    private static final FanXianPromotionStrategy instance = new FanXianPromotionStrategy();

    private FanXianPromotionStrategy() {
        register();
    }
    public static FanXianPromotionStrategy getInstance() {
        return instance;
    }

    @Override
    public void doPromotion() {
        System.out.println("返现促销,返回的金额存放到慕课网用户的余额中");
    }
}
