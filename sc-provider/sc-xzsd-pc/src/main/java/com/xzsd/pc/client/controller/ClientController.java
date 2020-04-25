package com.xzsd.pc.client.controller;

import com.xzsd.pc.client.service.ClientService;
import com.xzsd.pc.user.entity.User;
import com.xzsd.pc.client.service.ClientService;
import com.xzsd.pc.util.AppResponse;
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
@RequestMapping("/client")
public class ClientController {

    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientService clientService;

    /**
     * 分角色查询客户列表接口（分页）
     * - 管理员查询所有客户信息列表
     * - 店长查询门店所有客户信息列表

     * @param user     客户信息查询条件
     * @return
     */
    @PostMapping("/listClients")
    public AppResponse listClients(User user) {
        try {
            return clientService.listClients(user);
        } catch (Exception e) {
            logger.error("查询客户信息异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }

}




















