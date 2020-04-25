package com.xzsd.app.goods.dao;

import com.google.gson.internal.$Gson$Preconditions;
import com.xzsd.app.goods.entity.GoodsCate;
import com.xzsd.app.goods.entity.GoodsInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品数据库接口类
 *
 * @author 邓嘉豪
 * @date 2020-04-13
 */
@Mapper
public interface GoodsDao {


    /**
     * 根据id查询商品信息
     * @author 邓嘉豪
     * @date 2020-04-10
     * @param goodsId 用户id
     * @return
     */
    GoodsInfo selectByPrimaryKey(@Param("goodsId") String goodsId ,@Param("invite") String invite, GoodsInfo goodsInfo);



    /**
     * 根据查询条件查询商品信息列表
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param goodsInfo 商品信息查询条件
     * @return
     */
    List<GoodsInfo> listAllGoods(GoodsInfo goodsInfo);



    /**
     * 查询一级商品分类列表接口
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param goodsInfo 商品信息查询条件
     * @return
     */
    List<GoodsInfo> listOneGoodsClassify(GoodsInfo goodsInfo);


    /**
     * 查询二级商品分类以及商品接口
     *
     * @return
     */
    List<GoodsCate> listGetClassGoods(GoodsInfo goodsInfo);


    /**
     * 根据id查询商品信息
     * @author 邓嘉豪
     * @date 2020-04-10
     * @param goodsId 用户id
     * @return
     */
    GoodsInfo getGoodsById(@Param("goodsId") String goodsId);


    /**
     * 根据isbn编号查询数据库是否已存在相同商品
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param goodsIsbn 商品的isbn编号
     * @return
     */
    int countGoodsByIsbn(String goodsIsbn);



    /**
     * 查询多个商品信息
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param listGoodsIds        要查询的商品信息列表
     * @return
     */
    int findGoodsByList(@Param("listGoodsIds") List<String> listGoodsIds);






}
