package com.xzsd.app.goods.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 商品分类实体类
 * 继承BaseEntity获取公有属性
 *
 * @author 邓嘉豪
 * @date 2020-03-27
 */
public class GoodsCate {

    /**
     * 商品分类唯一标识，主键
     */
    private String goodsCateId;
    /**
     * 商品各种类别的名称
     */
    private String cateName;
    /**
     * 该类别的层级（1：第一级，2：第二级）
     */
    private Integer cateLevel;
    /**
     * 该类别的上一级编号（null：没有上一级，则该记录为第一级）
     */
    private String cateParent;
    /**
     * 该记录的备注信息
     */
    private String cateComment;

    //-----------------关联关系-----------------

    /**
     * 该商品分类的子分类集合，一级分类包含二级分类
     * 自关联，一对多
     */
    private List<GoodsCate> childGoodsCateList;

    /**
     * 该商品分类的父级分类，二级分类只有一个一级分类，一级分类没有父级分类
     * 自关联，一对一
     */
    private GoodsCate parentGoodsCate;

    /**
     * 二级分类编号
     * @return
     */
    private String secondGoodsCateCode;

    /**
     * 二级分类名称
     * @return
     */
    private String secondGoodsCateName;
    /**
     * 一个二级分类下面有多个商品，一对多
     */
    private List<GoodsInfo> goodsInfoList;

   //-----------------get和set方法-----------------


    public String getSecondGoodsCateCode() {
        return secondGoodsCateCode;
    }

    public void setSecondGoodsCateCode(String secondGoodsCateCode) {
        this.secondGoodsCateCode = secondGoodsCateCode;
    }

    public String getSecondGoodsCateName() {
        return secondGoodsCateName;
    }

    public void setSecondGoodsCateName(String secondGoodsCateName) {
        this.secondGoodsCateName = secondGoodsCateName;
    }

    public List<GoodsInfo> getGoodsInfoList() {
        return goodsInfoList;
    }

    public void setGoodsInfoList(List<GoodsInfo> goodsInfoList) {
        this.goodsInfoList = goodsInfoList;
    }

    public GoodsCate getParentGoodsCate() {
        return parentGoodsCate;
    }

    public void setParentGoodsCate(GoodsCate parentGoodsCate) {
        this.parentGoodsCate = parentGoodsCate;
    }

    public List<GoodsCate> getChildGoodsCateList() {
        return childGoodsCateList;
    }

    public void setChildGoodsCateList(List<GoodsCate> childGoodsCateList) {
        this.childGoodsCateList = childGoodsCateList;
    }

    public String getGoodsCateId() {
        return goodsCateId;
    }

    public void setGoodsCateId(String goodsCateId) {
        this.goodsCateId = goodsCateId == null ? null : goodsCateId.trim();
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName == null ? null : cateName.trim();
    }

    public Integer getCateLevel() {
        return cateLevel;
    }

    public void setCateLevel(Integer cateLevel) {
        this.cateLevel = cateLevel;
    }

    public String getCateParent() {
        return cateParent;
    }

    public void setCateParent(String cateParent) {
        this.cateParent = cateParent == null ? null : cateParent.trim();
    }

    public String getCateComment() {
        return cateComment;
    }

    public void setCateComment(String cateComment) {
        this.cateComment = cateComment == null ? null : cateComment.trim();
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