package com.xzsd.pc.image.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 图片信息实体类
 * 继承BaseEntity获取公有属性
 *
 * @author 邓嘉豪
 * @date 2020-03-27
 */
public class Image{

    /**
     * 图片唯一标识，主键
     */
    private String imageId;
    /**
     * 图片使用类别（1：商品图，2：轮播图，3：商品评论图，4：订单评论图，5：头像）
     */
    private Integer imageCate;
    /**
     * 具体的图片类别的编号（例如商品图的编号、轮播图的编号）
     */
    private String imageCateCode;
    /**
     * 图片的存储url地址
     */
    private String imageUrl;
    /**
     * 图片权值（权值越小排名越前，默认为：99999）
     */
    private Integer imageWeight;

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId == null ? null : imageId.trim();
    }

    public Integer getImageCate() {
        return imageCate;
    }

    public void setImageCate(Integer imageCate) {
        this.imageCate = imageCate;
    }

    public String getImageCateCode() {
        return imageCateCode;
    }

    public void setImageCateCode(String imageCateCode) {
        this.imageCateCode = imageCateCode == null ? null : imageCateCode.trim();
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public Integer getImageWeight() {
        return imageWeight;
    }

    public void setImageWeight(Integer imageWeight) {
        this.imageWeight = imageWeight;
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