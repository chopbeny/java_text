package com.xzsd.app.goods.controller;

import com.neusoft.core.exception.ScServerException;
import com.xzsd.app.goods.entity.GoodsInfo;
import com.xzsd.app.goods.service.GoodsService;
import com.xzsd.app.util.AppResponse;
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
@RequestMapping("/clientGoods")
public class GoodsController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Autowired
    private GoodsService goodsService;



    /**
     * 查询商品详情接口
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param goodsId    查询商品信息条件
     * @return
     */
    @PostMapping("/getGoods")
    public AppResponse getUserByUserCode(String goodsId, GoodsInfo goodsInfo) {
        try {
            goodsInfo = goodsService.getGoods(goodsId,goodsInfo);
        } catch (Exception e) {
            logger.error("用户查询错误", e);
            throw new ScServerException("查询错误，请重试");
        }
        if (goodsInfo == null) {
            return AppResponse.notFound("无查询结果");
        }

        return AppResponse.success("查询成功", goodsInfo);
    }



    /**
     * 查询商品评价列表接口
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param goodsInfo    查询商品信息条件
     * @return
     */
    @PostMapping("/listGoodsEvaluates")
    public AppResponse listAllGoods(GoodsInfo goodsInfo) {
        try {
            return goodsService.listAllGoods(goodsInfo);
        } catch (Exception e) {
            logger.error("查询商品信息列表异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }



    /**
     * 查询一级商品分类列表接口
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param goodsInfo 查询商品信息条件
     * @return
     */
    @PostMapping("/listOneGoodsClassify")
    public AppResponse listOneGoodsClassify(GoodsInfo goodsInfo) {
        try {
            return goodsService.listOneGoodsClassify(goodsInfo);
        } catch (Exception e) {
            logger.error("查询商品信息列表异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }


    /**
     * 查询二级商品分类以及商品接口
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param classifyId 查询商品信息条件
     * @return
     */
    @PostMapping("/listGetClassGoods")
    public AppResponse listGetClassGoods(GoodsInfo goodsInfo,String classifyId) {
        try {
            return goodsService.listGetClassGoods(goodsInfo,classifyId);
        } catch (Exception e) {
            logger.error("查询商品信息列表异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }





}
