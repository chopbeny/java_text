package com.xzsd.app.clientShopCart.dao;

import com.xzsd.app.clientShopCart.entity.CartInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 购物车数据库接口类
 *
 * @author 邓嘉豪
 * @date 2020-03-30
 */
@Mapper
public interface CartDao {


    /**
     * 新增商品购物车信息
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param cartInfo 商品信息
     * @return
     */
    int insertSelective(CartInfo cartInfo);

    /**
     * 统计购物车中是否有该商品
     * @param goodsId
     * @return
     */
    int countCartGoodsById(String goodsId);


    /**
     * 根据查询条件查询商品信息列表
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param cartInfo 商品信息查询条件
     * @return
     */
    List<CartInfo> listShoppingCarts(CartInfo cartInfo);



    /**
     * 统计输入的购物车编号是否存在
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param shopCartId 购物车信息查询条件
     * @return
     */

    int countCartShoppingById(String shopCartId);


    /**
     * 根据id修改商品信息
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param cartInfo 商品信息
     * @return
     */
    int updateCartById(CartInfo cartInfo);



    /**
     * 根据id查询购物车信息
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param shopCartId 购物车信息
     * @return
     */
    CartInfo findCartById(String shopCartId);


    /**
     * 删除购物车接口
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param listIds   要删除的购物车信息列表
     * @return
     */
    int deleteShoppingCart(@Param("listIds") List<String> listIds, @Param("updatePersonId") String updatePersonId);










}
