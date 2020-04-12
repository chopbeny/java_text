package com.xzsd.pc.rollImage.entity;
import java.util.Date;

/**
 * @Description 首页轮播图实体类
 * @Author 邓嘉豪
 * @Date 2020-03-30
 */
public class RollImageInfo{

    /**
     * 上传的图片文件链接
     */
    private String imageFileUrl;

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
    private int rollImageWeight;

    /**
     * 轮播图的图片对应的商品编号
     */
    private String rollImageGoodsCode;

    /**
     * 轮播图的图片起始时间
     */
    private Date rollImageBeginDate;
    /**
     * 轮播图的图片终止时间
     */
    private Date rollImageEndDate;

    /**
     * 轮播图的图片状态（0：禁用，1：启用）
     */
    private int rollImageCondition;

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
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;


    public String getimageFileUrl(){return imageFileUrl;}
    public void setimageFileUrl(String imageFileUrl){this.imageFileUrl = imageFileUrl;}

    public String getrollImageId(){return rollImageId;}
    public void setrollImageId(String rollImageId){this.rollImageId = rollImageId;}

    public String getrollImageCode(){return rollImageCode;}
    public void setrollImageCode(String rollImageCode){this.rollImageCode = rollImageCode;}

    public int getrollImageWeight(){return rollImageWeight;}
    public void setrollImageWeight(int rollImageWeight){this.rollImageWeight = rollImageWeight;}

    public String getrollImageGoodsCode(){return rollImageGoodsCode;}
    public void setrollImageGoodsCode(String rollImageGoodsCode){this.rollImageGoodsCode = rollImageGoodsCode;}


    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() { return pageNum; }
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
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

    public String getVersion(){return version;}
    public void setVersion(String version){this.version = version;}

    public Date getrollImageBeginDate(){return rollImageBeginDate;}
    public void setrollImageBeginDate(Date rollImageBeginDate){this.rollImageBeginDate = rollImageBeginDate;}

    public Date getrollImageEndDate(){return rollImageEndDate;}
    public void setrollImageEndDate(Date rollImageEndDate){this.rollImageEndDate = rollImageEndDate;}



    public int getrollImageCondition() {
        return rollImageCondition;
    }
    public void setrollImageCondition(int rollImageCondition) {
        this.rollImageCondition = rollImageCondition;
    }



}
