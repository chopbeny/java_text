package com.xzsd.pc.store.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class StoreInfo {

    /**
     * 店长账号
     */
    private String userLoginName;

    /**
     * 角色编号
     */
    private String role;

    /**
     * 门店编号
     */
    private String storeId;
    /**
     * 门店名称
     */
    private String storeName;
    /**
     * 门店电话
     */
    private String phone;
    /**
     * 门店店长编号
     */
    private String userId;
    /**
     * 门店店长名称
     */
    private String userName;
    /**
     * 门店营业执照编号
     */
    private String businessCode;
    /**
     * 门店详细地址
     */
    private String address;

    /**
     * 门店邀请码
     */
    private String inviteCode;
    /**
     * 门店省级编号
     */
    private String provinceId;
    /**
     * 门店市级编号
     */
    private String cityId;
    /**
     * 门店区级编号
     */
    private String areaId;

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
    private int version;

    /**
     * 地域编号
     */
    private String areaNameId;

    /**
     * 地域名称
     */

    private String areaName;


    /**
     *该区域的上一级区域编号
     */
    private String areaNameLevel;



    public String getareaNameId() {
        return areaNameId;
    }

    public void setareaNameId(String areaNameId) {
        this.areaNameId = areaNameId;
    }

    public String getareaName() {
        return areaName;
    }

    public void setareaName(String areaName) {
        this.areaName = areaName;
    }

    public String getareaNameLevel() {
        return areaNameLevel;
    }

    public void setareaNameLevel(String areaNameLevel) {
        this.areaNameLevel = areaNameLevel;
    }





    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }

    public String getrole() {
        return role;
    }

    public void setrole(String role) {
        this.role = role;
    }

    public String getuserName() {
        return userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }

    public String getstoreId() {
        return storeId;
    }

    public void setstoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getuserId() {
        return userId;
    }

    public void setuserId(String userId) {
        this.userId = userId;
    }

    public String getstoreName() {
        return storeName;
    }

    public void setstoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
        this.phone = phone;
    }

    public String getbusinessCode() {
        return businessCode;
    }

    public void setbusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public String getinviteCode() {
        return inviteCode;
    }

    public void setinviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public String getprovinceId() {
        return provinceId;
    }

    public void setprovinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getcityId() {
        return cityId;
    }

    public void setcityId(String cityId) {
        this.cityId = cityId;
    }

    public String getareaId() {
        return areaId;
    }

    public void setareaId(String areaId) {
        this.areaId = areaId;
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getisDeleted() {
        return isDeleted;
    }

    public void setisDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }



}
