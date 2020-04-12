package com.xzsd.pc.menu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * 描述：略
 * 作成者：邓嘉豪
 * 作成时间：2020/4/11
 */

public class Menu {
    /**
     * 菜单id
     */
    private String menuId;
    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单介绍
     */
    private String menuComment;
    /**
     * 菜单父级编号
     */
    private String menuParent;
    /**
     * 菜单路由
     */
    private String menuRoute;
    /**
     * 是否菜单
     */
    private String isMenu;

    /**
     * 是否删除(0：没删除，1删除）
     */
    private int isDeleted;

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
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;

    public String getmenuId() {
        return menuId;
    }

    public void setmenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getmenuComment() {
        return menuComment;
    }

    public void setmenuComment(String menuComment) {
        this.menuComment = menuComment;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getmenuParent() {
        return menuParent;
    }

    public void setmenuParent(String menuParent) {
        this.menuParent = menuParent;
    }

    public String getmenuRoute() {
        return menuRoute;
    }

    public void setmenuRoute(String menuRoute) {
        this.menuRoute = menuRoute;
    }

    public String getisMenu() {
        return isMenu;
    }

    public void setisMenu(String isMenu) {
        this.isMenu = isMenu;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getisDeleted() {
        return isDeleted;
    }

    public void setisDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

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


}
