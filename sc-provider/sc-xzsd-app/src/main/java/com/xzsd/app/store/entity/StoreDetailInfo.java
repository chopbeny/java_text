package com.xzsd.app.store.entity;

public class StoreDetailInfo {


    /**
     * 订单明细商品编号
     */
    private String orderDetailGoodsCode;

    /**
     * 订单明细商品价格
     */
    private String orderDetailGoodsSalePrice;

    /**
     * 商品名称
     */
    private String orderDetailGoodsName;

    /**
     * 图片路径
     */
    private String goodsImagePath;


    /**
     * 订单明细商品总数目
     */
    private String orderDetailGoodsNum;

    /**
     * 商品描述
     */

    private String goodsDescription;

    /**
     * 订单对应的门店
     */
    private String orderStoreCode;

    /**
     * 页数，默认为第1页
     */
    private int pageNum = 1;
    /**
     * 页码，默认为一页10条
     */
    private int pageSize = 10;

    /**
     * 订单状态
     * @return
     */
    private String orderCondition;


    public String getOrderStoreCode() {
        return orderStoreCode;
    }

    public void setOrderStoreCode(String orderStoreCode) {
        this.orderStoreCode = orderStoreCode;
    }

    public String getOrderDetailGoodsCode() {
        return orderDetailGoodsCode;
    }

    public void setOrderDetailGoodsCode(String orderDetailGoodsCode) {
        this.orderDetailGoodsCode = orderDetailGoodsCode;
    }

    public String getOrderDetailGoodsSalePrice() {
        return orderDetailGoodsSalePrice;
    }

    public void setOrderDetailGoodsSalePrice(String orderDetailGoodsSalePrice) {
        this.orderDetailGoodsSalePrice = orderDetailGoodsSalePrice;
    }

    public String getOrderDetailGoodsName() {
        return orderDetailGoodsName;
    }

    public void setOrderDetailGoodsName(String orderDetailGoodsName) {
        this.orderDetailGoodsName = orderDetailGoodsName;
    }

    public String getGoodsImagePath() {
        return goodsImagePath;
    }

    public void setGoodsImagePath(String goodsImagePath) {
        this.goodsImagePath = goodsImagePath;
    }

    public String getOrderDetailGoodsNum() {
        return orderDetailGoodsNum;
    }

    public void setOrderDetailGoodsNum(String orderDetailGoodsNum) {
        this.orderDetailGoodsNum = orderDetailGoodsNum;
    }

    public String getGoodsDescription() {
        return goodsDescription;
    }

    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderCondition() {
        return orderCondition;
    }

    public void setOrderCondition(String orderCondition) {
        this.orderCondition = orderCondition;
    }
}




