
package com.xzsd.pc.goods.controller;

import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.goods.service.GoodsService;
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
 * 商品管理
 * @author 邓嘉豪
 * @time 2020-03-30
*/
@ResponseBody //是将java对象转为json格式的数据。将方法的返回值，以特定的格式写入到response的body区域，进而将数据返回给客户端。
@RestController
@RequestMapping("/goods")
public class GoodsController {
    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);
    @Resource
    private GoodsService goodsService;
    private GoodsInfo goodsInfo;


/**
     * goods 新增商品
     *
     * @param goodsInfo
     * @return AppResponse
     * @author 邓嘉豪
     * @Date 2020-03-30
**/
    @PostMapping("addGoods")
    public AppResponse addGoods(GoodsInfo goodsInfo) {
        try {
            //获取商品id
            String goodsId = AuthUtils.getCurrentUserId();
            goodsInfo.setcreatePerson(goodsId);
            AppResponse appResponse = goodsService.addGoods(goodsInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("商品新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

/**
     * goods 商品列表(分页)
     *
     * @param goodsInfo
     * @return AppResponse
     * @author 邓嘉豪
     * @Date 2020-03-26
*/
    @RequestMapping(value = "listGoods")
    public AppResponse listGoods(GoodsInfo goodsInfo) {
        try {
            return goodsService.listGoods(goodsInfo);
        } catch (Exception e) {
            logger.error("查询商品列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * goods 修改商品信息
     *
     * @param goodsInfo
     * @return AppResponse
     * @author 邓嘉豪
     * @Date 2020-03-26
     */
    @PostMapping("updateGoodsById")
    public AppResponse updateUser(GoodsInfo goodsInfo) {
        try {
            //获取商品id
            String goodsId = AuthUtils.getCurrentGoodsId();
            goodsInfo.setcreatePerson(goodsId);
            goodsInfo.setupdatePerson(goodsId);
            return goodsService.updateGoods(goodsInfo);
        } catch (Exception e) {
            logger.error("修改商品信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * goods 删除商品接口
     *
     * @param goodsId
     * @return AppResponse
     * @author 邓嘉豪
     * @Date 2020-03-26
     */
    @PostMapping("deleteGoodsById")
    public AppResponse deleteGoods(String goodsId) {
        try {
            //获取商品id
            String goodsid = AuthUtils.getCurrentGoodsId();
            return goodsService.deleteGoods(goodsId, goodsid);
        } catch (Exception e) {
            logger.error("商品删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 修改商品状态
     * @param goodsInfo
     * @return
     */
    @PostMapping("updateGoodsConditionById")
    public AppResponse updateGoodsCondition(GoodsInfo goodsInfo) {
        try {
            //获取商品id
            goodsInfo.setgoodsCode(AuthUtils.getCurrentGoodsId());
            return goodsService.updateGoodsCondition(goodsInfo);
        } catch (Exception e) {
            logger.error("修改商品状态错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }










}
