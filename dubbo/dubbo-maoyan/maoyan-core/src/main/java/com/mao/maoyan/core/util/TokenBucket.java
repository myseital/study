package com.mao.maoyan.core.util;

/**
 * 因为令牌桶对业务有一定的容忍度
 * @author myseital
 */
public class TokenBucket {

    /**
     * 桶的容量
     */
    private Integer bucketNums = 100;
    /**
     * 流入速度
     */
    private Integer rate = 1;
    /**
     * 当前令牌数量
     */
    private Integer nowTokens;
    /**
     * 时间
     */
    private Long timestamp = getNowTime();

    private long getNowTime() {
        return System.currentTimeMillis();
    }

    private int min(int tokens) {
        if (bucketNums > tokens) {
            return tokens;
        } else {
            return bucketNums;
        }
    }

    public boolean getToken() {
        // 记录来拿令牌的时间
        long nowTime = getNowTime();
        // 添加令牌【判断该有多少个令牌】
        nowTokens = nowTokens + (int) ((nowTime - timestamp) * rate);
        // 添加以后的令牌数量与桶的容量那个小
        nowTokens = min(nowTokens);
        System.out.println("当前令牌数量" + nowTokens);
        // 修改拿令牌的时间
        timestamp = nowTime;
        // 判断令牌是否足够
        if (nowTokens < 1) {
            return false;
        } else {
            nowTokens -= 1;
            return true;
        }
    }
}
