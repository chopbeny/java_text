package com.xzsd.app.home.entity;
/**
 * 轮播图实体类
 * 继承BaseEntity获取公有属性
 *
 * @author 邓嘉豪
 * @date 2020-03-27
 */
public class HomeInfo {

    /**
     * 商品id
     */
    private String goodsId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品价格
     */
    private String goodsPrice;

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
     * 轮播图的图片状态（0：禁用，1：启用）
     */
    private Integer rollImageCondition;


    //-----------------get和set方法-----------------


    public String getgoodsId() {
        return goodsId;
    }

    public void setgoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getgoodsName() {
        return goodsName;
    }

    public void setgoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getgoodsPrice() {
        return goodsPrice;
    }

    public void setgoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
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

    public Integer getRollImageCondition() {
        return rollImageCondition;
    }

    public void setRollImageCondition(Integer rollImageCondition) {
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
