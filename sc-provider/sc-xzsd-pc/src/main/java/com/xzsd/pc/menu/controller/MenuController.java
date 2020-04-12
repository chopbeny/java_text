package com.xzsd.pc.menu.controller;

import com.neusoft.core.exception.ScServerException;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.menu.entity.Menu;
import com.xzsd.pc.menu.service.MenuService;
import com.xzsd.pc.util.AuthUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


/**
 * @Description增删改查菜单
 * @Author 邓嘉豪
 * @Date 2020-03-26
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Resource
    private MenuService menuService;

    /**
     * 新增菜单
     *
     * @param menu
     * @return AppResponse
     * @author 邓嘉豪
     * @Date 2020-03-26
     */
    @PostMapping("addMenu")
    public AppResponse addMenu(Menu menu) {
        try {
            //获取菜单id
            String menuId = AuthUtils.getCurrentUserId();
            menu.setcreatePerson(menuId);
            AppResponse appResponse = menuService.addMenu(menu);
            return appResponse;
        } catch (Exception e) {
            logger.error("菜单新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     *菜单列表
     *
     * @param menu
     * @return AppResponse
     * @author 邓嘉豪
     * @Date 2020-03-26
     */
    @RequestMapping(value = "listMenu")
    public AppResponse listMenu(Menu menu) {
        try {
            return menuService.listMenu(menu);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除菜单
     *
     * @param menuId
     * @return AppResponse
     * @author 邓嘉豪
     * @Date 2020-03-26
     */
    @PostMapping("deleteMenu")
    public AppResponse deleteMenu(String menuId) {
        try {
            //获取菜单id
            String userid = AuthUtils.getCurrentUserId();
            return menuService.deleteMenu(menuId, userid);
        } catch (Exception e) {
            logger.error("菜单删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改菜单
     *
     * @param menu
     * @return AppResponse
     * @author 邓嘉豪
     * @Date 2020-03-26
     */
    @PostMapping("updateMenu")
    public AppResponse updateMenu(Menu menu) {
        try {
            //获取菜单id
            String userId = AuthUtils.getCurrentUserId();
            menu.setcreatePerson(userId);
            menu.setupdatePerson(userId);
            return menuService.updateMenu(menu);
        } catch (Exception e) {
            logger.error("修改菜单信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询菜单详情
     *
     * @param menuId
     * @return AppResponse
     * @author 邓嘉豪
     * @Date 2020-03-26
     */
    @RequestMapping(value = "getMenu")
    public AppResponse getMenu(String menuId) {
        try {
            return menuService.getMenu(menuId);
        } catch (Exception e) {
            logger.error("菜单查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 查询首页菜单列表接口
     * @param
     * @author 邓嘉豪
     * @Date 2020-4-12
     */

    @RequestMapping(value = "listMenuHome")
    public String getlistMenuHome() {
        String userId = AuthUtils.getCurrentUserId();
        try {
            return menuService.getlistMenuHome(userId);
        } catch (Exception e) {
            logger.error("菜单查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }













}














