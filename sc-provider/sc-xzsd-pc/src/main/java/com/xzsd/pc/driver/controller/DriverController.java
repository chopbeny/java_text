package com.xzsd.pc.driver.controller;

import com.xzsd.pc.driver.entity.Driver;
import com.xzsd.pc.driver.service.DriverService;
import com.xzsd.pc.user.entity.User;
import com.xzsd.pc.util.AppResponse;
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
@RequestMapping("/driver")
public class DriverController {

    private static final Logger logger = LoggerFactory.getLogger(DriverController.class);

    @Autowired
    private DriverService driverService;

    /**
     * 新增司机信息接口
     * @param user 存放司机关联的用户表的信息
     * @param driver 存放司机表的信息
     * @param imageId 头像图片id
     * @author 邓嘉豪
     * @date 2020-03-29
     * @return
     */
    @PostMapping("/addDriver")
    public AppResponse addDriver(User user, Driver driver, String imageId){
        try {
            return driverService.addDriver(user, driver, imageId);
        } catch (Exception e) {
            logger.error("新增司机异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }

    /**
     * 查询司机信息列表接口
     * - 管理员查询所有司机信息列表
     * - 司机查询自己的信息列表
     * @author 邓嘉豪
     * @date 2020-03-29
     * @param user 查询条件，存放在user表里的司机信息
     * @param driver 查询条件，存放在driver表里的司机信息
     * @return
     */
    @PostMapping("/listDrivers")
    public AppResponse listDrivers(User user, Driver driver){
        try {
            return driverService.listDrivers(user, driver);
        } catch (Exception e) {
            logger.error("查询司机列表异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }

    /**
     * 查询司机信息详情接口（包含用户表、司机表、区域名称表里的信息）
     * @param userId 在user表中司机的id
     * @author 邓嘉豪
     * @date 2020-03-29
     * @return
     */
    @PostMapping("/findDriverById")
    public AppResponse findDriverById(String userId){
        try {
            return driverService.findDriverById(userId);
        } catch (Exception e) {
            logger.error("查询司机信息异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }

    /**
     * 修改司机信息接口
     * @param user 要修改的在用户表的信息
     * @param driver 要修改的在司机表的信息
     * @param imageId 头像图片的id
     * @author 邓嘉豪
     * @date 2020-03-29
     * @return
     */
    @PostMapping("/updateDriversById")
    public AppResponse updateDriversById(User user, Driver driver, String imageId){
        try {
            return driverService.updateDriversById(user, driver, imageId);
        } catch (Exception e) {
            logger.error("修改司机信息异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }

    /**
     * 删除司机接口
     * @param userIds 要删除的用户表的id（批量删除用逗号分开）
     * @author 邓嘉豪
     * @date 2020-03-29
     * @return
     */
    @PostMapping("/deleteDriverByUserId")
    public AppResponse deleteDriverByUserId(String userIds){
        try {
            return driverService.deleteDriverByUserId(userIds);
        } catch (Exception e) {
            logger.error("删除司机信息异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }

}


















