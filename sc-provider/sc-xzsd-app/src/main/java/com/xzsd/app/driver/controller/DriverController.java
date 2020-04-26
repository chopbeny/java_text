package com.xzsd.app.driver.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.driver.entity.Driver;
import com.xzsd.app.driver.service.DriverService;
import com.xzsd.app.util.AppResponse;
import com.xzsd.app.util.AuthUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 司机信息控制器
 *
 * @author 邓嘉豪
 * @date 2020-03-29
 */
@RestController
@RequestMapping("/driverHome")
public class DriverController {

    private static final Logger logger = LoggerFactory.getLogger(DriverController.class);

    @Autowired
    private DriverService driverService;



    /**
     * 查询司机信息列表接口
     * - 管理员查询所有司机信息列表
     * - 司机查询自己的信息列表
     * @author 邓嘉豪
     * @date 2020-03-29
     * @return
     */
    @PostMapping("/listDriverStores")
    public AppResponse listDrivers(Driver driver){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            return driverService.listDrivers(userId,driver);
        } catch (Exception e) {
            logger.error("查询司机列表异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }
}
