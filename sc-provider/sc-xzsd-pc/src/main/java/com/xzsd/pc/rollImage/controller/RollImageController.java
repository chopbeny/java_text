package com.xzsd.pc.rollImage.controller;

import com.xzsd.pc.goodsCate.controller.GoodsCateController;
import com.xzsd.pc.rollImage.entity.RollImageInfo;
import com.xzsd.pc.rollImage.service.RollImageService;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.AuthUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 轮播图模块
 * @author 邓嘉豪
 * @Date 2020/4/3
 */
@ResponseBody
@RestController
@RequestMapping("/rollImage")

public class RollImageController {
    private static final Logger logger = LoggerFactory.getLogger(GoodsCateController.class);
    @Resource
    private RollImageService rollImageService;

    /**
     * rollImage 轮播图新增
     *
     * @param rollImageInfo
     * @return AppResponse
     * @author 邓嘉豪
     * @Date 2020-03-30
     **/

    @PostMapping("addRollImage")
    public AppResponse addRollImage(RollImageInfo rollImageInfo){
        try{
            AppResponse appResponse = rollImageService.addRollImage(rollImageInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("新增轮播图失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * rollImage 获取轮播图列表
     * @param rollImageInfo
     * @return AppResponse
     * @author 邓嘉豪
     * @Date 2020-04-04
     */

    @RequestMapping("listRollImagesByPage")
    public AppResponse listRollImagesByPage(RollImageInfo rollImageInfo){
        try{
            return rollImageService.listRollImagesByPage(rollImageInfo);
        }catch (Exception e){
            logger.error("查询轮播图列表异常");
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * rollImage 修改轮播图状态
     * @param rollImageInfo
     * @APpResponse
     * @author 邓嘉豪
     * @Date 2020-04-04
     */
    @PostMapping("updateRollImageConditionById")
    public AppResponse updateRollImageConditionById(RollImageInfo rollImageInfo) {
        try {
            return rollImageService.updateRollImageConditionById(rollImageInfo);

        } catch (Exception e) {
            logger.error("修改商品分类详情异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }



    /**
     * rollImage 删除轮播图
     * @param rollImageId
     * @APpResponse
     * @author 邓嘉豪
     * @Date 2020-04-04
     */
    @PostMapping("deleteRollImageById")
    public AppResponse deleteRollImageById(String rollImageId){
        try {
            //获取商品id
            String cateid = AuthUtils.getCurrentGoodsId();
            return rollImageService.deleteGoodsCateById(rollImageId, cateid);
        } catch (Exception e) {
            logger.error("商品分类删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }




}
