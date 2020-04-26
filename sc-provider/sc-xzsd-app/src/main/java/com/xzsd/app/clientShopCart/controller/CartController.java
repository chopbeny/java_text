package com.xzsd.app.clientShopCart.controller;

import com.xzsd.app.clientShopCart.entity.CartInfo;
import com.xzsd.app.clientShopCart.service.CartService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 购物车信息控制器
 *
 * @author 邓嘉豪
 * @date 2020-03-29
 */
@RestController
@RequestMapping("/clientShopCart")
public class CartController {
    private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    @Autowired
    private CartService cartService;

    /**
     * 新增购物车信息接口
     *邓嘉豪
     * @param cartInfo 门店信息
     * @return
     */

    @PostMapping("/addShoppingCart")
    public AppResponse addStore(CartInfo cartInfo) {
        try {
            return cartService.addCart(cartInfo);
        } catch (Exception e) {
            logger.error("新增门店信息异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }


    /**
     * 查询购物车列表接口
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param cartInfo    查询商品信息条件
     * @return
     */
    @PostMapping("/listShoppingCarts")
    public AppResponse listShoppingCarts(CartInfo cartInfo) {
        try {
            return cartService.listShoppingCarts(cartInfo);
        } catch (Exception e) {
            logger.error("查询商品信息列表异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }


    /**
     * 修改购物车信息接口
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param cartInfo   要修改的商品信息
     * @return
     */
    @PostMapping("/updateGoodsById")
    public AppResponse updateGoodsById(CartInfo cartInfo) {
        try {
            return cartService.updateShoppingCartsById(cartInfo);
        } catch (Exception e) {
            logger.error("修改商品信息异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }



    /**
     * 删除购物车接口
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param shopCartId 购物车编号（批量删除用逗号分开）
     * @return
     */
    @PostMapping("/deleteShoppingCart")
    public AppResponse deleteShoppingCart(String shopCartId) {
        try {
            return cartService.deleteShoppingCart(shopCartId);
        } catch (Exception e) {
            logger.error("删除商品信息异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }




}
