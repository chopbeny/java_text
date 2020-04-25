package com.xzsd.app.driver.entity;

/**
 * 司机信息实体类

 *
 * @author 邓嘉豪
 * @date 2020-03-27
 */
public class Driver {
    /**
     * 门店编号
     */
    private String storeCode;

    /**
     * 门店名称
     */
    private String storeName;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 门店地址
     */
    private String address;

    /**
     * 店长电话
     */

    private String phone;


    //-----------------get和set方法-----------------




    public String getstoreCode() {
        return storeCode;
    }

    public void setstoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getstoreName() {
        return storeName;
    }

    public void setstoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
        this.phone = phone;
    }


    public String getuserName() {
        return userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;
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
