package com.xzsd.pc.goods.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.xzsd.pc.goodscate.entity.GoodsCate;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 商品信息实体类
 * 继承BaseEntity获取公有属性
 *
 * @author 邓嘉豪
 * @date 2020-03-27
 */
public class Goods{
    /**
     * 商品图片id
     */
        private String imageId;
    /**
     * 分类编号
     */
    private String goodsCateCode;
    /**
     * 商品唯一标识，主键
     */
    private String goodsId;
    /**
     * 用于展示商品的编号（年月日时分秒+2位随机数）
     */
    private String goodsCode;
    /**
     * 商品的名称
     */
    private String goodsName;
    /**
     * 商品的定价
     */
    private String goodsFixPrice;
    /**
     * 商品的销售价格
     */
    private String goodsSalePrice;
    /**
     * 商品的现有库存数量
     */
    private int goodsStock;
    /**
     * 商品已经销售的数量
     */
    private String goodsSaleSum;

    /**
     * 商品的广告词介绍
     */
    private String goodsAdvertisement;
    /**
     * 商品的详细介绍
     */
    private String goodsDescription;
    /**
     * 商品的销售状态（0：未发布，1：在售，2：已下架，3：库存不足）
     */
    private String goodsCondition;
    /**
     * 商品的上架时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date goodsSaleTime;
    /**
     * 商品总的访问量
     */
    private String goodsVisitNum;
    /**
     * 商品的供应商名称
     */
    private String goodsBusiness;
    /**
     * 商品的isbn编号
     */
    private String goodsIsbn;
    /**
     * 商品的出版社
     */
    private String goodsPublisher;
    /**
     * 商品的作者
     */
    private String goodsAuthor;
    /**
     * 商品的评价星级（1：一星，2：两星，3：三星，4：四星，5：五星）
     */
    private String goodsStar;


    //-----------------关联关系-----------------

    /**
     * 一个商品关联一个二级商品分类，一对一
     * （二级分类关联一个一级分类，一对一）
     * 一个商品有第一级、第二级分类
     */
    private GoodsCate goodsCate;
    /**
     * 商品对应的二级分类名称
     */
    private String secondGoodsCateCode;
    /**
     * 商品对应的一级分类名称
     */
    private String firstGoodsCateCode;


    private String firstGoodsCateName;

    private String secondGoodsCateName;




    private String cateName;

    //-----------------get和set方法-----------------

    public String getfirstGoodsCateName() {
        return firstGoodsCateName;
    }

    public void setfirstGoodsCateName(String firstGoodsCateName) {
        this.firstGoodsCateName = firstGoodsCateName;
    }

    public String getsecondGoodsCateName() {
        return secondGoodsCateName;
    }

    public void setsecondGoodsCateName(String secondGoodsCateName) {
        this.secondGoodsCateName = secondGoodsCateName;
    }


    public String getimageId() {
        return imageId;
    }

    public void setimageId(String imageId) {
        this.imageId = imageId;
    }




    public String getsecondGoodsCateCode() {
        return secondGoodsCateCode;
    }

    public void setsecondGoodsCateCode(String secondGoodsCateCode) {
        this.secondGoodsCateCode = secondGoodsCateCode;
    }

    public String getfirstGoodsCateCode() {
        return firstGoodsCateCode;
    }

    public void setfirstGoodsCateCode(String firstGoodsCateCode) {
        this.firstGoodsCateCode = firstGoodsCateCode;
    }


    public GoodsCate getGoodsCate() {
        return goodsCate;
    }

    public void setGoodsCate(GoodsCate goodsCate) {
        this.goodsCate = goodsCate;
    }


    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode == null ? null : goodsCode.trim();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsFixPrice() {
        return goodsFixPrice;
    }

    public void setGoodsFixPrice(String goodsFixPrice) {
        this.goodsFixPrice = goodsFixPrice;
    }

    public String getGoodsSalePrice() {
        return goodsSalePrice;
    }

    public void setGoodsSalePrice(String goodsSalePrice) {
        this.goodsSalePrice = goodsSalePrice;
    }

    public int getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(int goodsStock) {
        this.goodsStock = goodsStock;
    }

    public String getGoodsSaleSum() {
        return goodsSaleSum;
    }

    public void setGoodsSaleSum(String goodsSaleSum) {
        this.goodsSaleSum = goodsSaleSum;
    }



    public String getGoodsAdvertisement() {
        return goodsAdvertisement;
    }

    public void setGoodsAdvertisement(String goodsAdvertisement) {
        this.goodsAdvertisement = goodsAdvertisement == null ? null : goodsAdvertisement.trim();
    }

    public String getGoodsDescription() {
        return goodsDescription;
    }

    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription == null ? null : goodsDescription.trim();
    }

    public String getGoodsCondition() {
        return goodsCondition;
    }

    public void setGoodsCondition(String goodsCondition) {
        this.goodsCondition = goodsCondition;
    }

    public Date getGoodsSaleTime() {
        return goodsSaleTime;
    }

    public void setGoodsSaleTime(Date goodsSaleTime) {
        this.goodsSaleTime = goodsSaleTime;
    }

    public String getGoodsVisitNum() {
        return goodsVisitNum;
    }

    public void setGoodsVisitNum(String goodsVisitNum) {
        this.goodsVisitNum = goodsVisitNum;
    }

    public String getGoodsBusiness() {
        return goodsBusiness;
    }

    public void setGoodsBusiness(String goodsBusiness) {
        this.goodsBusiness = goodsBusiness == null ? null : goodsBusiness.trim();
    }

    public String getGoodsIsbn() {
        return goodsIsbn;
    }

    public void setGoodsIsbn(String goodsIsbn) {
        this.goodsIsbn = goodsIsbn == null ? null : goodsIsbn.trim();
    }

    public String getGoodsPublisher() {
        return goodsPublisher;
    }

    public void setGoodsPublisher(String goodsPublisher) {
        this.goodsPublisher = goodsPublisher == null ? null : goodsPublisher.trim();
    }

    public String getGoodsAuthor() {
        return goodsAuthor;
    }

    public void setGoodsAuthor(String goodsAuthor) {
        this.goodsAuthor = goodsAuthor == null ? null : goodsAuthor.trim();
    }

    public String getgoodsCateCode() {
        return goodsCateCode;
    }

    public void setgoodsCateCode(String goodsCateCode) {
        this.goodsCateCode = goodsCateCode;
    }

    public String getGoodsStar() {
        return goodsStar;
    }

    public void setGoodsStar(String goodsStar) {
        this.goodsStar = goodsStar;
    }

    public String getcateName() {
        return cateName;
    }

    public void setcateName(String cateName) {
        this.cateName = cateName;
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