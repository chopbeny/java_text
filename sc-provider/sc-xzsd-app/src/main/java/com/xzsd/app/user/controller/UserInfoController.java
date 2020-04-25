package com.xzsd.app.user.controller;

import com.neusoft.core.exception.ScServerException;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.user.entity.UserInfomation;
import com.xzsd.app.user.service.UserInfoService;
import com.xzsd.app.util.AppResponse;
import com.xzsd.app.util.AuthUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户管理控制器
 *
 * @author 邓嘉豪
 * @date 2020-04-12
 */
@RestController
@RequestMapping("/userInformation")
public class UserInfoController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserInfoService userInfoService;


    /**
     * 查询用户信息
     * @作者 邓嘉豪
     * @时间 2020-03-27
     * @return 用户信息
     */
    @RequestMapping(value = "getUser")
    public AppResponse getUserById() {
        String userId = AuthUtils.getCurrentUserId();
        UserInfomation userInfo = null;
        try {
            userInfo = userInfoService.getUserById(userId);
        } catch (Exception e) {
            logger.error("用户查询错误", e);
            throw new ScServerException("查询错误，请重试");
        }
        if (userInfo == null) {
            return AppResponse.notFound("无查询结果");
        }

        return AppResponse.success("查询成功", userInfo);
    }

    /**
     * 功能：修改密码
     * 描述：略
     * 作成者：邓嘉豪
     * 作成时间：2020/4/11
     */

    @PostMapping("updateUserPassword")
    public AppResponse updatePwd(UserInfomation userInfo) {
        try {
            return userInfoService.updatePwd(userInfo);
        } catch (Exception e) {
            logger.error("修改异常", e);
            throw new ScServerException("修改密码失败，请重试");
        }
    }



    /**
     * 修改店铺邀请码（客户）
     * 邓嘉豪
     * 2020-04-15 20:27
     */
    @PostMapping(value = "updateClientInvite")
    public AppResponse updateStoreInviteById(UserInfomation userInfomation) {
        try {
            return userInfoService.updateStoreInviteById(userInfomation);
        } catch (Exception e) {
            logger.error("修改店铺邀请码异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }




}
