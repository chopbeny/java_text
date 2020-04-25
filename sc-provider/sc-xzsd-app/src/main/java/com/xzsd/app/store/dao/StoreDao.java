package com.xzsd.app.store.dao;

import org.apache.ibatis.annotations.Param;

/**
 * StoreDao
 * 邓嘉豪
 * 2020-04-04 21:40
 */
public interface StoreDao {
    /**
     * 通过邀请码查询门店编号是否存在
     * 邓嘉豪
     * 2020-04-13 10:35
     */
    String StoreIdByInviteCode(@Param("newInviteCode") String newInviteCode);
}
