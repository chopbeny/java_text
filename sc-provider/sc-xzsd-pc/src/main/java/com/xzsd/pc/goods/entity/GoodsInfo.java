package com.xzsd.pc.goods.entity;
import java.util.Date;

/**
 * @Description 商品实体类
 * @Author 邓嘉豪
 * @Date 2020-03-30
 */

public class GoodsInfo {
    /**
     * 商品id
     */
    private String goodsId;
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品定价
     */
    private String goodsFixPrice;
    /**
     * 商品成本价
     */
    private String goodsCostPrice;
    /**
     * 商品销售价
     */
    private String goodsSalePrice;
    /**
     * 商品库存数量
     */
    private String goodsStock;
    /**
     * 商品销售量
     */
    private String goodsSaleSum;
    /**
     * 商品分类编号
     */
    private String goodsCateCode;
    /**
     * 商品广告词
     */
    private String goodsAdvertisement;
    /**
     * 商品详细介绍
     */
    private String goodsDescription;
    /**
     * 商品的销售状态（0：未发布，1：在售，2：已下架。默认为0）
     */
    private String goodsCondition;
    /**
     * 商品上架时间
     */
    private String goodsSaleTime;
    /**
     * 商品访问量
     */
    private String goodsVisitNum;
    /**
     * 商品供应商名称
     */
    private String goodsBusiness;
    /**
     * 供应商编号
     */
    private String goodsBusinessCode;
    /**
     * 商品isbn编号
     */
    private String goodsIsbn;

    /**
     * 商品出版社
     */
    private String goodsPublisher;

    /**
     * 商品作者
     */
    private String goodsAuthor;

    /**
     * 商品评价星级
     */
    private String goodsStar;

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

    /**
     * 是否删除
     */
    private int isDeleted;

    public String getgoodsId() {
        return goodsId;
    }

    public void setgoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getgoodsCode() {
        return goodsCode;
    }

    public void setgoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

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

    public String getgoodsName() {
        return goodsName;
    }

    public void setgoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getgoodsFixPrice() {
        return goodsFixPrice;
    }

    public void setgoodsFixPrice(String goodsFixPrice) {
        this.goodsFixPrice = goodsFixPrice;
    }

    public String getgoodsCostPrice() {
        return goodsCostPrice;
    }

    public void setgoodsCostPrice(String goodsCostPrice) {
        this.goodsCostPrice = goodsCostPrice;
    }

    public String getgoodsSalePrice() {
        return goodsSalePrice;
    }

    public void setgoodsSalePrice(String goodsSalePrice) {
        this.goodsSalePrice = goodsSalePrice;
    }


    public String getgoodsStock() {
        return goodsStock;
    }

    public void setgoodsStock(String goodsStock) {
        this.goodsStock = goodsStock;
    }

    public String getgoodsSaleSum() {
        return goodsSaleSum;
    }

    public void setgoodsSaleSum(String goodsSaleSum) {
        this.goodsSaleSum = goodsSaleSum;
    }

    public String getgoodsCateCode() {
        return goodsCateCode;
    }

    public void setgoodsCateCode(String goodsCateCode) {
        this.goodsCateCode = goodsCateCode;
    }

    public String getgoodsAdvertisement() {
        return goodsAdvertisement;
    }

    public void setgoodsAdvertisement(String goodsAdvertisement) {
        this.goodsAdvertisement = goodsAdvertisement;
    }

    public String getgoodsDescription() {
        return goodsDescription;
    }

    public void setgoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription;
    }

    public String getgoodsCondition() {
        return goodsCondition;
    }

    public void setgoodsCondition(String goodsCondition) {
        this.goodsCondition = goodsCondition;
    }

    public String getgoodsSaleTime() {
        return goodsSaleTime;
    }

    public void setgoodsSaleTime(String goodsSaleTime) {
        this.goodsSaleTime = goodsSaleTime;
    }

    public String getgoodsStar() {
        return goodsStar;
    }

    public void setgoodsStar(String goodsStar) {
        this.goodsStar = goodsStar;
    }

    public String getgoodsBusiness() {
        return goodsBusiness;
    }

    public void setgoodsBusiness(String goodsBusiness) {
        this.goodsBusiness = goodsBusiness;
    }


    public String getgoodsBusinessCode() {
        return goodsBusinessCode;
    }

    public void setgoodsBusinessCode(String goodsBusinessCode) {
        this.goodsBusinessCode = goodsBusinessCode;
    }


    public String getgoodsIsbn() {
        return goodsIsbn;
    }

    public void setgoodsIsbn(String goodsIsbn) {
        this.goodsIsbn = goodsIsbn;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getgoodsPublisher() {
        return goodsPublisher;
    }

    public void setgoodsPublisher(String goodsPublisher) {
        this.goodsPublisher = goodsPublisher;
    }

    public String getgoodsAuthor() {
        return goodsAuthor;
    }

    public void setgoodsAuthor(String goodsAuthor) {
        this.goodsAuthor = goodsAuthor;
    }

    public String getgoodsVisitNum() {
        return goodsVisitNum;
    }

    public void setgoodsVisitNum(String goodsVisitNum) {
        this.goodsVisitNum = goodsVisitNum;
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


    public int getisDeleted() {
        return isDeleted;
    }

    public void setisDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }


}