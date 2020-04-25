package com.xzsd.app.driver.dao;

import com.xzsd.app.driver.entity.Driver;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * 客户管理数据库接口类
 *
 * @author 邓嘉豪
 * @date 2020-04-12
 */
@Mapper
public interface DriverDao {
    /**
     * 根据查询条件查询门店所有客户信息
     *
     * @param driver 查询条件（含店长编号）
     * @return
     */

    List<Driver> listStoreClients(Driver driver);


}
