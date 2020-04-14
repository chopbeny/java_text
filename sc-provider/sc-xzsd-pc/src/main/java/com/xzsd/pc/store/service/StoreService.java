package com.xzsd.pc.store.service;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.store.dao.StoreDao;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.store.entity.StoreSettingDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;
/**
 * @ClassName UserService
 * @Description 用户管理
 * @Author 邓嘉豪
 * @Date 2020/4/11
 */
@Service

public class StoreService {

    @Resource
    private StoreDao storeDao;

    /**
     * 功能：新增门店
     * 描述：略
     * 作成者：邓嘉豪
     * 作成时间：2020/4/11
     */

    @Transactional(rollbackFor = Exception.class)
    public AppResponse addStore(StoreInfo storeInfo) {

        // 校验门店账号是否存在
        int countStoreAcct = storeDao.countStoreAcct(storeInfo);
        if(0 != countStoreAcct) {
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }
        storeInfo.setstoreId(StringUtil.getCommonCode(2));
        storeInfo.setisDeleted(0);
        storeInfo.setVersion(0);
        // 新增用户
        int count = storeDao.addStore(storeInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }


    /**
     * 功能：获取门店列表
     * 描述：略
     * 作成者：邓嘉豪
     * 作成时间：2020/4/11
     */

    public AppResponse listStores(StoreInfo storeInfo) {
        List<StoreInfo> storeInfoList = storeDao.listStoresByPage(storeInfo);
        return AppResponse.success("查询成功！", getPageInfo(storeInfoList));
    }


    /**
     * 通过门店代码查找用户
     *作者：邓嘉豪
     * @param storeId 用户代码
     * @return 用户信息
     */
    public StoreInfo getStore(String storeId) {
        return storeDao.getStore(storeId);
    }


    /**
     * 功能：修改门店信息
     * 描述：略
     * 作成者：邓嘉豪
     * 作成时间：2020/4/11
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateStore(StoreInfo storeInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验门店是否存在
        int countStoreAcct = storeDao.countStoreAcct(storeInfo);
        if(0 != countStoreAcct) {
            return AppResponse.bizError("门店账号已存在，请重新输入！");
        }
        // 修改用户信息
        int count = storeDao.updateStore(storeInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        // 新增用部门
        return appResponse;
    }

    /*
     * user 删除门店
     * @param storeId
     * @param storeid
     * @return
     * @Author 邓嘉豪
     * @Date 2020-03-26

     */

    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteStore(StoreSettingDTO storeSettingDTO) {
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除用户
        int count = storeDao.deleteStore(storeSettingDTO);
        if(0 == count) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();// 回滚
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }


}
