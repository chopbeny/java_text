package com.xzsd.app.store.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xzsd.app.order.entity.OrderDetailsInfo;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class StoreInfo {

    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 电话
     */
    private String phone;
    /**
     * 订单状态
     */

    private String orderCondition;
    /**
     * 商品详情信息
     */

    private List<StoreDetailInfo> StoreOrderList;


    /**
     * 店长商品详情信息
     */
    private List<StoreDetailInfo> managerOrderDetailsInfoList;
    /**
     * 所下订单店铺编号
     */
    private String orderStoreCode;

    /**
     * 下单人id
     */

    private String orderClientCode;

    /**
     * 订单总价
     */
    private String orderTotalPrice;

    /**
     * 订单总价
     */
    private String orderTotalSum;

    /**
     * 版本
     */
    private String version;


    /**
     * 页数，默认为第1页
     */
    private int pageNum = 1;
    /**
     * 页码，默认为一页10条
     */
    private int pageSize = 10;



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
     * 判断该记录是否还可用（0：不可用，1：可用）
     */
    private Integer isDeleted;

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

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOrderCondition() {
        return orderCondition;
    }

    public void setOrderCondition(String orderCondition) {
        this.orderCondition = orderCondition;
    }

    public List<StoreDetailInfo> getStoreOrderList() {
        return StoreOrderList;
    }

    public void setStoreOrderList(List<StoreDetailInfo> storeOrderList) {
        StoreOrderList = storeOrderList;
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

    public String getOrderTotalSum() {
        return orderTotalSum;
    }

    public void setOrderTotalSum(String orderTotalSum) {
        this.orderTotalSum = orderTotalSum;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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

    public String getOrderStoreCode() {
        return orderStoreCode;
    }

    public void setOrderStoreCode(String orderStoreCode) {
        this.orderStoreCode = orderStoreCode;
    }


    public List<StoreDetailInfo> getManagerOrderDetailsInfoList() {
        return managerOrderDetailsInfoList;
    }

    public void setManagerOrderDetailsInfoList(List<StoreDetailInfo> managerOrderDetailsInfoList) {
        this.managerOrderDetailsInfoList = managerOrderDetailsInfoList;
    }
}
