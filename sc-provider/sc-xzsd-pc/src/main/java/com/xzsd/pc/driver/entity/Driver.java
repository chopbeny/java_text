package com.xzsd.pc.driver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xzsd.pc.area.entity.Area;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 司机信息实体类
 * 继承BaseEntity获取公有属性
 *
 * @author 邓嘉豪
 * @date 2020-03-27
 */
public class Driver{

    /**
     * 用户名
     */
    private String userName;

    /**
     * 司机信息的唯一标识，主键
     */
    private String driverId;
    /**
     * 关联用户信息表里的司机编号
     */
    private String driverUserCode;
    /**
     * 司机负责的店铺所属的省份编号
     */
    private String driverProvinceCode;
    /**
     * 司机负责的店铺所属的城市的编号
     */
    private String driverCityCode;
    /**
     * 司机负责的店铺所属的区的编号
     */
    private String driverRegionCode;

    //-----------------关联关系-----------------

    /**
     * 一个司机关联三个区域名称，省市区，一对多
     */
    private List<Area> areaList;

    //-----------------get和set方法-----------------


    public List<Area> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<Area> areaList) {
        this.areaList = areaList;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId == null ? null : driverId.trim();
    }

    public String getDriverUserCode() {
        return driverUserCode;
    }

    public void setDriverUserCode(String driverUserCode) {
        this.driverUserCode = driverUserCode;
    }

    public String getDriverProvinceCode() {
        return driverProvinceCode;
    }

    public void setDriverProvinceCode(String driverProvinceCode) {
        this.driverProvinceCode = driverProvinceCode == null ? null : driverProvinceCode.trim();
    }

    public String getDriverCityCode() {
        return driverCityCode;
    }

    public void setDriverCityCode(String driverCityCode) {
        this.driverCityCode = driverCityCode == null ? null : driverCityCode.trim();
    }

    public String getDriverRegionCode() {
        return driverRegionCode;
    }

    public void setDriverRegionCode(String driverRegionCode) {
        this.driverRegionCode = driverRegionCode == null ? null : driverRegionCode.trim();
    }

    public String getuserName() {
        return userName;
    }

    public void setuserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
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





    /**
     * 页数，默认为第1页
     */
    private int pageNum = 1;
    /**
     * 页码，默认为一页10条
     */
    private int pageSize = 10;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
}