package com.xzsd.pc.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class UserInfo {
    /**
     * 用户id
     */
    private String userId;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户登录名
     */
    private String userCode;
    /**
     * 用户密码
     */
    @JsonIgnore
    private String userPassword;
    /**
     * 管理员标记
     */
    private String userLoginName;
    /**
     * 身份证号码
     */
    private String userRole;
    /**
     * 性别
     */
    private String userSex;

    /**
     * 手机号码
     */
    private String userPhone;
    /**
     * 电子邮件
     */
    private String userMail;
    /**
     * 身份证
     */
    private String userIdcard;
    /**
     * 用户绑定店铺id
     */
    private String userStoreId;
    /**
     * 用户图片链接
     */
    private String userImageUrl;

    /**
     * 更改的新密码
     */
    private String newPwd;


    /**
     * 是否删除(0：没删除，1删除）
     */
    private int isDeleted;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建者
     */
    private String createPerson;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新者
     */
    private String updatePerson;

    /**
     * 版本号
     */
    private String version;







    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserpassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getsuerSex() {
        return userSex;
    }

    public void setuserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getuserIdcard() {
        return userIdcard;
    }

    public void setuserIdcard(String userIdcard) {
        this.userIdcard = userIdcard;
    }

    public String getuserStoreId() {
        return userStoreId;
    }

    public void setuserStoreId(String userStoreId) {
        this.userStoreId = userStoreId;
    }

    public String getuserImageUrl() {
        return userImageUrl;
    }

    public void setuserImageUrl(String userImageUrl) {
        this.userImageUrl = userImageUrl;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }


    public Date getcreateTime() {
        return createTime;
    }

    public void setcreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getcreatePerson() {
        return createPerson;
    }

    public void setcreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public Date getupdateTime() {
        return updateTime;
    }

    public void setupdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getupdatePerson() {
        return updatePerson;
    }

    public void setupdatePerson(String updatePerson) {
        this.updatePerson = updatePerson;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getisDeleted() {
        return isDeleted;
    }

    public void setisDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }
}
