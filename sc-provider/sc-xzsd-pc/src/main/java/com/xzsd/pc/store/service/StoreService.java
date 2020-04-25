package com.xzsd.pc.store.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.store.dao.StoreDao;
import com.xzsd.pc.store.entity.Store;
import com.xzsd.pc.user.dao.ManagerDao;
import com.xzsd.pc.util.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 门店信息业务处理类
 *
 * @author 邓嘉豪
 * @date 2020-03-29
 */
@Service
public class StoreService {

    @Resource
    private StoreDao storeDao;

    @Resource
    private ManagerDao managerDao;

    /**
     * 新增门店信息接口
     *
     * @param store 门店信息
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addStore(Store store) {
        int count = managerDao.countManagerByManagerId(store.getStoreManagerId());
        //数据库中有该店长的信息
        if (count != 0) {
            //设置UUID为主键
            store.setStoreId(UUIDUtils.getUUID());
            //生成门店邀请码
            //1.先生成6位的随机数
          //  long random = Long.valueOf(StringUtil.getCommonCode(5));
            //2.利用随机数生成邀请码
            String invitationcode = StringUtil.getCommonCode(2);
            //设置门店邀请码
            store.setStoreInvitationCode(invitationcode);
            //添加门店展示编号（年月日时分秒+2位随机数）
            store.setStoreCode(StringUtil.getCommonCode(2));

            //设置基本属性
            store.setCreatePerson(AuthUtils.getCurrentUserId());
            store.setUpdatePerson(AuthUtils.getCurrentUserId());
            store.setVersion(1);
            store.setIsDeleted(1);
            int status = storeDao.insertSelective(store);
            if (status > 0) {
                return AppResponse.success("新增门店信息成功");
            }
            return AppResponse.bizError("新增门店信息失败");
        }
        return AppResponse.bizError("店长编号不存在，新增失败");
    }

    /**
     * 查询门店信息列表接口（分页）
     *
     * @param store       门店信息查询条件
     * @param managerName 店长名称查询条件
     * @return
     */
    public AppResponse listStores(Store store, String managerName) {
        PageHelper.startPage(store.getPageNum(), store.getPageSize());
        List<Store> stores = storeDao.listStores(store, managerName);
        PageInfo<Store> pageData = new PageInfo<Store>(stores);
        return AppResponse.success("查询成功!", pageData);
    }

    /**
     * 查询门店信息详情接口
     *
     * @param storeId 门店id
     * @return
     */
    public AppResponse findStoresById(String storeId) {
        Store store = storeDao.findStoresById(storeId);
        if (store == null) {
            return AppResponse.bizError("没有该门店信息");
        }
        return AppResponse.success("查询成功!", store);
    }

    /**
     * 修改门店信息接口
     *
     * @param store 要修改的门店信息
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateStoreById(Store store) {
        //校验数据库中有没有该id的记录
        Store oldStore = storeDao.selectByPrimaryKey(store.getStoreId());
        if (oldStore == null) {
            return AppResponse.bizError("没有该门店信息");
        } else if (!oldStore.getVersion().equals(store.getVersion())) {
            return AppResponse.bizError("信息已更新，请重试");
        }
        //设置基本信息
        store.setUpdatePerson(AuthUtils.getCurrentUserId());
        store.setVersion(oldStore.getVersion() + 1);

        int status = storeDao.updateByPrimaryKeySelective(store);
        if (status > 0) {
            return AppResponse.success("修改门店信息成功");
        }
        return AppResponse.bizError("修改门店信息失败");
    }

    /**
     * 删除门店信息接口
     *
     * @param storeIds 门店id（批量删除用逗号分开）
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteStoreById(String storeIds) {
        //按照逗号分割门店id
        List<String> listIds = Arrays.asList(storeIds.split(","));
        //删除门店信息列表集合，设置更新人id
        int count = storeDao.deleteStoreById(listIds, AuthUtils.getCurrentUserId());
        //当要删除的门店个数和已删除的门店个数不等时，回滚事物，删除失败
        if (count != listIds.size()) {
            //回滚事物
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return AppResponse.bizError("所选列表有未存在数据，删除失败");
        } else {
            return AppResponse.success("删除成功");
        }
    }

}


















