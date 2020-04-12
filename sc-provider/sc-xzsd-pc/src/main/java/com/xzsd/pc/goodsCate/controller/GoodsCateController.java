package com.xzsd.pc.goodsCate.controller;

import com.xzsd.pc.goodsCate.entity.GoodsCateInfo;
import com.xzsd.pc.goodsCate.service.GoodsCateService;
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
 * 商品分类模块
 * @author 邓嘉豪
 * @Date 2020/4/3
 */
@ResponseBody
@RestController
@RequestMapping("/goodsCate")
public class GoodsCateController {
    private static final Logger logger = LoggerFactory.getLogger(GoodsCateController.class);
    @Resource
    private GoodsCateService goodsCateService;

    /**
     * goodsCate 新增分类商品
     *
     * @param goodsCateInfo
     * @return AppResponse
     * @author 邓嘉豪
     * @Date 2020-03-30
     **/

    @PostMapping("addGoodsCate")
    public AppResponse addGoodsCate(GoodsCateInfo goodsCateInfo){
        try{
            AppResponse appResponse = goodsCateService.addGoodsCate(goodsCateInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("商品分类新增失败", e);
            System.out.println(e.toString());
            throw e;

        }

    }


    /**
     * goodsCate 商品分类列表接口
     * @param goodsCateInfo
     * @return AppResponse
     * @author 邓嘉豪
     * @Date 2020-04-04
     */

    @RequestMapping("listGoodsCate")
    public AppResponse listGoodsCate(GoodsCateInfo goodsCateInfo){
        try{
            return goodsCateService.listGoodsCate(goodsCateInfo);
        }catch (Exception e){
            logger.error("查询商品分类列表异常");
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 查询商品详情接口
     * @param cateId
     * @APpResponse
     * @author 邓嘉豪
     * @Date 2020-04-04
     */
    @RequestMapping(value = "findGoodsCateById")
    public AppResponse findGoodsCateBId(String cateId){
        try{
            return goodsCateService.findGoodsCateById(cateId);
        }catch (Exception e){
            logger.error("查询商品分类详情异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 修改商品分类详情接口
     * @param goodsCateInfo
     * @APpResponse
     * @author 邓嘉豪
     * @Date 2020-04-04
     */
    @PostMapping("updateGoodsCateById")
    public AppResponse updateGoodsCateById(GoodsCateInfo goodsCateInfo) {
        try {
            return goodsCateService.updateGoodsCateById(goodsCateInfo);

        } catch (Exception e) {
            logger.error("修改商品分类详情异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除商品详情接口
     * @param cateId
     * @APpResponse
     * @author 邓嘉豪
     * @Date 2020-04-04
     */
    @PostMapping("deleteGoodsCateById")
    public AppResponse deleteGoodsCateById(String cateId){
        try {
            //获取商品id
            String cateid = AuthUtils.getCurrentGoodsId();
            return goodsCateService.deleteGoodsCateById(cateId, cateid);
        } catch (Exception e) {
            logger.error("商品分类删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }



}
