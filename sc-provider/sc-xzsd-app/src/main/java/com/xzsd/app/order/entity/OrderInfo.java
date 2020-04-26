package com.xzsd.app.order.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class OrderInfo {

    /**
     * 订单编号id
     */
    private String orderId;

    /**
     *商品编号
     */
    private String goodsId;

    /**
     * 商品价格
     */
    private String goodsPrice;

    /**
     * 客户选择的商品数量，与编号对应
     */
    private String clientGoodsNum;

    /**
     * 门店id
     */
    private String storeId;

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

    /**
     * 购物车商品数量
     * @return
     */
    private Integer cartGoodsCount;

    /**
     * 购物车编号
     * @return
     */
    private String shopCartId;

    /**
     * 订单明细类
     */
    private List<OrderDetailsInfo> orderDetailsInfoList;

    /**
     * 商品信息
     */
    private List<OrderDetailsInfo> goodsList;

    /**
     * 订单编号
     * @return
     */
    private String orderCode;

    /**
     * 下订单的客户编号
     */
    private String orderClientCode;

    /**
     * 下单的总价格
     */

    private String orderTotalPrice;

    /**
     * 订单状态
     */

    private String orderCondition;

    /**
     * 门店编号
     */
    private String orderStoreCode;

    /**
     * 订单商品总数目
     */

    private String orderTotalSum;

    /**
     * 订单支付状态
     * @return
     */
    private String OrderPayCondition;

    /**
     * 门店名称
     * @return
     */
    private String storeName;

    /**
     * 门店详细地址
     * @return
     */
    private String storeAddress;


    public List<OrderDetailsInfo> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<OrderDetailsInfo> goodsList) {
        this.goodsList = goodsList;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getClientGoodsNum() {
        return clientGoodsNum;
    }

    public void setClientGoodsNum(String clientGoodsNum) {
        this.clientGoodsNum = clientGoodsNum;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

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

    public Integer getCartGoodsCount() {
        return cartGoodsCount;
    }

    public void setCartGoodsCount(Integer cartGoodsCount) {
        this.cartGoodsCount = cartGoodsCount;
    }

    public String getShopCartId() {
        return shopCartId;
    }

    public void setShopCartId(String shopCartId) {
        this.shopCartId = shopCartId;
    }

    public List<OrderDetailsInfo> getOrderDetailsInfoList() {
        return orderDetailsInfoList;
    }

    public void setOrderDetailsInfoList(List<OrderDetailsInfo> orderDetailsInfoList) {
        this.orderDetailsInfoList = orderDetailsInfoList;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderClientCode() {
        return orderClientCode;
    }

    public void setOrderClientCode(String orderClientCode) {
        this.orderClientCode = orderClientCode;
    }

    public String getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(String orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public String getOrderCondition() {
        return orderCondition;
    }

    public void setOrderCondition(String orderCondition) {
        this.orderCondition = orderCondition;
    }

    public String getOrderStoreCode() {
        return orderStoreCode;
    }

    public void setOrderStoreCode(String orderStoreCode) {
        this.orderStoreCode = orderStoreCode;
    }

    public String getOrderTotalSum() {
        return orderTotalSum;
    }

    public void setOrderTotalSum(String orderTotalSum) {
        this.orderTotalSum = orderTotalSum;
    }

    public String getOrderPayCondition() {
        return OrderPayCondition;
    }

    public void setOrderPayCondition(String orderPayCondition) {
        OrderPayCondition = orderPayCondition;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
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
