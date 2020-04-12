package com.xzsd.pc.client.entity;

public class ClientInfo {
    /**
     * 客户名称
     */
    private String userName;
    /**
     * 客户账号
     */
    private String userAcct;
    /**
     * 角色
     */
    private String role;

    /**
     * 页码
     */
    private int pageSize;

    /**
     * 页数
     */
    private int pageNum;


    /**
     * 用户账号
     */
    private String userLoginName;

    /**
     * 客户性别
     */
    private String userSex;

    /**
     * 客户手机
     */
    private String userPhone;

    /**
     * 客户邮箱
     */
    private String userMail;

    /**
     * 客户身份证
     */
    private String userIdcard;






    public String getUserAcct() {
        return userAcct;
    }

    public void setUserAcct(String userAcct) {
        this.userAcct = userAcct;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getuserPhone() {
        return userPhone;
    }

    public void setuserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getuserMail() {
        return userMail;
    }

    public void setuserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getuserIdcard() { return userIdcard; }

    public void setuserIdcard(String userIdcard) {
        this.userIdcard = userIdcard;
    }



    public String getuserLoginName() {
        return userLoginName;
    }

    public void setuserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }

    public String getuserSex() {
        return userSex;
    }

    public void setuserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getrole() {
        return role;
    }

    public void setrole(String role) {
        this.role = role;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() { return pageNum; }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }


}
