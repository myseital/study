package com.mao.rocketmq.project.pay.service;

public interface PayService {

	String payment(String userId, String orderId, String accountId, double money);
}
