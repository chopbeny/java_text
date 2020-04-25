package com.xzsd.pc.user.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 店长管理数据库接口类
 *
 * @author 黄瑞穆
 * @date 2020-04-11
 */
@Mapper
public interface ManagerDao {

    /**
     * 根据店长编号查询是否有该店长
     * @param managerId 店长编号
     * @return
     */
    int countManagerByManagerId(@Param("managerId") String managerId);
}