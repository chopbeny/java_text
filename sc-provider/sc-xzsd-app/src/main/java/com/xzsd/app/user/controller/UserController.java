package com.xzsd.app.user.controller;


import com.xzsd.app.user.entity.User;
import com.xzsd.app.user.service.UserService;
import com.xzsd.app.util.AppResponse;
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
@RequestMapping("/register")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    /**
     * 新增用户接口（注册）
     * @param user 用户信息
     * @param imageId 上传的头像图片编号
     * @作者 邓嘉豪
     * @时间 2020-03-27
     * @return
     */
    @PostMapping("/clientRegister")
    public AppResponse addUser(User user, String imageId) {
        try {
            return userService.addUser(user, imageId);
        } catch (Exception e) {
            logger.error("新增用户异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }






}




















