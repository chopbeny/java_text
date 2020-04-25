package com.xzsd.pc.hotgoods.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 热门商品实体类
 * 继承BaseEntity获取公有属性
 *
 * @author 邓嘉豪
 * @date 2020-03-27
 */
public class HotGoods{

    /**
     * 热门商品唯一标识，主键
     */
    private String hotGoodsId;
    /**
     * 热门商品的商品编号
     */
    private String hotGoodsGoodsCode;
    /**
     * 热门商品的权重（权值越小排名越前，默认为：99999）
     */
    private Integer hotGoodsWeight;

    //-----------------关联关系-----------------

    /**
     * 用于展示商品的编号（年月日时分秒+2位随机数）
     */
    private String goodsCode;
    /**
     * 商品的名称
     */
    private String goodsName;
    /**
     * 商品的销售价格
     */
    private String goodsSalePrice;
    /**
     * 商品的详细介绍
     */
    private String goodsDescription;

    //-----------------get和set方法-----------------


    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsSalePrice() {
        return goodsSalePrice;
    }

    public void setGoodsSalePrice(String goodsSalePrice) {
        this.goodsSalePrice = goodsSalePrice;
    }

    public String getGoodsDescription() {
        return goodsDescription;
    }

    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription;
    }

    public String getHotGoodsId() {
        return hotGoodsId;
    }

    public void setHotGoodsId(String hotGoodsId) {
        this.hotGoodsId = hotGoodsId == null ? null : hotGoodsId.trim();
    }

    public String getHotGoodsGoodsCode() {
        return hotGoodsGoodsCode;
    }

    public void setHotGoodsGoodsCode(String hotGoodsGoodsCode) {
        this.hotGoodsGoodsCode = hotGoodsGoodsCode == null ? null : hotGoodsGoodsCode.trim();
    }

    public Integer getHotGoodsWeight() {
        return hotGoodsWeight;
    }

    public void setHotGoodsWeight(Integer hotGoodsWeight) {
        this.hotGoodsWeight = hotGoodsWeight;
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