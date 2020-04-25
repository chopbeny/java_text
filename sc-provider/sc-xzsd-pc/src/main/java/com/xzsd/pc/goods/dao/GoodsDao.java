package com.xzsd.pc.goods.dao;


import com.xzsd.pc.goods.entity.Goods;
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
     * 根据商品分类编号查询商品数量
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param goodsCateCode 商品分类编号
     * @return
     */
    int countGoodsByGoodsCateCode(@Param("goodsCateCode") String goodsCateCode);

    /**
     * 根据isbn编号查询数据库是否已存在相同商品
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param goodsIsbn 商品的isbn编号
     * @return
     */
    int countGoodsByIsbn(String goodsIsbn);

    /**
     * 新增商品信息
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param goods 商品信息
     * @return
     */
    int insertSelective(Goods goods);



    /**
     * 根据查询条件查询商品信息列表
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param goods 商品信息查询条件
     * @return
     */
    List<Goods> listAllGoods(Goods goods);

    /**
     * 根据商品id查询商品信息
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param goodsId 商品id
     * @return
     */
    Goods selectByPrimaryKey(@Param("goodsId") String goodsId);

    /**
     * 根据id修改商品信息
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param goods 商品信息
     * @return
     */
    int updateByPrimaryKeySelective(Goods goods);

    /**
     * 根据id列表批量修改商品状态
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param listIds        商品列表
     * @param goodsCondition 商品状态
     * @param updatePersonId 更新人id
     * @return
     */
    int updateGoodsListCondition(@Param("listIds") List<String> listIds,
                                 @Param("goodsCondition") int goodsCondition,
                                 @Param("updatePersonId") String updatePersonId);

    /**
     * 删除商品信息（修改字段is_delete状态，并非真正删除）
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param listIds        要删除的商品信息列表
     * @param updatePersonId 更新人id
     * @return
     */
    int deleteGoodsById(@Param("listIds") List<String> listIds, @Param("updatePersonId") String updatePersonId);

    /**
     * 根据商品id列表，查询商品信息列表
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param listIds 商品id列表
     * @return
     */
    List<Goods> findGoodsById(@Param("listIds") List<String> listIds);

    int deleteByPrimaryKey(String goodsId);

    int insert(Goods record);

    int updateByPrimaryKey(Goods record);


    /**
     * 根据id查询商品信息
     * @author 邓嘉豪
     * @date 2020-04-10
     * @param goodsId 用户id
     * @return
     */
    Goods getGoodsById(@Param("goodsId") String goodsId ,Goods goods);




}