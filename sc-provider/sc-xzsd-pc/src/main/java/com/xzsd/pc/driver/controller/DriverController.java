package com.xzsd.pc.driver.controller;

import com.neusoft.core.exception.ScServerException;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.driver.entity.DriverSettingDTO;
import com.xzsd.pc.driver.service.DriverService;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.AuthUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description增删改查司机
 * @Author 邓嘉豪
 * @Date 2020-03-27
 */


@RestController
@RequestMapping("/driver")
public class DriverController {
    private static final Logger logger = LoggerFactory.getLogger(DriverController.class);

    @Resource
    private DriverService driverService;

    /**
     * driver 新增司机
     *
     * @param DriverInfo
     * @return AppResponse
     * @author 邓嘉豪
     * @Date 2020-03-27
     */
    @PostMapping("addDriver")
    public AppResponse saveDriver(DriverInfo DriverInfo) {
        try {
            //获取司机id
            String driverId = AuthUtils.getCurrentUserId();

            DriverInfo driverInfoVC = new DriverInfo();
            driverInfoVC.setcreatePerson(driverId);
            AppResponse appResponse = driverService.saveDriver(DriverInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("司机新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * driver 司机列表(分页)
     *
     * @param driverInfo
     * @return AppResponse
     * @author 邓嘉豪
     * @Date 2020-03-30
     */
    @RequestMapping(value = "listDriver")
    public AppResponse listDriver(DriverInfo driverInfo) {
        try {
            return driverService.listDriver(driverInfo);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }



    /**
     * driver查询司机详情
     *
     * @param driverNo
     * @return AppResponse
     * @author 邓嘉豪
     * @Date 2020-03-30
     */
    @RequestMapping(value = "getDriverBydriverNo")
    public AppResponse getDriverBydriverNo(String driverNo) {
        try {
            return driverService.getDriverBydriverNo(driverNo);
        } catch (Exception e) {
            logger.error("用户查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * demo 修改司机
     *
     * @param driverInfo
     * @return AppResponse
     * @author 邓嘉豪
     * @Date 2020-03-30
     */
    @PostMapping("updateDriver")
    public AppResponse updateDriver(DriverInfo driverInfo) {
        try {
            //获取司机id
            String driverId = AuthUtils.getCurrentUserId();
            driverInfo.setcreatePerson(driverId);
            driverInfo.setupdatePerson(driverId);
            return driverService.updateDriver(driverInfo);
        } catch (Exception e) {
            logger.error("修改用户信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除司机
     * @return AppResponse
     * @author 邓嘉豪
     * @Date 2020-03-26
     */

    @PostMapping("deleteDriver")
    public AppResponse deleteDriver(DriverSettingDTO driverSettingDTO) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            driverSettingDTO.setLastModifiedBy(userId);
            return driverService.deleteDriver(driverSettingDTO);
        } catch (Exception e) {
            logger.error("用户删除错误", e);
            throw new ScServerException("用户删除错误");
        }
    }


}
