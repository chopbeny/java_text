package com.xzsd.pc.store.controller;
import com.neusoft.core.exception.ScServerException;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.store.entity.StoreSettingDTO;
import com.xzsd.pc.store.service.StoreService;
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
 * @ClassName StoreController
 * @Description 门店管理
 * @Author 邓嘉豪
 * @Date 2020/4/11
 */
@RestController
@RequestMapping("/store")
@Validated


public class StoreController {
    private static final Logger logger = LoggerFactory.getLogger(StoreController.class);

    @Resource
    private StoreService storeService;

    /**
     * 功能：新增门店
     * 描述：略
     * 作成者：邓嘉豪
     * 作成时间：2020/4/11
     */

    @PostMapping("addStore")
    public AppResponse addStore(@Valid StoreInfo storeInfo) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            storeInfo.setcreatePerson(userId);
            AppResponse appResponse = storeService.addStore(storeInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("用户注册失败", e);
            throw new ScServerException(e);
        }
    }


    /**
     * 功能：获取门店列表
     * 描述：略
     * 作成者：邓嘉豪
     * 作成时间：2020/4/11
     */

    @RequestMapping(value = "listStores")
    public AppResponse listStores(StoreInfo storeInfo) {
        try {
            return storeService.listStores(storeInfo);
        } catch (Exception e) {
            logger.error("用户获取异常", e);
            throw new ScServerException("查询错误，请重试");
        }
    }

    /*
     * 删除门店
     * @param storeId
     * @return AppResponse
     * @author 邓嘉豪
     * @Date 2020-03-26

     */

    @PostMapping("deleteStore")
    public AppResponse deleteStore(StoreSettingDTO storeSettingDTO) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            storeSettingDTO.setLastModifiedBy(userId);
            return storeService.deleteStore(storeSettingDTO);
        } catch (Exception e) {
            logger.error("用户删除错误", e);
            throw new ScServerException("用户删除错误");
        }
    }






    /**
     * 根据门店代码获取用户信息
     *作者：邓嘉豪
     * @param storeId 用户代码
     * @return 用户信息
     */
    @RequestMapping(value = "getStore")
    public AppResponse getStore(/*@NotNull(message = "用户代码不能为空")*/String storeId) {

        StoreInfo storeInfo = null;
        try {
            storeInfo = storeService.getStore(storeId);
        } catch (Exception e) {
            logger.error("用户查询错误", e);
            throw new ScServerException("查询错误，请重试");
        }
        if (storeInfo == null) {
            return AppResponse.notFound("无查询结果");
        }

        return AppResponse.success("查询成功", storeInfo);
    }


    /**
     * 功能：修改门店信息
     * 描述：略
     * 作成者：邓嘉豪
     * 作成时间：2020/4/11
     */
    @PostMapping("updateStore")
    public AppResponse updateStore(@Valid StoreInfo storeInfo) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            storeInfo.setcreatePerson(userId);
            storeInfo.setupdatePerson(userId);
            return storeService.updateStore(storeInfo);
        } catch (Exception e) {
            logger.error("修改用户信息错误", e);
            throw new ScServerException("系统错误，请重试");
        }
    }








}
