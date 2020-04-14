package com.xzsd.pc.driver.entity;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description 司机实体类
 * @Author 邓嘉豪
 * @Date 2020-03-27
 */
public class DriverInfo{

    /**
     * 司机唯一标识id
     */
    public String driverId;

    /**
     * 页码
     */
    private int pageSize;

    /**
     * 页数
     */
    private int pageNum;

    /**
     * 省份编号
     */
    private String driverProvinceCode;

    /**
     * 城市编号
     */
    private String driverCityCode;

    /**
     * 市区编号
     */
    private String driverRegionCode;


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


    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }


    public String getdriverProvinceCode(){return driverProvinceCode; }

    public void setdriverProvinceCode(String driverProvinceCode){this.driverProvinceCode = driverProvinceCode; }

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

    public String getdriverCityCode() {
        return driverCityCode;
    }

    public void setdriverCityCode(String driverCityCode) {
        this.driverCityCode = driverCityCode;
    }

    public String getdriverRegionCode() {
        return driverRegionCode;
    }

    public void setdriverRegionCode(String driverRegionCode) {
        this.driverRegionCode = driverRegionCode;
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






