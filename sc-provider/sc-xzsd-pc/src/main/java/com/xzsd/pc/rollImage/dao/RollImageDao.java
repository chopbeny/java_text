package com.xzsd.pc.rollImage.dao;

import com.xzsd.pc.rollImage.entity.RollImageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName rollImage
 * @Description rollImage
 * @Author 邓嘉豪
 * @Date 2020-03-30
 */

@Mapper
public interface RollImageDao {
    /**
     * 统计轮播图数量
     * @param rollImageInfo 轮播图信息
     * @return
     */
    int countRollImage(RollImageInfo rollImageInfo);

    /**
     * 新增轮播图
     * @param rollImageInfo 轮播图信息
     * @return
     */
    int addRollImage(RollImageInfo rollImageInfo);


    /**
     * 获取轮播图列表
     * @param rollImageInfo 商品信息
     * @return 所有用户信息
     */
    List<RollImageInfo> listRollImagesByPage(RollImageInfo rollImageInfo);


    /**
     * 修改轮播图状态
     * @param rollImageInfo 商品信息
     * @return 修改结果
     */
    int updateRollImageConditionById(RollImageInfo rollImageInfo);

    /**
     * 删除轮播图
     * @param listCode 选中的用户编号集合
     * @param rollImageId 更新人
     * @return
     */

    int deleteRollImageById(List<String> listCode, @Param("rollImageId") String rollImageId);

}
