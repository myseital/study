package com.mao.core.design.pattern.structural.proxy.staticproxy;


import com.mao.core.design.pattern.structural.proxy.Order;

/**
 * @author maojiawei
 */
public class Test {
    public static void main(String[] args) {
        Order order = new Order();
        order.setUserId(2);

        OrderServiceStaticProxy orderServiceStaticProxy = new OrderServiceStaticProxy();
        orderServiceStaticProxy.saveOrder(order);
    }
}
