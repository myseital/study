package com.mao.design.design.pattern.structural.proxy.dynamicproxy;

import com.mao.design.design.pattern.structural.proxy.IOrderService;
import com.mao.design.design.pattern.structural.proxy.Order;
import com.mao.design.design.pattern.structural.proxy.OrderServiceImpl;

/**
 * @author maojiawei
 */
public class Test {

    public static void main(String[] args) {
        Order order = new Order();
//        order.setUserId(2);
        order.setUserId(1);
        IOrderService orderServiceDynamicProxy = (IOrderService) new OrderServiceDynamicProxy(new OrderServiceImpl()).bind();

        orderServiceDynamicProxy.saveOrder(order);
    }
}
