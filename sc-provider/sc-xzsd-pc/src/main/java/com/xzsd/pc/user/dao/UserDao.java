package com.xzsd.pc.user.dao;


import com.xzsd.pc.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户管理数据库接口类
 * @author 邓嘉豪
 * @date 2020-04-10
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
     * 根据用户账号计算用户数（排除用户本身）
     * @param user 用户账号和用户编号
     * @author 邓嘉豪
     * @date 2020-04-10
     * @return
     */
    int countUserByUserLoginNameAndUserId(User user);

    /**
     * 根据用户信息条件查询用户信息（管理员、店长、司机）
     * @author 邓嘉豪
     * @date 2020-04-10
     * @param user 查询的用户信息条件
     * @return
     */
    List<User> listUsers(User user);

    /**
     * 根据id查询用户信息
     * @author 邓嘉豪
     * @date 2020-04-10
     * @param userId 用户id
     * @return
     */
    User selectByPrimaryKey(@Param("userId") String userId);

    /**
     * 根据id修改用户信息
     *
     * @param user 门店信息
     * @return
     */
    int updateByPrimaryKeySelective(User user);

    /**
     * 删除用户信息（修改字段is_delete状态，并非真正删除）
     * @author 邓嘉豪
     * @date 2020-04-10
     * @param listIds        要删除的用户信息列表
     * @param updatePersonId 更新人id
     * @return
     */
    int deleteUserById(@Param("listIds") List<String> listIds, @Param("updatePersonId") String updatePersonId);

    /**
     * 根据id查询用户信息
     * @param userId 用户id
     * @author 邓嘉豪
     * @date 2020-04-10
     * @return
     */
    User findUserById(@Param("userId") String userId);

    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int updateByPrimaryKey(User record);
}