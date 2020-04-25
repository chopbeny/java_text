package com.xzsd.pc.user.controller;

import com.neusoft.core.exception.ScServerException;
import com.xzsd.pc.user.entity.User;
import com.xzsd.pc.user.service.UserService;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户管理控制器
 *
 * @author 邓嘉豪
 * @date 2020-03-27
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    /**
     * 顶部栏接口
     *
     * @return
     */
    @PostMapping("/topInfo")
    public AppResponse topInfo() {
        try {
            return userService.topInfo();
        } catch (Exception e) {
            logger.error("查询顶部栏信息异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }




    /**
     * 新增用户接口
     * @param user 用户信息
     * @param imageId 上传的头像图片编号
     * @作者 邓嘉豪
     * @时间 2020-03-27
     * @return
     */
    @PostMapping("/addUser")
    public AppResponse addUser(User user, String imageId) {
        try {
            return userService.addUser(user, imageId);
        } catch (Exception e) {
            logger.error("新增用户异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }

    /**
     * 根据用户账号查询用户接口
     * @作者 邓嘉豪
     * @时间 2020-03-27
     * @param userLoginName 用户账号
     * @return
     */
    /*
    @PostMapping("/getUser")
    public AppResponse countUserByUserLoginName(String userLoginName) {
        try {
            return userService.countUserByUserLoginName(userLoginName);
        } catch (Exception e) {
            logger.error("根据账号查询用户异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }

     */

    /**
     * 根据用户信息条件查询用户信息（管理员、店长、司机）
     * @作者 邓嘉豪
     * @时间 2020-03-27
     * @param user 查询的用户信息条件
     * @return
     */
    @PostMapping("/listUsers")
    public AppResponse listUsers(User user) {
        try {
            return userService.listUsers(user);
        } catch (Exception e) {
            logger.error("查询用户信息列表异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }

    /**
     * 修改用户信息接口
     * @param user 要修改的用户信息
     * @作者 邓嘉豪
     * @时间 2020-03-27
     * @return
     */
    @PostMapping("/updateUser")
    public AppResponse updateUserById(User user, String imageId) {
        try {
            return userService.updateUserById(user, imageId);
        } catch (Exception e) {
            logger.error("修改用户信息异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }

    /**
     * 删除用户接口
     * @param userId 要删除的id（批量删除用逗号分开）
     * @作者 邓嘉豪
     * @时间 2020-03-27
     * @return
     */
    @PostMapping("/deleteUser")
    public AppResponse deleteUserById(String userId) {
        try {
            return userService.deleteUserById(userId);
        } catch (Exception e) {
            logger.error("删除用户信息异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }


    /**
     * 根据用户代码获取用户信息
     * @作者 邓嘉豪
     * @时间 2020-03-27
     * @param userId 用户代码
     * @return 用户信息
     */
    @RequestMapping(value = "getUser")
    public AppResponse getUserByUserCode(String userId) {

        User userInfo = null;
        try {
            userInfo = userService.getUserById(userId);
        } catch (Exception e) {
            logger.error("用户查询错误", e);
            throw new ScServerException("查询错误，请重试");
        }
        if (userInfo == null) {
            return AppResponse.notFound("无查询结果");
        }

        return AppResponse.success("查询成功", userInfo);
    }

}





















