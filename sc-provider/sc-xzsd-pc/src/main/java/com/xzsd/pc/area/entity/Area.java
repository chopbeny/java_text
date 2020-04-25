package com.xzsd.pc.area.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 区域名称实体类
 * 继承BaseEntity获取公有属性
 *
 * @author 邓嘉豪
 * @date 2020-03-27
 */
public class Area{

    /**
     * 区域名称唯一标识，主键
     */
    private String areaNameId;
    /**
     * 全国省、市、县（区）的名称
     */
    private String areaName;
    /**
     * 各区域名称的级别（1：省，2：市，3：县、区）
     */
    private Integer areaNameLevel;
    /**
     * 该区域的上一级区域编号
     */
    private String areaNameParentCode;

    //-----------------关联关系-----------------

    /**
     * 该区域的子区域集合，省包含所有市，市包含所有区，
     * 自关联，一对多
     */
    private List<Area> childAreaList = new ArrayList<>();

    //-----------------get和set方法-----------------


    public List<Area> getChildAreaList() {
        return childAreaList;
    }

    public void setChildAreaList(List<Area> childAreaList) {
        this.childAreaList = childAreaList;
    }

    public String getAreaNameId() {
        return areaNameId;
    }

    public void setAreaNameId(String areaNameId) {
        this.areaNameId = areaNameId == null ? null : areaNameId.trim();
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    public Integer getAreaNameLevel() {
        return areaNameLevel;
    }

    public void setAreaNameLevel(Integer areaNameLevel) {
        this.areaNameLevel = areaNameLevel;
    }

    public String getAreaNameParentCode() {
        return areaNameParentCode;
    }

    public void setAreaNameParentCode(String areaNameParentCode) {
        this.areaNameParentCode = areaNameParentCode == null ? null : areaNameParentCode.trim();
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





}