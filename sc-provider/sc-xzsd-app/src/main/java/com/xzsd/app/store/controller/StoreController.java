package com.xzsd.app.store.controller;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.order.controller.OrderController;
import com.xzsd.app.order.entity.OrderDetailsInfo;
import com.xzsd.app.store.entity.StoreDetailInfo;
import com.xzsd.app.store.entity.StoreInfo;
import com.xzsd.app.store.service.StoreService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/managerOrder")
public class StoreController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Resource
    private StoreService storeService;
    /**
     * 店长门下司机列表
     * 邓嘉豪
     * 2020-04-16 10:41
     */
    @RequestMapping(value = "listManagerDrivers")
    public AppResponse listDrivers(StoreInfo storeInfo) {
        try {
            return storeService.listDrivers(storeInfo);
        } catch (Exception e) {
            logger.error("查询司机列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 查询店长订单分页列表
     * 邓嘉豪
     * 2020-04-14 21:57
     */

    @RequestMapping("listManagerOrders")
    public AppResponse listManagerOrders(StoreDetailInfo storeDetailInfo){
        try {
            return storeService.listManagerOrders(storeDetailInfo);
        } catch (Exception e) {
            logger.error("查询订单分页列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 订单店长状态修改
     * 邓嘉豪
     * 2020-04-15 20:37
     */

    @PostMapping(value = "updateManagerOrderState")
    public AppResponse updateManagerOrderState(StoreInfo storeInfo) {
        try {
            return storeService.updateManagerOrderState(storeInfo);
        } catch (Exception e) {
            logger.error("订单状态修改异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 查询店长订单详情
     * 邓嘉豪
     * 2020-04-14 17:11
     */
    @RequestMapping("listManagerOrderDeepen")
    public AppResponse listManagerOrderDeepen(StoreDetailInfo storeDetailInfo, String orderId){
        try {
            return storeService.listManagerOrderDeepen(storeDetailInfo,orderId);
        } catch (Exception e) {
            logger.error("查询订单详情异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }






}
