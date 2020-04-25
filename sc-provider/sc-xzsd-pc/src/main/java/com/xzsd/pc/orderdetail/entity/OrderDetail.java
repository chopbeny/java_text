package com.xzsd.pc.orderdetail.entity;

/**
 * 订单明细实体类
 * 继承BaseEntity获取公有属性
 *
 * @author 邓嘉豪
 * @date 2020-03-27
 */
public class OrderDetail{
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

    //-----------------get和set方法-----------------


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
}