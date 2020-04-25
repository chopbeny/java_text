package com.xzsd.pc.goodscate.service;


import com.xzsd.pc.goods.dao.GoodsDao;
import com.xzsd.pc.goodscate.dao.GoodsCateDao;
import com.xzsd.pc.goodscate.entity.GoodsCate;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.AuthUtils;
import com.xzsd.pc.util.UUIDUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 商品分类业务处理类
 *
 * @author 邓嘉豪
 * @date 2020-04-13
 */
@Service
public class GoodsCateService {

    @Resource
    private GoodsCateDao goodsCateDao;

    @Resource
    private GoodsDao goodsDao;

    /**
     * 新增商品分类接口
     *
     * @param goodsCate 商品分类信息
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addGoodsCate(GoodsCate goodsCate) {
        //设置UUID为主键
        goodsCate.setGoodsCateId(UUIDUtils.getUUID());
        //设置基本属性
        goodsCate.setCreatePerson(AuthUtils.getCurrentUserId());
        goodsCate.setUpdatePerson(AuthUtils.getCurrentUserId());
        goodsCate.setVersion(1);
        goodsCate.setIsDeleted(1);
        //设置为第一级商品分类
        goodsCate.setCateLevel(1);
        //有父级编号时
        if (goodsCate.getCateParent() != null && !"".equals(goodsCate.getCateParent())) {
            //根据父级编号查询父级商品分类是否存在
            int count = goodsCateDao.countGoodsCateByCateParent(goodsCate.getCateParent());
            //当数据库中不存在该父级编号的商品分类
            if (count == 0) {
                return AppResponse.bizError("父级商品分类信息输入错误");
            }
            //当父级分类存在，表示新增第二级分类
            goodsCate.setCateLevel(2);
        }
        int status = goodsCateDao.insertSelective(goodsCate);
        if (status > 0) {
            return AppResponse.success("新增商品分类成功");
        }
        return AppResponse.bizError("新增商品分类失败");
    }

    /**
     * 查询树形商品分类列表接口
     *
     * @return
     */
    public AppResponse listTreeGoodsCates() {
        return AppResponse.success("查询成功", goodsCateDao.listTreeGoodsCates());
    }

    /**
     * 查询商品分类详情接口
     *
     * @param goodsCateId 商品分类id
     * @return
     */
    public AppResponse findGoodsCateById(String goodsCateId) {
        GoodsCate goodsCate = goodsCateDao.findGoodsCateById(goodsCateId);
        if (goodsCate == null) {
            return AppResponse.bizError("没有该商品分类信息");
        }
        return AppResponse.success("查询成功!", goodsCate);
    }

    /**
     * 修改商品分类详情接口
     *
     * @param goodsCate 商品分类信息
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoodsCateById(GoodsCate goodsCate) {
        //校验数据库中有没有该id的记录
        GoodsCate oldGoodsCate = goodsCateDao.selectByPrimaryKey(goodsCate.getGoodsCateId());
        if (oldGoodsCate == null) {
            return AppResponse.bizError("没有该商品分类信息");
        } else if (!oldGoodsCate.getVersion().equals(goodsCate.getVersion())) {
            return AppResponse.bizError("信息已更新，请重试");
        }
        //设置基本信息
        goodsCate.setUpdatePerson(AuthUtils.getCurrentUserId());
        goodsCate.setVersion(oldGoodsCate.getVersion() + 1);
        int status = goodsCateDao.updateByPrimaryKeySelective(goodsCate);
        if (status > 0) {
            return AppResponse.success("修改商品分类信息成功");
        }
        return AppResponse.bizError("修改商品分类信息失败");
    }

    /**
     * 删除商品分类接口
     *
     * @param goodsCateId 商品分类编号（没有批量删除）
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteGoodsCateById(String goodsCateId) {
        //查询该商品分类是否有子分类
        int goodsCateCount = goodsCateDao.countSonGoodsCateById(goodsCateId);
        //如果有子分类
        if (goodsCateCount > 0) {
            return AppResponse.bizError("该分类还有子分类信息，删除失败");
        }
        //查询该商品分类是否有商品存在
        int goodsCount = goodsDao.countGoodsByGoodsCateCode(goodsCateId);
        if (goodsCount > 0) {
            return AppResponse.bizError("该分类还有商品信息，删除失败");
        }
        //删除商品分类信息列表集合，设置更新人id
        int count = goodsCateDao.deleteGoodsCateById(goodsCateId, AuthUtils.getCurrentUserId());
        //当要删除的门店个数和已删除的门店个数不等时，回滚事物，删除失败
        if (count == 0 ) {
            return AppResponse.bizError("商品分类删除失败");
        }
        return AppResponse.success("商品分类删除成功");
    }

    /**
     * 根据父级编号查询商品分类列表接口
     * @param cateParent 父级商品分类编号
     * @return
     */
    public AppResponse listGoodsCatesByParentCode(String cateParent){
        //当传入的父级编号为空字符串""或者"null"时，设置为null
        if ("".equals(cateParent) || "null".equals(cateParent)) {
            cateParent = null;
        }
        List<GoodsCate> goodsCates = goodsCateDao.listGoodsCatesByParentCode(cateParent);
        return AppResponse.success("查询成功!", goodsCates);
    }

}











