package com.xzsd.app.user.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xzsd.app.image.entity.Image;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 用户信息实体类
 *
 * @author 邓嘉豪
 * @date 2020-03-27
 */
public class UserInfomation {

    /**
     * 更改的新密码
     */
    private String newPwd;
    /**
     * 图片路径
     */
    private String imagePath;
    /**
     * 用户唯一标识，主键
     */
    private String userId;
    /**
     * 用户展示的编号（年月日时分秒+2位随机数）
     */
    private String userCode;
    /**
     * 用户进行登陆的账号
     */
    private String userAcct;
    /**
     * 用户进行登陆的密码
     */
    private String userPassword;
    /**
     * 用户的角色（1：普通管理员，2：店长，3：司机，4：购买的客户）
     */
    private Integer role;
    /**
     * 用户的姓名
     */
    private String userName;
    /**
     * 用户的性别（0：未知，1：男，2：女）
     */
    private Integer sex;
    /**
     * 用户的电话号码
     */
    private String phone;
    /**
     * 用户的邮箱地址
     */
    private String mail;
    /**
     * 用户的身份证号码
     */
    private String idCard;
    /**
     * 每个客户对应的门店编号（其他角色没有该值）
     */
    private String inviteCode;
    /**
     * 店铺邀请码
     */
    private String newInviteCode;
    /**
     * 一个用户关联一张头像图片，一对一
     */
    private Image image;
    /**
     * 关联司机表的省份编号
     */
    private String driverProvinceCode;
    /**
     * 关联司机表的市级编号
     */
    private String driverCityCode;
    /**
     * 关联司机表的区（县）编号
     */
    private String driverRegionCode;
    /**
     * 关联区域表的省份名称
     */
    private String provinceName;
    /**
     * 关联区域表的市级名称
     */
    private String cityName;
    /**
     * 关联区域表的区（县）名称
     */
    private String regionName;


    //-----------------get和set方法-----------------


    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserAcct() {
        return userAcct;
    }

    public void setUserAcct(String userAcct) {
        this.userAcct = userAcct;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public String getNewInviteCode() {
        return newInviteCode;
    }

    public void setNewInviteCode(String newInviteCode) {
        this.newInviteCode = newInviteCode;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getDriverProvinceCode() {
        return driverProvinceCode;
    }

    public void setDriverProvinceCode(String driverProvinceCode) {
        this.driverProvinceCode = driverProvinceCode;
    }

    public String getDriverCityCode() {
        return driverCityCode;
    }

    public void setDriverCityCode(String driverCityCode) {
        this.driverCityCode = driverCityCode;
    }

    public String getDriverRegionCode() {
        return driverRegionCode;
    }

    public void setDriverRegionCode(String driverRegionCode) {
        this.driverRegionCode = driverRegionCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(String updatePerson) {
        this.updatePerson = updatePerson;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 创建该记录的时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 创建该记录的人
     */
    private String createPerson;
    /**
     * 最新的更改时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 最近的更新记录的人
     */
    private String updatePerson;
    /**
     * 该记录的版本号（修改一次加1，初始化为1）
     */
    private Integer version;
    /**
     * 判断该记录是否还可用（0：不可用，1：可用）
     */
    private Integer isDeleted;
    /**
     * 页数，默认为第1页
     */
    private int pageNum = 1;
    /**
     * 页码，默认为一页10条
     */
    private int pageSize = 10;

}
