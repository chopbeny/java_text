package com.xzsd.app.image.dao;


import com.xzsd.app.image.entity.Image;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 图片数据库接口类
 *
 * @author 邓嘉豪
 * @date 2020-04-11
 */
@Mapper
public interface ImageDao {

    /**
     * 新增图片信息
     * @author 邓嘉豪
     * @date 2020-04-11
     * @param image 图片信息
     * @return
     */
    int insertSelective(Image image);

    /**
     * 删除单张图片信息（修改字段is_delete状态，并非真正删除）
     * @author 邓嘉豪
     * @date 2020-04-11
     * @param imageId 图片编号
     * @param updatePersonId 更新人信息
     * @return
     */
    int deleteByPrimaryKey(@Param("imageId") String imageId, @Param("updatePersonId") String updatePersonId);

    /**
     * 根据图片的分类编号删除图片信息
     * @param imageCateCode 图片的分类编号（包含商品图、轮播图、商品评论图、头像）
     * @author 邓嘉豪
     * @date 2020-04-11
     * @return
     */
    int deleteImageByImageCateCode(@Param("imageCateCode") String imageCateCode,
                                   @Param("updatePersonId") String updatePersonId);

    /**
     * 批量删除用户的头像图片信息（修改字段is_delete状态，并非真正删除）
     * @author 邓嘉豪
     * @date 2020-04-11
     * @param listIds        要删除用户的头像图片的图片分类编号
     * @param updatePersonId 更新人id
     * @return
     */
    int deleteImageByUserId(@Param("listIds") List<String> listIds, @Param("updatePersonId") String updatePersonId);

    /**
     * 批量删除商品的图片信息（修改字段is_delete状态，并非真正删除）
     * @author 邓嘉豪
     * @date 2020-04-11
     * @param listIds        要删除商品图片的图片分类编号
     * @param updatePersonId 更新人id
     * @return
     */
    int deleteImageByGoodsId(@Param("listIds") List<String> listIds, @Param("updatePersonId") String updatePersonId);

    /**
     * 根据图片分类编号修改图片信息
     * @param image 要修改的图片信息
     * @author 邓嘉豪
     * @date 2020-04-11
     * @return
     */
    int updateByImageCateCodeSelective(Image image);


    /**
     * 批量删除轮播图的图片信息（修改字段is_delete状态，并非真正删除）
     * @author 邓嘉豪
     * @date 2020-04-11
     * @param listIds        要删除轮播图图片的图片分类编号
     * @param updatePersonId 更新人id
     * @return
     */
    int deleteImageByRollImageId(@Param("listIds") List<String> listIds, @Param("updatePersonId") String updatePersonId);




    /**
     * 根据图片的id修改图片的分类编号
     * @param image 包含图片的id和图片分类编号
     * @author 邓嘉豪
     * @date 2020-04-11
     * @return
     */
    int updateByPrimaryKeySelective(Image image);

    int insert(Image record);

    Image selectByPrimaryKey(String imageId);

    int updateByPrimaryKey(Image record);
}