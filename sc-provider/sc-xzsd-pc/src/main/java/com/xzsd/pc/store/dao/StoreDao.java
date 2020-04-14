package com.xzsd.pc.store.dao;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.store.entity.StoreSettingDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @ClassName StoreDao
 * @Description 门店管理
 * @Author 邓嘉豪
 * @Date 2020/4/11
 */
public interface StoreDao {

    /**
     * 新增门店
     * @param storeInfo 用户信息
     * @return
     */
    int addStore(StoreInfo storeInfo);

    /**
     * 获取门店信息
     * @param storeId 用户代码
     * @return 用户信息
     */
    StoreInfo getStore(@Param("storeId") String storeId);

    /**
     * 获取所有门店信息
     * @param storeInfo 用户信息
     * @return 所有用户信息
     */
    List<StoreInfo> listStoresByPage(StoreInfo storeInfo);

    /**
     * 修改门店信息
     * @param storeInfo 用户信息
     * @return 修改结果
     */
    int updateStore(StoreInfo storeInfo);

    /**
     * 删除门店信息
     * @param storeSettingDTO 选中的用户信息
     * @return
     */
    int deleteStore(StoreSettingDTO storeSettingDTO);

    /**
     * 统计门店账号数量
     * @param storeInfo 用户信息
     * @return
     */
    int countStoreAcct(StoreInfo storeInfo);


}
