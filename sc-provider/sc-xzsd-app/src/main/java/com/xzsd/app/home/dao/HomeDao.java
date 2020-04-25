package com.xzsd.app.home.dao;

import com.xzsd.app.home.entity.HomeInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * 轮播图数据库接口类
 *
 * @author 邓嘉豪
 * @date 2020-04-14
 */
@Mapper
public interface HomeDao {


    /**
     * 根据轮播图状态查询轮播图列表
     * @return
     */
    List<HomeInfo> listRollImagesApp(HomeInfo homeInfo);

    /**
     * 根据商品信息条件查询热门位商品关联查询商品信息
     * @author 邓嘉豪
     * @date 2020-04-16
     * @return
     */
    List<HomeInfo> listHotGoodsApp(HomeInfo homeInfo);


}
