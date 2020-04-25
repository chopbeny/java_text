package com.xzsd.app.goods.entity;


import java.util.Date;
import java.util.List;

/**
 * 商品信息实体类
 * 继承BaseEntity获取公有属性
 *
 * @author 邓嘉豪
 * @date 2020-03-27
 */
public class GoodsInfo {

    /**
     * 商品图片的路径
     */
    private String goodsImagePath;
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

    /**
     * 门店名称
     */
    private String storeName;

    /**
     * 每个客户对应的门店编号（其他角色没有该值）
     */
    private String inviteCode;

    /**
     * 商品等级
     * @return
     */
    private int evaluateScore;

    /**
     *用户账号
     * @return
     */
    private String userAcct;

    /**
     * 评价内容
     * @return
     */

    private String evaluateContent;
    /**
     * 评价时间
     */
    private String createTime;


    /**
     * 一级分类编号
     * @return
     */
    private String classifyId;

    /**
     * 一级分类名称
     * @return
     */

    private String classifyName;

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
     * 商品分类列表
     * @return
     */
    private List<GoodsInfo> goodsList;

    /**
     * 商品分类编号
     * @return
     */

    private String goodsCateId;



    //-----------------get和set方法-----------------

    public String getgoodsCateId() {
        return goodsCateId;
    }

    public void setgoodsCateId(String goodsCateId) {
        this.goodsCateId = goodsCateId;
    }


    public List<GoodsInfo> getgoodsList() {
        return goodsList;
    }

    public void setgoodsList(List<GoodsInfo> goodsList) {
        this.goodsList = goodsList;
    }


    public String getsecondGoodsCateCode() {
        return secondGoodsCateCode;
    }

    public void setsecondGoodsCateCode(String secondGoodsCateCode) {
        this.secondGoodsCateCode = secondGoodsCateCode;
    }

    public String getsecondGoodsCateName() {
        return secondGoodsCateName;
    }

    public void setsecondGoodsCateName(String secondGoodsCateName) {
        this.secondGoodsCateName = secondGoodsCateName;
    }



    public String getclassifyId() {
        return classifyId;
    }

    public void setclassifyId(String classifyId) {
        this.classifyId = classifyId;
    }

    public String getclassifyName() {
        return classifyName;
    }

    public void setclassifyName(String classifyName) {
        this.classifyName = classifyName;
    }



    public String getevaluateContent() {
        return evaluateContent;
    }

    public void setevaluateContent(String evaluateContent) {
        this.evaluateContent = evaluateContent;
    }

    public String getcreateTime() {
        return createTime;
    }

    public void setcreateTime(String createTime) {
        this.createTime = createTime;
    }


    public int getevaluateScore() {
        return evaluateScore;
    }

    public void setevaluateScore(int evaluateScore) {
        this.evaluateScore = evaluateScore;
    }

    public String getuserAcct() {
        return userAcct;
    }

    public void setuserAcct(String userAcct) {
        this.userAcct = userAcct;
    }

    public String getinviteCode() {
        return inviteCode;
    }

    public void setinviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public String getstoreName() {
        return storeName;
    }

    public void setstoreName(String storeName) {
        this.storeName = storeName;
    }


    public String getgoodsImagePath() {
        return goodsImagePath;
    }

    public void setgoodsImagePath(String goodsImagePath) {
        this.goodsImagePath = goodsImagePath;
    }


    public String getimageId() {
        return imageId;
    }

    public void setimageId(String imageId) {
        this.imageId = imageId;
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
