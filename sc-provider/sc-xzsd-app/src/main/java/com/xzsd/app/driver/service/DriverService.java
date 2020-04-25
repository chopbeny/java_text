package com.xzsd.app.driver.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.app.driver.dao.DriverDao;
import com.xzsd.app.driver.entity.Driver;
import com.xzsd.app.user.dao.UserDao;
import com.xzsd.app.user.entity.User;
import com.xzsd.app.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 司机信息业务处理类
 *
 * @author 邓嘉豪
 * @date 2020-03-29
 */
@Service
public class DriverService {

    @Resource
    private DriverDao driverDao;

    @Resource
    private UserDao userDao;



    /**
     * 查询司机信息列表接口
     * - 管理员查询所有司机信息列表
     * - 司机查询自己的信息列表
     * @return
     */
    public AppResponse listDrivers(String userId,Driver driver) {
        //获取当前登录人信息
        User driverdetial = userDao.selectByPrimaryKey(userId);
        //获取登录人绑定店铺编号
        String storeCode = driverdetial.getinviteCode();
        driver.setstoreCode(storeCode);
        PageHelper.startPage(driver.getPageNum(), driver.getPageSize());
        List<Driver> drivers = driverDao.listStoreClients(driver);
        PageInfo<Driver> pageData = new PageInfo<Driver>(drivers);
        return AppResponse.success("查询成功!", pageData);
    }





}
