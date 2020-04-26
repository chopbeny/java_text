package com.xzsd.app.order.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 订单明细实体类
 *
 * @author 邓嘉豪
 * @date 2020-03-27
 */
public class OrderDetailsInfo{
    /**
     * 订单明细唯一标识，主键
     */
    private String orderDetailId;
    /**
     * 该明细所属的订单编号
     */
    private String orderDetailOrderCode;
    /**
     * 该明细中包含的商品编号
     */
    private String orderDetailGoodsCode;
    /**
     * 该明细中购买商品的总数量
     */
    private String orderDetailGoodsNum;
    /**
     * 该明细中购买商品的总价格
     */
    private String orderDetailGoodsTotalPrice;
    /**
     * 该明细中购买商品的售价
     */
    private String orderDetailGoodsSalePrice;
    /**
     * 该明细中购买商品的定价
     */
    private String orderDetailGoodsFixPrice;
    /**
     * 该明细中购买商品的名称
     */
    private String orderDetailGoodsName;
    /**
     * 该明细中购买商品的展示编号
     */
    private String orderDetailGoodsDisplayCode;

    //-----------------关联关系-----------------

    /**
     * 用户展示的编号（年月日时分秒+2位随机数）
     */
    private String userCode;



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
     * 商品描述
     */
    private String goodsDescription;


    /**
     * 商品图片路径
     * @return
     */

    private String goodsImagePath;


    /**
     * 订单状态
     * @return
     */
    private String orderCondition;


    public String getOrderCondition() {
        return orderCondition;
    }

    public void setOrderCondition(String orderCondition) {
        this.orderCondition = orderCondition;
    }

    public String getGoodsDescription() {
        return goodsDescription;
    }

    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription;
    }

    public String getGoodsImagePath() {
        return goodsImagePath;
    }

    public void setGoodsImagePath(String goodsImagePath) {
        this.goodsImagePath = goodsImagePath;
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


    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(String orderDetailId) {
        this.orderDetailId = orderDetailId == null ? null : orderDetailId.trim();
    }

    public String getOrderDetailOrderCode() {
        return orderDetailOrderCode;
    }

    public void setOrderDetailOrderCode(String orderDetailOrderCode) {
        this.orderDetailOrderCode = orderDetailOrderCode == null ? null : orderDetailOrderCode.trim();
    }

    public String getOrderDetailGoodsCode() {
        return orderDetailGoodsCode;
    }

    public void setOrderDetailGoodsCode(String orderDetailGoodsCode) {
        this.orderDetailGoodsCode = orderDetailGoodsCode == null ? null : orderDetailGoodsCode.trim();
    }

    public String getOrderDetailGoodsNum() {
        return orderDetailGoodsNum;
    }

    public void setOrderDetailGoodsNum(String orderDetailGoodsNum) {
        this.orderDetailGoodsNum = orderDetailGoodsNum;
    }

    public String getOrderDetailGoodsTotalPrice() {
        return orderDetailGoodsTotalPrice;
    }

    public void setOrderDetailGoodsTotalPrice(String orderDetailGoodsTotalPrice) {
        this.orderDetailGoodsTotalPrice = orderDetailGoodsTotalPrice;
    }

    public String getOrderDetailGoodsSalePrice() {
        return orderDetailGoodsSalePrice;
    }

    public void setOrderDetailGoodsSalePrice(String orderDetailGoodsSalePrice) {
        this.orderDetailGoodsSalePrice = orderDetailGoodsSalePrice;
    }

    public String getOrderDetailGoodsFixPrice() {
        return orderDetailGoodsFixPrice;
    }

    public void setOrderDetailGoodsFixPrice(String orderDetailGoodsFixPrice) {
        this.orderDetailGoodsFixPrice = orderDetailGoodsFixPrice;
    }

    public String getOrderDetailGoodsName() {
        return orderDetailGoodsName;
    }

    public void setOrderDetailGoodsName(String orderDetailGoodsName) {
        this.orderDetailGoodsName = orderDetailGoodsName == null ? null : orderDetailGoodsName.trim();
    }

    public String getOrderDetailGoodsDisplayCode() {
        return orderDetailGoodsDisplayCode;
    }

    public void setOrderDetailGoodsDisplayCode(String orderDetailGoodsDisplayCode) {
        this.orderDetailGoodsDisplayCode = orderDetailGoodsDisplayCode == null ? null : orderDetailGoodsDisplayCode.trim();
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