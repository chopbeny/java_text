package com.xzsd.pc.order.controller;

import com.xzsd.pc.order.entity.Order;
import com.xzsd.pc.order.service.OrderService;
import com.xzsd.pc.user.entity.User;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单管理控制器
 *
 * @author 邓嘉豪
 * @date 2020-03-27
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    /**
     * 查询订单列表接口
     *
     * @param user                 要查询用户信息
     * @param order                要查询的订单信息
     * @param orderBeginPayTimeStr 订单起始时间
     * @param orderEndPayTimeStr   订单结束时间
     * @return
     */
    @PostMapping("/listOrders")
    public AppResponse listOrders(User user, Order order,
                                  String orderBeginPayTimeStr, String orderEndPayTimeStr) {
        try {
            return orderService.listOrders(user, order, orderBeginPayTimeStr, orderEndPayTimeStr);
        } catch (Exception e) {
            logger.error("查询订单信息列表异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }

    /**
     * 查询订单详情列表接口
     *
     * @param orderId 订单id
     * @return
     */
    @PostMapping("/listOrderDetailsById")
    public AppResponse listOrderDetailsById(String orderId) {
        try {
            return orderService.listOrderDetailsById(orderId);
        } catch (Exception e) {
            logger.error("查询订单详情信息异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }

    /**
     * 修改订单状态接口
     *
     * @param orderIds       订单编号（批量修改用逗号分开）
     * @param orderCondition 订单状态
     * @return
     */
    @PostMapping("/updateOrderConditionById")
    public AppResponse updateOrderConditionById(String orderIds, int orderCondition) {
        try {
            return orderService.updateOrderConditionById(orderIds, orderCondition);
        } catch (Exception e) {
            logger.error("修改订单状态信息异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }

}


















