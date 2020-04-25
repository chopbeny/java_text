package com.xzsd.app.user.dao;

import com.xzsd.app.user.entity.UserInfomation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UserInfomationDao {

    /**
     * 根据id查询用户信息
     * @author 邓嘉豪
     * @date 2020-04-10
     * @param userId 用户id
     * @return
     */
    UserInfomation selectByPrimaryKey(@Param("userId") String userId);


    /**
     * 修改密码
     * @param userInfo 用户信息
     * @return
     */
    int updateUserPwd(@Param("userInfo") UserInfomation userInfo);


    /**
     * 修改店铺邀请码
     * 邓嘉豪
     * 2020-04-13 20:32
     */
    int updateStoreInviteById(UserInfomation userInfomation);







}
