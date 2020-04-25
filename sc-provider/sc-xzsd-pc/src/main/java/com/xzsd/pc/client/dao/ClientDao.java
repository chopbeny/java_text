package com.xzsd.pc.client.dao;

import com.xzsd.pc.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 客户管理数据库接口类
 *
 * @author 邓嘉豪
 * @date 2020-04-12
 */
@Mapper
public interface ClientDao {

    /**
     * 根据客户信息条件查询客户信息（客户）
     *
     * @param user 查询的客户信息条件
     * @return
     */
    List<User> listClients(User user);

    /**
     * 根据查询条件查询门店所有客户信息
     *
     * @param user 查询条件（含店长编号）
     * @return
     */
    List<User> listStoreClients(User user);

}













