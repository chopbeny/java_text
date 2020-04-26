package com.xzsd.app.order.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.app.clientShopCart.dao.CartDao;
import com.xzsd.app.goods.dao.GoodsDao;
import com.xzsd.app.order.dao.OrderDao;
import com.xzsd.app.order.dao.OrderDetailsDao;
import com.xzsd.app.order.entity.OrderDetailsInfo;
import com.xzsd.app.order.entity.OrderInfo;
import com.xzsd.app.util.AppResponse;
import com.xzsd.app.util.AuthUtils;
import com.xzsd.app.util.StringUtil;
import com.xzsd.app.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 订单实现类
 * 邓嘉豪
 * 2020-04-13 9:31
 */
@Service
public class OrderService {

    @Resource
    private GoodsDao goodsDao;

    @Resource
    private CartDao cartDao;

    @Resource
    private OrderDao orderDao;

    @Resource
    private OrderDetailsDao orderDetailsDao;



    /**
     * 新增订单
     * 邓嘉豪
     * 购物车下单
     * 2020-04-14 20:25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addOrder(OrderInfo orderInfo) {
        //1.获取商品编号、商品价格、商品数量列表
        List<String> listGoodsIds = Arrays.asList(orderInfo.getGoodsId().split(","));
        List<String> listGoodsPrice = Arrays.asList(orderInfo.getGoodsPrice().split(","));
        List<String> listGoodsSum = Arrays.asList(orderInfo.getClientGoodsNum().split(","));
        //查询商品是否存在
        int count = goodsDao.findGoodsByList(listGoodsIds);
        if (count != listGoodsIds.size()) {
            return AppResponse.bizError("所选列表有未存在数据，新增失败");
        } else {
            //2.计算每个商品的价格和总价
            float toatalPrice = 0;
            int totalSum = 0;

            for (int i = 0; i < listGoodsIds.size(); i++) {
                //每一个 商品的价格=商品价格 * 商品数量
                float goodsTotalPrice = Integer.parseInt(listGoodsPrice.get(i)) * Integer.parseInt(listGoodsSum.get(i));
                //该订单所有商品总价格
                toatalPrice += goodsTotalPrice;
                //该订单所有商品的总数量
                totalSum += Integer.parseInt(listGoodsSum.get(i));
            }

            //3.设置订单和订单明细的信息
            //3.1设置订单信息
            orderInfo.setOrderId(UUIDUtils.getUUID());
            orderInfo.setOrderCode(StringUtil.getCommonCode(2));
            orderInfo.setCreatePerson(AuthUtils.getCurrentUserId());
            orderInfo.setUpdatePerson(AuthUtils.getCurrentUserId());
            orderInfo.setVersion(1);
            orderInfo.setIsDeleted(1);
            orderInfo.setOrderClientCode(AuthUtils.getCurrentUserId());
            orderInfo.setOrderTotalPrice(String.valueOf(toatalPrice));
            orderInfo.setOrderCondition(String.valueOf(1));
            orderInfo.setOrderPayCondition(String.valueOf(1));
            orderInfo.setOrderTotalSum(String.valueOf(totalSum));

            //3.2设置订单详情信息
            List<OrderDetailsInfo> orderDetailsInfos = new ArrayList<>();
            for (int i = 0; i < listGoodsIds.size(); i++){
                OrderDetailsInfo orderDetailsInfo = new OrderDetailsInfo();
                orderDetailsInfo.setOrderDetailId(UUIDUtils.getUUID());
                orderDetailsInfo.setCreatePerson(AuthUtils.getCurrentUserId());
                orderDetailsInfo.setUpdatePerson(AuthUtils.getCurrentUserId());
                orderDetailsInfo.setVersion(1);
                orderDetailsInfo.setIsDeleted(1);
                orderDetailsInfo.setOrderDetailOrderCode(orderInfo.getOrderId());
                orderDetailsInfo.setOrderDetailGoodsCode(listGoodsIds.get(i));
                orderDetailsInfo.setOrderDetailGoodsNum(listGoodsSum.get(i));
                orderDetailsInfo.setOrderDetailGoodsTotalPrice(listGoodsPrice.get(i));

                orderDetailsInfos.add(orderDetailsInfo);
            }

            //4.插入订单信息和订单详情信息
            int countOrder = orderDao.addOrder(orderInfo);
            if (countOrder == 0) {
                return AppResponse.bizError("新增订单失败，请重试！");
            }
            int countOrderDetail = orderDetailsDao.addOrderDetails(orderDetailsInfos);
            if (countOrderDetail == 0) {
                return AppResponse.bizError("新增订单明细失败，请重试！");
            }

            //删除购物车
            List<String> listCartId = Arrays.asList(orderInfo.getShopCartId().split(","));
            int countCart = cartDao.deleteShoppingCart(listCartId, AuthUtils.getCurrentUserId());
            //当要删除的商品总数和已删除的总数不等时，回滚事物，删除失败
            if (countCart != listCartId.size()) {
                //回滚事物
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return AppResponse.bizError("所选列表有未存在数据，删除失败");
            } else {
                return AppResponse.success("下单成功");
            }


        }

    }



    /**
     * 订单状态修改
     * 邓嘉豪
     * 2020-04-15 20:42
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderCondition(OrderInfo orderInfo){
        //订单状态修改
        int count = orderDao.updateOrderCondition(orderInfo);
        if(count == 0){
            return AppResponse.bizError("订单状态修改失败，请重试！");
        }
        return AppResponse.success("修改成功！");
    }


    /**
     * 订单详情
     * 邓嘉豪
     * 2020-04-15 17:15
     */
    public AppResponse findOrderById(OrderDetailsInfo orderDetailsInfo,String orderId){
        return AppResponse.success("查询成功！",orderDao.findOrderById(orderDetailsInfo,orderId));
    }


    /**
     * 订单分页列表
     * 邓嘉豪
     * 2020-04-14 22:00
     */
    public AppResponse listOrders(OrderDetailsInfo orderDetailsInfo){
        PageHelper.startPage(orderDetailsInfo.getPageNum(), orderDetailsInfo.getPageSize());
        List<OrderDetailsInfo> orderInfoList = orderDao.listOrder(orderDetailsInfo);
        // 包装Page对象
        PageInfo<OrderDetailsInfo> pageData = new PageInfo<OrderDetailsInfo>(orderInfoList);
        return AppResponse.success("查询成功！",pageData);
    }









}
