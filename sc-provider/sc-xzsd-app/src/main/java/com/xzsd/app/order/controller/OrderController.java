package com.xzsd.app.order.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.order.entity.OrderDetailsInfo;
import com.xzsd.app.order.entity.OrderInfo;
import com.xzsd.app.order.service.OrderService;
import com.xzsd.app.util.AppResponse;
import com.xzsd.app.util.AuthUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单管理控制器
 *
 * @author 邓嘉豪
 * @date 2020-04-12
 */
@RestController
@RequestMapping("/clientOrder")
public class OrderController {


    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);


    @Autowired
    private OrderService orderService;


    /**
     * 新增订单
     * 邓嘉豪
     * 2020-04-14 19:58
     */
    @PostMapping(value = "addOrder")
    public AppResponse addOrder(OrderInfo orderInfo) {
        try {
            String userId = AuthUtils.getCurrentUserId();
            orderInfo.setCreatePerson(userId);
            return orderService.addOrder(orderInfo);
        } catch (Exception e) {
            logger.error("新增订单异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }





    /**
     * 订单状态修改
     * 邓嘉豪
     * 2020-04-15 20:37
     */

    @PostMapping(value = "updateOrderState")
    public AppResponse updateOrderState(OrderInfo orderInfo) {
        try {
            String userId = SecurityUtils.getCurrentUserId();
            orderInfo.setCreatePerson(userId);
            return orderService.updateOrderCondition(orderInfo);
        } catch (Exception e) {
            logger.error("订单状态修改异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 订单详情
     * 邓嘉豪
     * 2020-04-14 17:11
     */
    @RequestMapping("listOrderDeepen")
    public AppResponse findOrderById(OrderDetailsInfo orderDetailsInfo, String orderId){
        try {
            System.out.println("11111111111111    " + orderId);
            return orderService.findOrderById(orderDetailsInfo,orderId);
        } catch (Exception e) {
            logger.error("查询订单详情异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 订单分页列表
     * 邓嘉豪
     * 2020-04-14 21:57
     */
    @RequestMapping("listOrder")
    public AppResponse listOrders(OrderDetailsInfo orderDetailsInfo){
        try {
            return orderService.listOrders(orderDetailsInfo);
        } catch (Exception e) {
            logger.error("查询订单分页列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }





}
