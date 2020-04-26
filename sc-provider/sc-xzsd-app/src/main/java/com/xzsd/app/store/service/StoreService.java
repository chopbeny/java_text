package com.xzsd.app.store.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.goods.entity.GoodsInfo;
import com.xzsd.app.order.entity.OrderInfo;
import com.xzsd.app.store.dao.StoreDao;
import com.xzsd.app.store.entity.StoreDetailInfo;
import com.xzsd.app.store.entity.StoreInfo;
import com.xzsd.app.util.AppResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

/**
 * Store实现类
 * 邓嘉豪
 * 2020-04-04 21:36
 */
@Service
public class StoreService {

@Resource
private StoreDao storeDao;


    /**
     * 店长门下司机列表
     * 邓嘉豪
     * 2020-04-16 10:42
     */
    public AppResponse listDrivers(StoreInfo storeInfo) {
        String userId = SecurityUtils.getCurrentUserId();
        storeInfo.setUserId(userId);
        return AppResponse.success("查询成功！",storeDao.listDrivers(storeInfo));
    }



    /**
     * 查询店长订单分页列表
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param storeDetailInfo    查询商品信息条件
     * @return
     */

    public AppResponse listManagerOrders(StoreDetailInfo storeDetailInfo){
        //获取当前店长人id
        String userId = SecurityUtils.getCurrentUserId();
        //获取店铺id
        storeDetailInfo.setOrderStoreCode(storeDao.getStoreById(userId));
        PageHelper.startPage(storeDetailInfo.getPageNum(), storeDetailInfo.getPageSize());
        List<StoreDetailInfo> storeInfoList = storeDao.listManagerOrders(storeDetailInfo);
        // 包装Page对象
        PageInfo<StoreDetailInfo> pageData = new PageInfo<StoreDetailInfo>(storeInfoList);
        return AppResponse.success("查询成功！",pageData);
    }




    /**
     * 店长订单状态修改
     * 邓嘉豪
     * 2020-04-15 20:42
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateManagerOrderState(StoreInfo storeInfo){
        //获取登录人id
        String userId = SecurityUtils.getCurrentUserId();
        //获取店铺id
        storeInfo.setOrderStoreCode(storeDao.getStoreById(userId));
        storeInfo.setUpdatePerson(userId);
        storeInfo.setUserId(userId);
        //订单状态修改
        int count = storeDao.updateManagerOrderState(storeInfo);
        if(count == 0){
            return AppResponse.bizError("订单状态修改失败，请重试！");
        }
        return AppResponse.success("修改成功！");
    }




    /**
     * 查询店长订单详情
     * 邓嘉豪
     * 2020-04-15 17:15
     */
    public AppResponse listManagerOrderDeepen(StoreDetailInfo storeDetailInfo,String orderId){
        //获取登录人id
        String userId = SecurityUtils.getCurrentUserId();
        //获取店铺id
        storeDetailInfo.setOrderStoreCode(storeDao.getStoreById(userId));

        return AppResponse.success("查询成功！",storeDao.listManagerOrderDeepen(storeDetailInfo,orderId));
    }




}
