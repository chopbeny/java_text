package com.xzsd.app.user.service;

import com.xzsd.app.image.dao.ImageDao;
import com.xzsd.app.image.entity.Image;
import com.xzsd.app.user.dao.UserDao;
import com.xzsd.app.user.entity.User;
import com.xzsd.app.util.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;


/**
 * 用户管理业务处理类
 *
 * @author 邓嘉豪
 * @date 2020-04-12
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
     * 新增用户接口（注册）
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
        user.setCreatePerson("1");
        user.setUpdatePerson("1");
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
                image.setCreatePerson("1");
                image.setUpdatePerson("1");
                image.setIsDeleted(1);
                //通过图片的id修改图片的分类编号，把用户表的用户信息和图片表的头像图片关联起来
                int headImageStatus = imageDao.updateByPrimaryKeySelective(image);
                //头像和用户信息没有关联成功
                if(headImageStatus == 0){
                    //回滚事务
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return AppResponse.bizError("新增用户信息失败，请输入正确的头像地址");
                }
            }
            return AppResponse.success("注册用户信息成功");
        }
        return AppResponse.bizError("注册成功");
    }

}















