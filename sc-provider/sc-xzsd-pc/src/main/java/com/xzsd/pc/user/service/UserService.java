package com.xzsd.pc.user.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.neusoft.util.UUIDUtils;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.user.entity.UserSettingDTO;
import com.xzsd.pc.util.PasswordUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * @ClassName UserService
 * @Description 用户管理
 * @Author 邓嘉豪
 * @Date 2020/4/11
 */
@Service
public class UserService {

    @Resource
    private UserDao userDao;

    /**
     * 功能：新增用户
     * 描述：略
     * 作成者：邓嘉豪
     * 作成时间：2020/4/11
     */

    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveUser(UserInfo userInfo) {

        // 校验账号是否存在
        int countUserAcct = userDao.countUserAcct(userInfo);
        if(0 != countUserAcct) {
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }
        // 密码加密 默认为123456
        String pwd = PasswordUtils.generatePassword("123456");
        userInfo.setUserId(StringUtil.getCommonCode(2));
        userInfo.setUserPassword(pwd);
        userInfo.setisDeleted(0);
       // userInfo.setUserId(UUIDUtils.getUUID());
        // 新增用户
        int count = userDao.saveUser(userInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }



    /**
     * 通过用户代码查找用户
     *作者：邓嘉豪
     * @param userCode 用户代码
     * @return 用户信息
     */
    public UserInfo getUserById(String userCode) {
        return userDao.getUserById(userCode);
    }


    /**
     * 功能：获取用户列表
     * 描述：略
     * 作成者：邓嘉豪
     * 作成时间：2020/4/11
     */
    //@SystemLog(operation = "获取用户列表。。。。。")
    public AppResponse listUsers(UserInfo userInfo) {
        List<UserInfo> userInfoList = userDao.listUsersByPage(userInfo);
        return AppResponse.success("查询成功！", getPageInfo(userInfoList));
    }

    /**
     * 功能：修改用户信息
     * 描述：略
     * 作成者：邓嘉豪
     * 作成时间：2020/4/11
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateUser(UserInfo userInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验账号是否存在
        int countUserAcct = userDao.countUserAcct(userInfo);
        if(0 != countUserAcct) {
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }
        // 修改用户信息
        int count = userDao.updateUser(userInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        // 新增用部门
        return appResponse;
    }

    /*
     * user 删除用户
     * @param userId
     * @param userid
     * @return
     * @Author 邓嘉豪
     * @Date 2020-03-26

*/

    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteUser(UserSettingDTO userSettingDTO) {
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除用户
        int count = userDao.deleteUser(userSettingDTO);
        if(0 == count) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();// 回滚
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }






    /**
     * 功能：修改密码
     * 描述：略
     * 作成者：邓嘉豪
     * 作成时间：2020/4/11
     */
    public AppResponse updatePwd(UserInfo userInfo) {
        AppResponse appResponse = AppResponse.success("修改密码成功！");
        // 需要校验原密码是否正确
        if(null != userInfo.getUserpassword() && !"".equals(userInfo.getUserpassword())) {
            String oldPwd = PasswordUtils.generatePassword(userInfo.getUserpassword());
            // 获取用户信息
            UserInfo userDetail = userDao.getUserById(userInfo.getUserId());

            if(null == userDetail) {
                return AppResponse.bizError("用户不存在或已被删除！");
            } else {
                if(!oldPwd.equals(userDetail.getUserpassword())) {
                    return AppResponse.bizError("原密码不匹配，请重新输入！");
                }
            }
        }
        // 修改密码
        userInfo.setNewPwd(PasswordUtils.generatePassword(userInfo.getNewPwd()));
        int count = userDao.updateUserPwd(userInfo);
        if(0 == count) {
            appResponse = AppResponse.bizError("修改密码失败，请重试！");
        }
        return appResponse;
    }
}
