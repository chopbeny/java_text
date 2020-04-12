package com.xzsd.pc.goodsCate.entity;
import java.util.Date;

/**
 * @Description 商品分类实体类
 * @Author 邓嘉豪
 * @Date 2020-03-30
 */

public class GoodsCateInfo {
    /**
     * 商品分类唯一标识
     */
    private String cateId;

    /**
     * 商品分类名称
     */
    private String cateName;

    /**
     * 类别层级
     */
    private int cateLevel;

    /**
     * 父级编号
     */
    private String cateParentCode;

    /**
     * 备注信息
     */
    private String cateComment;

    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;

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



    public String getCateId(){return cateId;}
    public void setCateId(String cateId){this.cateId = cateId;}

    public String getCateName(){return cateName;}
    public void setCateName(String cateName){this.cateName = cateName;}

    public String getCateParentCode(){return cateParentCode;}
    public void setCateParentCode(String cateParentCode){this.cateParentCode = cateParentCode;}

    public String getCateComment(){return cateComment;}
    public void setCateComment(String cateComment){this.cateComment = cateComment;}

    public int getCateLevel(){return cateLevel;}
    public void setCateLevel(int cateLevel){this.cateLevel = cateLevel;}

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



}
