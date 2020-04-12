package com.xzsd.pc.goodsCate.dao;
import com.xzsd.pc.goodsCate.entity.GoodsCateInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName GoodsCate
 * @Description goodsCate
 * @Author 邓嘉豪
 * @Date 2020-03-26
 */
@Mapper
public interface GoodsCateDao {


    /**
     * 统计商品分类数量
     * @param goodsCateInfo 商品分类信息
     * @return
     */
    int countCateId(GoodsCateInfo goodsCateInfo);

    /**
     * 新增分类商品
     * @param goodsCateInfo 商品分类信息
     * @return
     */
    int addGoodsCate(GoodsCateInfo goodsCateInfo);


    /**
     * 获取商品分类所有信息
     * @param goodsCateInfo 商品信息
     * @return 所有用户信息
     */
    List<GoodsCateInfo> listGoodsCateByPage(GoodsCateInfo goodsCateInfo);


    /**
     * 获取商品分类详情
     * @param cateId 商品信息
     * @return 所有用户信息
     */

    GoodsCateInfo findGoodsCateById(String cateId);

    /**
     * 修改商品分类信息
     * @param goodsCateInfo 商品信息
     * @return 修改结果
     */
    int updateGoodsCateById(GoodsCateInfo goodsCateInfo);

    /**
     * 删除商品分类信息
     * @param listCode 选中的用户编号集合
     * @param cateid 更新人
     * @return
     */

    int deleteGoodsCateById(List<String> listCode, @Param("cateid") String cateid);
}
