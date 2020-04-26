package com.xzsd.app.store.dao;

import com.xzsd.app.store.entity.StoreDetailInfo;
import com.xzsd.app.store.entity.StoreInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * StoreDao
 * 邓嘉豪
 * 2020-04-04 21:40
 */
public interface StoreDao {
    /**
     * 通过邀请码查询门店编号是否存在
     * 邓嘉豪
     * 2020-04-13 10:35
     */
    String StoreIdByInviteCode(@Param("newInviteCode") String newInviteCode);




    /**
     * 查询司机信息
     * 邓嘉豪
     * 2020-04-16 10:46
     */
    List<StoreInfo> listDrivers(StoreInfo storeInfo);




    /**
     * 查询店长订单分页列表
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param storeDetailInfo 商品信息查询条件
     * @return
     */
    List<StoreDetailInfo> listManagerOrders(StoreDetailInfo storeDetailInfo);


    /**
     * 根据登录人的id获取店铺id
     * @param userId
     * @return
     */

    String getStoreById(String userId);



    /**
     * 店长订单状态修改
     * 邓嘉豪
     * 2020-04-04 11:39
     */
    int updateManagerOrderState(StoreInfo storeInfo);



    /**
     * 店长订单详情
     * 邓嘉豪
     * 2020-04-03 21:19
     */
    List<StoreDetailInfo> listManagerOrderDeepen(StoreDetailInfo storeDetailInfo ,@Param("orderId") String orderId );











}
