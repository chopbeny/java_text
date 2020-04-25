package com.xzsd.pc.store.dao;


import com.xzsd.pc.store.entity.Store;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 门店信息数据库接口类
 *
 * @author 邓嘉豪
 * @date 2020-03-30
 */
@Mapper
public interface StoreDao {

    /**
     * 新增门店信息
     *
     * @param store 门店信息
     * @return 0：新增失败，1：新增成功
     */
    int insertSelective(Store store);

    /**
     * 根据传入的查询条件查询门店信息列表
     *
     * @param store       门店信息查询条件
     * @param managerName 店长名称查询条件
     * @return
     */
    List<Store> listStores(@Param("store") Store store, @Param("managerName") String managerName);

    /**
     * 根据id查询门店信息关联查询区域名称信息
     *
     * @param storeId 门店id
     * @return
     */
    Store findStoresById(String storeId);

    /**
     * 根据id查询门店信息
     *
     * @param storeId 门店id
     * @return
     */
    Store selectByPrimaryKey(String storeId);

    /**
     * 根据id修改门店信息
     *
     * @param store 门店信息
     * @return
     */
    int updateByPrimaryKeySelective(Store store);

    /**
     * 删除门店信息（修改字段is_delete状态，并非真正删除）
     *
     * @param listIds        要删除的门店信息列表
     * @param updatePersonId 更新人id
     * @return
     */
    int deleteStoreById(@Param("listIds") List<String> listIds, @Param("updatePersonId") String updatePersonId);

    int insert(Store store);

    int deleteByPrimaryKey(String storeId);

    int updateByPrimaryKey(Store record);
}