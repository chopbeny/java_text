package com.xzsd.app.user.service;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.store.dao.StoreDao;
import com.xzsd.app.user.dao.UserInfomationDao;
import com.xzsd.app.user.entity.UserInfomation;
import com.xzsd.app.util.AppResponse;
import com.xzsd.app.util.AuthUtils;
import com.xzsd.app.util.PasswordUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserInfoService {

    @Resource
    private UserInfomationDao userInfomationDao;

    @Resource
    private StoreDao storeDao;


    /**
     * 通过用户代码查找用户
     * @author 邓嘉豪
     * @date 2020-04-10
     * @return 用户信息
     * @param userId
     */
    public UserInfomation getUserById(String userId) {

        return userInfomationDao.selectByPrimaryKey(userId);

    }



    /**
     * 功能：修改密码
     * 描述：略
     * 作成者：邓嘉豪
     * 作成时间：2020/4/11
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updatePwd(UserInfomation userInfo) {
        AppResponse appResponse = AppResponse.success("修改密码成功！");
        // 需要校验原密码是否正确
        if(null != userInfo.getUserPassword() && !"".equals(userInfo.getUserPassword())) {
            String oldPwd = PasswordUtils.generatePassword(userInfo.getUserPassword());
            // 获取用户信息
            //String userId = SecurityUtils.getCurrentUserId();
            String userId = AuthUtils.getCurrentNewPasswordUserId();
            userInfo.setUserId(userId);
            userInfo.setUpdatePerson(userId);
            UserInfomation userDetail = userInfomationDao.selectByPrimaryKey(userInfo.getUserId());

            if(null == userDetail) {
                return AppResponse.bizError("用户不存在或已被删除！");
            } else {
                if(!oldPwd.equals(userDetail.getUserPassword())) {
                    return AppResponse.bizError("原密码不匹配，请重新输入！");
                }
            }
        }
        // 修改密码
        userInfo.setNewPwd(PasswordUtils.generatePassword(userInfo.getNewPwd()));
        int count = userInfomationDao.updateUserPwd(userInfo);
        if(0 == count) {
            appResponse = AppResponse.bizError("修改密码失败，请重试！");
        }
        return appResponse;
    }




    /**
     * 修改店铺邀请码
     * 邓嘉豪
     * 2020-04-15 20:15
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateStoreInviteById(UserInfomation userInfomation){
       // String userId = SecurityUtils.getCurrentUserId();
        String userId = AuthUtils.getCurrentClientId();
        userInfomation.setUserId(userId);
        //检验门店邀请码是否存在
        String newInviteCode = userInfomation.getNewInviteCode();
        String storeId = storeDao.StoreIdByInviteCode(newInviteCode);
        if(storeId == null){
            return AppResponse.bizError("门店邀请码不存在，请重试！");
        }
        //修改店铺邀请码
        int count = userInfomationDao.updateStoreInviteById(userInfomation);
        if(count == 0){
            return AppResponse.bizError("修改店铺邀请码失败，请重试！");
        }
        return AppResponse.success("修改成功！");
    }





}
