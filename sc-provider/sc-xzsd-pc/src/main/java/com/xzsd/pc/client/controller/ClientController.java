package com.xzsd.pc.client.controller;


import com.neusoft.core.exception.ScServerException;
import com.xzsd.pc.client.entity.ClientInfo;
import com.xzsd.pc.client.service.ClientService;
import com.xzsd.pc.user.controller.UserController;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/client")
@Validated


public class ClientController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private ClientService clientService;

    /**
     * 功能：获取客户列表
     * 描述：略
     * 作成者：邓嘉豪
     * 作成时间：2020/4/11
     */
    @RequestMapping(value = "listClients")
    public AppResponse listClient(ClientInfo clientInfo) {
        try {
            return clientService.listClient(clientInfo);
        } catch (Exception e) {
            logger.error("用户获取异常", e);
            throw new ScServerException("查询错误，请重试");
        }
    }


}
