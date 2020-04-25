package com.xzsd.pc.order.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.order.dao.OrderDao;
import com.xzsd.pc.order.entity.Order;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.user.entity.User;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.AuthUtils;
import com.xzsd.pc.util.DateFormatUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 订单业务处理类
 *
 * @author 邓嘉豪
 * @date 2020-03-27
 */
@Service
public class OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private UserDao userDao;

    /**
     * 查询订单列表接口
     * - 管理员查询所有订单信息列表
     * - 店长查询门店的订单信息列表
     *
     * @param user                 要查询用户信息
     * @param order                要查询的订单信息
     * @param orderBeginPayTimeStr 订单起始时间
     * @param orderEndPayTimeStr   订单结束时间
     * @return
     */
    public AppResponse listOrders(User user, Order order,
                                  String orderBeginPayTimeStr, String orderEndPayTimeStr) {
        //根据当前登录用户的id查找用户信息
        User loginUser = userDao.selectByPrimaryKey(AuthUtils.getCurrentUserId());
        if (loginUser == null) {
            return AppResponse.bizError("登录用户信息获取失败");
        }
        //时间转换String --> Date
        Date orderBiginPayTime = DateFormatUtil.string2date(orderBeginPayTimeStr, DateFormatUtil.YYYY_MM_DD);
        Date orderEndPayTime = DateFormatUtil.string2date(orderEndPayTimeStr, DateFormatUtil.YYYY_MM_DD);
        //获取登录用户的角色
        int userRole = loginUser.getrole();
        PageHelper.startPage(order.getPageNum(), order.getPageSize());
        List<Order> orders = null;
        //当登录查询的是管理员角色
        if (userRole == 1) {
            //根据查询条件查询所有客户信息
            orders = orderDao.listOrders(user, order, orderBiginPayTime, orderEndPayTime);
            //当登录查询的是店长角色
        } else if (userRole == 1) {
            //设置登录用户（店长）的编号进行关联查询其店铺下的订单列表
            user.setUserId(loginUser.getUserId());
            //根据查询条件查询店长的门店的订单信息
            orders = orderDao.listStoreOrders(user, order, orderBiginPayTime, orderEndPayTime);
        }
        PageInfo<Order> pageData = new PageInfo<Order>(orders);
        return AppResponse.success("查询成功!", pageData);
    }

    /**
     * 查询订单详情列表接口
     *
     * @param orderId 订单id
     * @return
     */
    public AppResponse listOrderDetailsById(String orderId) {
        List<Order> orders = orderDao.listOrderDetailsById(orderId);
        return AppResponse.success("查询成功", orders);
    }

    /**
     * 修改订单状态接口
     *
     * @param orderIds       订单编号（批量修改用逗号分开）
     * @param orderCondition 订单状态
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderConditionById(String orderIds, int orderCondition) {
        List<String> listIds = Arrays.asList(orderIds.split(","));
        //根据订单id列表批量修改订单状态
        int count = orderDao.updateOrderConditionById(listIds, AuthUtils.getCurrentUserId(), orderCondition);
        if(count != listIds.size()){
            //回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return AppResponse.bizError("所选列表有未存在数据，修改失败");
        }
        return AppResponse.success("修改订单状态成功");
    }

}











