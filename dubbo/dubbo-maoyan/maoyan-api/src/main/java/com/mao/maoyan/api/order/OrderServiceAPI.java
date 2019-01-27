package com.mao.maoyan.api.order;

import com.baomidou.mybatisplus.plugins.Page;
import com.mao.maoyan.api.order.vo.OrderVO;

public interface OrderServiceAPI {

    /**
     * 验证售出的票是否为真
     * @param fieldId
     * @param seats
     * @return
     */
    Boolean isTrueSeats(String fieldId, String seats);

    /**
     * 已经销售的座位里，有没有这些座位
     * @param fieldId
     * @param seats
     * @return
     */
    Boolean isNotSoldSeats(String fieldId, String seats);

    /**
     * 创建订单信息
     * @param fieldId
     * @param soldSeats
     * @param seatsName
     * @param userId
     * @return
     */
    OrderVO saveOrderInfo(Integer fieldId, String soldSeats, String seatsName, Integer userId);

    /**
     * 使用当前登陆人获取已经购买的订单
     * @param userId
     * @param page
     * @return
     */
    Page<OrderVO> getOrderByUserId(Integer userId, Page<OrderVO> page);

    /**
     * 根据FieldId 获取所有已经销售的座位编号
     * @param fieldId
     * @return
     */
    String getSoldSeatsByFieldId(Integer fieldId);

    /**
     * 根据订单编号获取订单信息
     * @param orderId
     * @return
     */
    OrderVO getOrderInfoById(String orderId);

    Boolean paySuccess(String orderId);

    Boolean payFail(String orderId);
}
