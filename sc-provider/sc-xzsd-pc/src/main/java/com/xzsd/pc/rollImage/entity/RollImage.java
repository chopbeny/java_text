package com.xzsd.pc.rollimage.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xzsd.pc.image.entity.Image;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 轮播图实体类
 * 继承BaseEntity获取公有属性
 *
 * @author 邓嘉豪
 * @date 2020-03-27
 */
public class RollImage{

    /**
     * 图片唯一标识，主键
     */
    private String imageId;

    /**
     * 图片的存储url地址
     */
    private String imageUrl;

    /**
     * 轮播图唯一标识，主键
     */
    private String rollImageId;
    /**
     * 轮播图里的图片编号
     */
    private String rollImageCode;
    /**
     * 轮播图的图片权值（权值越小排名越前，默认为：99999）
     */
    private Integer rollImageWeight;
    /**
     * 轮播图的图片对应的商品编号
     */
    private String rollImageGoodsCode;
    /**
     * 轮播图的图片起始时间
     */
    private Date rollImageBeginDate;
    /**
     * 轮播图的图片终止时间
     */
    private Date rollImageEndDate;
    /**
     * 轮播图的图片状态（0：禁用，1：启用）
     */
    private String rollImageCondition;

    //-----------------关联关系-----------------

    /**
     * 一张轮播图对应一张图片，一对一
     */
    private Image image;

    //-----------------get和set方法-----------------


    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getRollImageId() {
        return rollImageId;
    }

    public void setRollImageId(String rollImageId) {
        this.rollImageId = rollImageId == null ? null : rollImageId.trim();
    }

    public String getRollImageCode() {
        return rollImageCode;
    }

    public void setRollImageCode(String rollImageCode) {
        this.rollImageCode = rollImageCode == null ? null : rollImageCode.trim();
    }

    public Integer getRollImageWeight() {
        return rollImageWeight;
    }

    public void setRollImageWeight(Integer rollImageWeight) {
        this.rollImageWeight = rollImageWeight;
    }

    public String getRollImageGoodsCode() {
        return rollImageGoodsCode;
    }

    public void setRollImageGoodsCode(String rollImageGoodsCode) {
        this.rollImageGoodsCode = rollImageGoodsCode == null ? null : rollImageGoodsCode.trim();
    }

    public Date getRollImageBeginDate() {
        return rollImageBeginDate;
    }

    public void setRollImageBeginDate(Date rollImageBeginDate) {
        this.rollImageBeginDate = rollImageBeginDate;
    }

    public Date getRollImageEndDate() {
        return rollImageEndDate;
    }

    public void setRollImageEndDate(Date rollImageEndDate) {
        this.rollImageEndDate = rollImageEndDate;
    }

    public String getRollImageCondition() {
        return rollImageCondition;
    }

    public void setRollImageCondition(String rollImageCondition) {
        this.rollImageCondition = rollImageCondition;
    }
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId == null ? null : imageId.trim();
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