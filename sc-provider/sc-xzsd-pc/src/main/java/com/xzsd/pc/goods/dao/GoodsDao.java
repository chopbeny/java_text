package com.xzsd.pc.goods.dao;

import com.xzsd.pc.goods.entity.GoodsInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName Goods
 * @Description goods
 * @Author 邓嘉豪
 * @Date 2020-03-26
 */
@Mapper
public interface GoodsDao {
    /**
     * 统计商品数量
     * @param goodsInfo 商品信息
     * @return
     */
    int countGoodsId(GoodsInfo goodsInfo);

    /**
     * 新增商品
     * @param goodsInfo 商品信息
     * @return
     */
    int addGoods(GoodsInfo goodsInfo);

    /**
     * 获取商品所有信息
     * @param goodsInfo 商品信息
     * @return 所有用户信息
     */
    List<GoodsInfo> listGoodsByPage(GoodsInfo goodsInfo);

    /**
     * 修改商品信息
     * @param goodsInfo 商品信息
     * @return 修改结果
     */
    int updateGoods(GoodsInfo goodsInfo);

    /**
     * 删除商品信息
     * @param listCode 选中的用户编号集合
     * @param goodsid 更新人
     * @return
     */
    int deleteGoods(List<String> listCode, @Param("goodsid") String goodsid);

    /**
     * 修改商品状态
     * @param goodsInfo
     * @return
     */
    int updateGoodsCondition(GoodsInfo goodsInfo);
}
