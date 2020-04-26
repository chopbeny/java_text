package com.xzsd.pc.user.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.image.dao.ImageDao;
import com.xzsd.pc.image.entity.Image;
import com.xzsd.pc.user.entity.User;
import com.xzsd.pc.util.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 用户管理业务处理类
 * @author 邓嘉豪
 * @date 2020-04-10
 */
@Service
public class UserService {

    @Resource
    private UserDao userDao;

    @Resource
    private ImageDao imageDao;

    @Resource
    private TencentCOSUtil tencentCOSUtil;


    /**
     * 顶部栏接口
     *
     * @return
     */
    public AppResponse topInfo(){
       String userId = AuthUtils.getCurrentUserId();
        User user = userDao.findUserById(userId);
        System.out.println("11111111111"+userId);
        System.out.println(user);
        if(user != null){
            return AppResponse.success("顶部栏信息查询成功", user);
        }
        return AppResponse.bizError("顶部栏信息查询失败");
    }


    /**
     * 新增用户接口
     * @param user 用户信息
     * @param imageId 上传的头像图片编号
     * @author 邓嘉豪
     * @date 2020-04-10
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addUser(User user, String imageId) {
        //查询数据库中是否有该账号的用户
        int count = userDao.countUserByUserLoginName(user.getuserAcct());
        //数据库中存在相同账号的用户
        if (count != 0) {
            return AppResponse.bizError("用户账号已存在");
        }
        //设置UUID为主键
        user.setUserId(UUIDUtils.getUUID());
        //设置用户展示的编号（年月日时分秒+2位随机数）
        user.setUserCode(StringUtil.getCommonCode(2));
        //把用户密码加密
        user.setUserPassword(PasswordUtils.generatePassword(user.getUserPassword()));
        //设置基本属性
        user.setCreatePerson(AuthUtils.getCurrentUserId());
        user.setUpdatePerson(AuthUtils.getCurrentUserId());
        user.setVersion(1);
        user.setIsDeleted(1);
        int status = userDao.insertSelective(user);
        //用户新增成功
        if (status > 0) {
            //如果新增用户时有上传头像
            if(imageId != null && !"".equals(imageId)){
                Image image = new Image();
                image.setImageId(imageId);
                image.setImageCateCode(user.getUserId());
                //通过图片的id修改图片的分类编号，把用户表的用户信息和图片表的头像图片关联起来
                int headImageStatus = imageDao.updateByPrimaryKeySelective(image);
                //头像和用户信息没有关联成功
                if(headImageStatus == 0){
                    //回滚事务
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return AppResponse.bizError("新增用户信息失败，请输入正确的头像地址");
                }
            }
            return AppResponse.success("新增用户信息成功");
        }
        return AppResponse.bizError("新增用户信息失败");
    }



    /**
     * 根据用户账号查询用户接口
     * @author 邓嘉豪
     * @date 2020-04-10
     * @param userLoginName 用户账号
     * @return
     */
    public AppResponse countUserByUserLoginName(String userLoginName) {
        //判断用户账号是否为null或者""
        if (userLoginName != null && !"".equals(userLoginName.trim())) {
            int count = userDao.countUserByUserLoginName(userLoginName);
            //数据库中存在相同账号的用户
            if (count != 0) {
                return AppResponse.bizError("用户账号已存在");
            } else {
                return AppResponse.success("用户账号可使用");
            }
        } else {
            return AppResponse.bizError("用户账号输入有误，请重新输入");
        }
    }

    /**
     * 根据用户信息条件查询用户信息（管理员、店长、司机）
     * @author 邓嘉豪
     * @date 2020-04-10
     * @param user     查询的用户信息条件
     * @return
     */
    public AppResponse listUsers(User user) {
        PageHelper.startPage(user.getPageNum(), user.getPageSize());
        List<User> users = userDao.listUsers(user);
        PageInfo<User> pageData = new PageInfo<User>(users);
        return AppResponse.success("查询成功!", pageData);
    }

    /**
     * 修改用户信息接口
     * @author 邓嘉豪
     * @date 2020-04-10
     * @param user 要修改的用户信息
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateUserById(User user, String imageId) {
        //校验用户角色不为null或着0

        //校验数据库中有没有该id的记录
        User oldUser = userDao.selectByPrimaryKey(user.getUserId());
        if (oldUser == null) {
            return AppResponse.bizError("没有该用户信息");
        } else if (!oldUser.getVersion().equals(user.getVersion())) {
            return AppResponse.bizError("信息已更新，请重试");
        }
        //查询数据库中是否有该账号的用户
        int count = userDao.countUserByUserLoginName(user.getuserAcct());
        //数据库中存在相同账号的用户
        if (count >= 2) {
            return AppResponse.bizError("用户账号已存在");
        }
        //加密密码
        user.setUserPassword(PasswordUtils.generatePassword(user.getUserPassword()));
        //设置基本信息
        user.setUpdatePerson(AuthUtils.getCurrentUserId());
        user.setVersion(oldUser.getVersion() + 1);
        int status = userDao.updateByPrimaryKeySelective(user);
        if (status > 0) {
            //如果修改用户时有上传头像
            if(imageId != null && !"".equals(imageId)){
                //把之前的用户头像进行删除
                imageDao.deleteImageByImageCateCode(user.getUserId(), AuthUtils.getCurrentUserId());
                Image image = new Image();
                image.setImageId(imageId);
                image.setImageCateCode(user.getUserId());
                //通过图片的id，把用户表的用户信息和图片表的头像图片关联起来
                int headImageStatus = imageDao.updateByPrimaryKeySelective(image);
                //头像和用户信息没有关联成功
                if(headImageStatus == 0){
                    //回滚事务
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return AppResponse.bizError("修改用户信息失败，请输入正确的头像地址");
                }
            }
            return AppResponse.success("修改用户信息成功");
        } else {
            return AppResponse.bizError("修改用户信息失败");
        }
    }

    /**
     * 删除用户接口
     * @param userId 要删除的id
     * @author 邓嘉豪
     * @date 2020-04-10
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteUserById(String userId){
        List<String> listIds = Arrays.asList(userId.split(","));
        //删除用户信息列表集合，设置更新人id
        int count = userDao.deleteUserById(listIds, AuthUtils.getCurrentUserId());
        //当要删除的用户总数和已删除的总数不等时，回滚事务，删除失败
        if (count != listIds.size()) {
            //回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return AppResponse.bizError("所选列表有未存在数据，删除失败");
        } else {
            //同时删除用户信息列表关联的头像图片
            imageDao.deleteImageByUserId(listIds, AuthUtils.getCurrentUserId());
            return AppResponse.success("删除成功");
        }
    }


    /**
     * 通过用户代码查找用户
     * @author 邓嘉豪
     * @date 2020-04-10
     * @param userId 用户代码
     * @return 用户信息
     */
    public User getUserById(String userId) {
        return userDao.selectByPrimaryKey(userId);
    }

}















