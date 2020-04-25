package com.xzsd.pc.rollimage.controller;

import com.xzsd.pc.goods.entity.Goods;
import com.xzsd.pc.rollimage.entity.RollImage;
import com.xzsd.pc.rollimage.service.RollImageService;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.DateFormatUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * 轮播图控制器
 *
 * @author 邓嘉豪
 * @date 2020-04-14
 */
@RestController
@RequestMapping("/rollImage")
public class RollImageController {

    private static final Logger logger = LoggerFactory.getLogger(RollImageController.class);

    @Autowired
    private RollImageService rollImageService;

    /**
     * 新增轮播图接口
     * @param rollImage 轮播图信息
     * @param imageId 轮播图图片编号
     * @param rollImageBeginDateStr 轮播图开始时间
     * @param rollImageEndDateStr 轮播图结束时间
     * @return
     */
    @PostMapping("/addRollImage")
    public AppResponse addRollImage(RollImage rollImage, String imageId,
                                    String rollImageBeginDateStr, String rollImageEndDateStr){
        try {
            return rollImageService.addRollImage(rollImage, imageId, rollImageBeginDateStr, rollImageEndDateStr);
        } catch (Exception e) {
            logger.error("新增轮播图异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }

    /**
     * 查询轮播图列表接口
     * @param rollImageCondition 轮播图状态
     * @return
     */
    @PostMapping("/listRollImages")
    public AppResponse listRollImages(RollImage rollImage, String rollImageCondition){
        try {
            return rollImageService.listRollImages(rollImage,rollImageCondition);
        } catch (Exception e) {
            logger.error("查询轮播图列表异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }

    /**
     * 修改轮播图状态接口
     * @param rollImageIds 轮播图编号列表
     * @param rollImageCondition 轮播图状态
     * @return
     */
    @PostMapping("/updateRollImageConditionById")
    public AppResponse updateRollImageConditionById(String rollImageIds, int rollImageCondition){
        try {
            return rollImageService.updateRollImageConditionById(rollImageIds, rollImageCondition);
        } catch (Exception e) {
            logger.error("修改轮播图状态异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }

    /**
     * 删除轮播图接口
     * @param rollImageIds 轮播图编号列表（批量删除用逗号分开）
     * @return
     */
    @PostMapping("/deleteRollImageById")
    public AppResponse deleteRollImageById(String rollImageIds){
        try {
            return rollImageService.deleteRollImageById(rollImageIds);
        } catch (Exception e) {
            logger.error("删除轮播图列表异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }

    /**
     * 查询商品列表接口（商品管理模块查询商品列表的接口）
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param goods    查询商品信息条件
     * @return
     */

    @PostMapping("/listGoods")
    public AppResponse listAllGoods(Goods goods) {
        try {
            return rollImageService.listAllGoods(goods);
        } catch (Exception e) {
            logger.error("查询商品信息列表异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }








}


















