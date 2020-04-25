package com.xzsd.app.user.dao;

import com.xzsd.app.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * 客户管理数据库接口类
 *
 * @author 邓嘉豪
 * @date 2020-04-12
 */
@Mapper
public interface UserDao {

    /**
     * 新增用户信息
     * @author 邓嘉豪
     * @date 2020-04-10
     * @param user 用户信息
     * @return
     */
    int insertSelective(User user);

    /**
     * 根据用户账号信息计算用户数
     * @author 邓嘉豪
     * @date 2020-04-10
     * @param userLoginName 用户账号
     * @return
     */
    int countUserByUserLoginName(@Param("userLoginName") String userLoginName);


    /**
     * 根据id查询用户信息
     * @author 邓嘉豪
     * @date 2020-04-10
     * @param userId 用户id
     * @return
     */
    User selectByPrimaryKey(@Param("userId") String userId);


}













