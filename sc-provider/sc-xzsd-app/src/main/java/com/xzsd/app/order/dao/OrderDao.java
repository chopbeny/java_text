package com.xzsd.app.order.dao;

import com.xzsd.app.order.entity.OrderDetailsInfo;
import com.xzsd.app.order.entity.OrderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * OrderDao
 * 邓嘉豪
 * 2020-04-02 16:59
 */
public interface OrderDao {


    /**
     * 新增订单
     * 邓嘉豪
     * 2020-04-14 21:19
     */
    int addOrder(OrderInfo orderInfo);

    /**
     * 订单分页列表
     * 邓嘉豪
     * 2020-04-02 17:00
     */
    List<OrderDetailsInfo> listOrder(OrderDetailsInfo orderDetailsInfo);
    /**
     * 订单详情
     * 邓嘉豪
     * 2020-04-03 21:19
     */
    List<OrderDetailsInfo> findOrderById(OrderDetailsInfo orderDetailsInfo ,@Param("orderId") String orderId );
    /**
     * 订单状态修改
     * 邓嘉豪
     * 2020-04-04 11:39
     */
    int updateOrderCondition(OrderInfo orderInfo);
    /**
     * 修改订单状态为已评价
     * 邓嘉豪
     * 2020-04-14 10:32
     */
    int updateOrderStateToFinishComment(@Param("ordersId") String ordersId, @Param("ordersState") String ordersCondition);
}
