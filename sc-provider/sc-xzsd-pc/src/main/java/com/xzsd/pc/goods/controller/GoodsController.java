package com.xzsd.pc.goods.controller;

import com.neusoft.core.exception.ScServerException;
import com.xzsd.pc.goods.entity.Goods;
import com.xzsd.pc.goods.service.GoodsService;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品信息控制器
 *
 * @author 邓嘉豪
 * @date 2020-04-13
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Autowired
    private GoodsService goodsService;






    /**
     * 新增商品接口
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param goods   商品信息
     * @param imageId 商品图片编号
     * @return
     */
    @PostMapping("/addGoods")
    public AppResponse addGoods(Goods goods, String imageId) {
        try {
            return goodsService.addGoods(goods, imageId);
        } catch (Exception e) {
            logger.error("新增商品信息异常", e);
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
    @PostMapping("/listAllGoods")
    public AppResponse listAllGoods(Goods goods) {
        try {
            return goodsService.listAllGoods(goods);
        } catch (Exception e) {
            logger.error("查询商品信息列表异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }

    /**
     * 修改商品信息接口
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param goods   要修改的商品信息
     * @param imageId 要修改的商品图片编号
     * @return
     */
    @PostMapping("/updateGoodsById")
    public AppResponse updateGoodsById(Goods goods, String imageId) {
        try {
            return goodsService.updateGoodsById(goods, imageId);
        } catch (Exception e) {
            logger.error("修改商品信息异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }

    /**
     * 修改商品状态接口
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param goodsIds 要修改的商品编号（批量修改用逗号分开）
     * @param goodsCondition 要修改的商品状态
     * @return
     */
    @PostMapping("/updateGoodsConditionById")
    public AppResponse updateGoodsConditionById(String goodsIds, int goodsCondition) {
        try {
            return goodsService.updateGoodsConditionById(goodsIds, goodsCondition);
        } catch (Exception e) {
            logger.error("修改商品状态异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }

    /**
     * 删除商品接口
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param goodsIds 商品编号（批量删除用逗号分开）
     * @return
     */
    @PostMapping("/deleteGoodsById")
    public AppResponse deleteGoodsById(String goodsIds) {
        try {
            return goodsService.deleteGoodsById(goodsIds);
        } catch (Exception e) {
            logger.error("删除商品信息异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }




    /**
     * 查询商品详情接口
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param goodsId    查询商品信息条件
     * @return
     */
    @PostMapping("/getGoods")
    public AppResponse getUserByUserCode(String goodsId,Goods goods) {
        try {
            goods = goodsService.getGoods(goodsId,goods);
        } catch (Exception e) {
            logger.error("用户查询错误", e);
            throw new ScServerException("查询错误，请重试");
        }
        if (goods == null) {
            return AppResponse.notFound("无查询结果");
        }

        return AppResponse.success("查询成功", goods);
    }








}


















