package com.xzsd.pc.hotgoods.controller;

import com.xzsd.pc.dict.entity.Dict;
import com.xzsd.pc.goods.entity.Goods;
import com.xzsd.pc.hotgoods.entity.HotGoods;
import com.xzsd.pc.hotgoods.service.HotGoodsService;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 热门位商品控制器
 *
 * @author 邓嘉豪
 * @date 2020-04-16
 */
@RestController
@RequestMapping("/hotGoods")
public class HotGoodsController {

    private static final Logger logger = LoggerFactory.getLogger(HotGoodsController.class);

    @Autowired
    private HotGoodsService hotGoodsService;

    /**
     * 新增热门位商品接口
     *
     * @param hotGoods 热门位商品信息
     * @return
     */
    @PostMapping("/addHotGoods")
    public AppResponse addHotGoods(HotGoods hotGoods) {
        try {
            return hotGoodsService.addHotGoods(hotGoods);
        } catch (Exception e) {
            logger.error("新增热门位商品信息异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }

    /**
     * 查询热门位商品列表接口
     *
     * @param goods    要查询的商品信息
     * @return
     */
    @PostMapping("/listHotGoods")
    public AppResponse listHotGoods(HotGoods hotGoods, Goods goods) {
        try {
            return hotGoodsService.listHotGoods(hotGoods, goods);
        } catch (Exception e) {
            logger.error("查询热门位商品信息列表异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }

    /**
     * 修改热门位商品接口
     *
     * @param hotGoods 要修改的热门商品信息
     * @return
     */
    @PostMapping("/updateHotGoodsById")
    public AppResponse updateHotGoodsById(HotGoods hotGoods) {
        try {
            return hotGoodsService.updateHotGoodsById(hotGoods);
        } catch (Exception e) {
            logger.error("修改热门位商品信息异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }

    /**
     * 删除热门位商品接口
     *
     * @param hotGoodsIds 热门位商品编号（批量删除用逗号分开）
     * @return
     */
    @PostMapping("/deleteHotGoodsById")
    public AppResponse deleteHotGoodsById(String hotGoodsIds) {
        try {
            return hotGoodsService.deleteHotGoodsById(hotGoodsIds);
        } catch (Exception e) {
            logger.error("删除热门位商品信息异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }

    /**
     * 查询热门位商品展示数量接口
     *
     * @return
     */
    @PostMapping("/findDisplayNum")
    public AppResponse findDisplayNum() {
        try {
            return hotGoodsService.findDisplayNum();
        } catch (Exception e) {
            logger.error("查询热门位商品展示数量异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }

    /**
     * 修改热门位商品展示数量接口
     *
     * @param dict 要修改的字典信息
     * @return
     */
    @PostMapping("/updateDisplayNum")
    public AppResponse updateDisplayNum(Dict dict) {
        try {
            return hotGoodsService.updateDisplayNum(dict);
        } catch (Exception e) {
            logger.error("修改热门位商品展示数量异常", e);
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
            return hotGoodsService.listAllGoods(goods);
        } catch (Exception e) {
            logger.error("查询商品信息列表异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }






}


















