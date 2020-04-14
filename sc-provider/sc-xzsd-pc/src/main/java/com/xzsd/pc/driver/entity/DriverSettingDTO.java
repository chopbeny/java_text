package com.xzsd.pc.driver.entity;

import java.util.List;

/**
 * @ClassName DriverSettingDTO
 * @Description 司机管理
 * @Author 邓嘉豪
 * @Date 2020-4-14
 */
public class DriverSettingDTO {
    private String postName;
    private String userCode;
    private List<String> roleList;
    private List<String> userList;
    private List<String> deptList;
    private List<String> menuList;
    private List<String> driverList;
    private String startTime;
    private String endTime;
    private String createBy;
    private String lastModifiedBy;
    private List<String> postInfoList;
    private List<String> postList;

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public List<String> getdriverList() {
        return driverList;
    }

    public void setdriverList(List<String> driverList) {
        this.driverList = driverList;
    }


    public List<String> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<String> roleList) {
        this.roleList = roleList;
    }

    public List<String> getUserList() {
        return userList;
    }

    public void setUserList(List<String> userList) {
        this.userList = userList;
    }

    public List<String> getDeptList() {
        return deptList;
    }

    public void setDeptList(List<String> deptList) {
        this.deptList = deptList;
    }

    public List<String> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<String> menuList) {
        this.menuList = menuList;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public List<String> getPostInfoList() {
        return postInfoList;
    }

    public void setPostInfoList(List<String> postInfoList) {
        this.postInfoList = postInfoList;
    }

    public List<String> getPostList() {
        return postList;
    }

    public void setPostList(List<String> postList) {
        this.postList = postList;
    }
}
