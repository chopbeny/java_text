package com.xzsd.pc.hotgoods.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.dict.dao.DictDao;
import com.xzsd.pc.dict.entity.Dict;
import com.xzsd.pc.goods.entity.Goods;
import com.xzsd.pc.hotgoods.dao.HotGoodsDao;
import com.xzsd.pc.hotgoods.entity.HotGoods;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.AuthUtils;
import com.xzsd.pc.util.UUIDUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 热门位商品业务处理类
 *
 * @author 邓嘉豪
 * @date 2020-04-16
 */
@Service
public class HotGoodsService {

    @Resource
    private HotGoodsDao hotGoodsDao;

    @Resource
    private DictDao dictDao;

    /**
     * 新增热门位商品接口
     *
     * @param hotGoods 热门位商品信息
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addHotGoods(HotGoods hotGoods) {
        //检查是否存在相同商品的热门位
        int count = hotGoodsDao.countHotGoodsByGoodsCode(hotGoods.getHotGoodsGoodsCode());
        if (count > 0) {
            return AppResponse.bizError("已经存在该商品的热门位，新增失败");
        }
        //校验商品排序是否存在
        if (hotGoods.getHotGoodsWeight() < 0) {
            return AppResponse.bizError("排序小于0");
        }
        //查询是否有相同排序的轮播图
        int weightCount = hotGoodsDao.countHotGoodsByWeight(hotGoods.getHotGoodsWeight());
        if (weightCount > 0) {
            return AppResponse.bizError("排序已存在，新增失败");
        }
        //设置UUID为主键
        hotGoods.setHotGoodsId(UUIDUtils.getUUID());
        //设置基本属性
        hotGoods.setCreatePerson(AuthUtils.getCurrentUserId());
        hotGoods.setUpdatePerson(AuthUtils.getCurrentUserId());
        hotGoods.setVersion(1);
        hotGoods.setIsDeleted(1);
        int status = hotGoodsDao.insertSelective(hotGoods);
        if (status > 0) {
            return AppResponse.success("新增热门位商品信息成功");
        }
        return AppResponse.bizError("新增热门位商品信息失败");
    }

    /**
     * 查询热门位商品列表接口
     *
     * @param goods    要查询的商品信息
     * @return
     */
    public AppResponse listHotGoods(HotGoods hotGoods, Goods goods) {
        PageHelper.startPage(hotGoods.getPageNum(), hotGoods.getPageSize());
        List<HotGoods> hotGoodsList = hotGoodsDao.listHotGoods(goods);
        PageInfo<HotGoods> pageData = new PageInfo<HotGoods>(hotGoodsList);
        return AppResponse.success("查询成功!", pageData);
    }

    /**
     * 修改热门位商品接口
     *
     * @param hotGoods 要修改的热门商品信息
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateHotGoodsById(HotGoods hotGoods) {
        //检查是否存在相同商品的热门位
        int count = hotGoodsDao.countHotGoodsSelfByGoodsCode(hotGoods);
        if (count > 0) {
            return AppResponse.bizError("已经存在该商品的热门位，新增失败");
        }
        //校验商品排序是否存在
        if (hotGoods.getHotGoodsWeight() < 0) {
            return AppResponse.bizError("排序小于0");
        }
        //查询是否有相同排序的轮播图
        int weightCount = hotGoodsDao.countHotGoodsSelfByWeight(hotGoods);
        if (weightCount > 0) {
            return AppResponse.bizError("排序已存在，新增失败");
        }
        //检验该热门位编号的热门位商品是否存在
        HotGoods oldHotGoods = hotGoodsDao.selectByPrimaryKey(hotGoods.getHotGoodsId());
        if (oldHotGoods == null) {
            return AppResponse.bizError("该热门位商品不存在，修改失败");
        } else if (!oldHotGoods.getVersion().equals(hotGoods.getVersion())) {
            return AppResponse.bizError("信息已更新，请重试");
        }
        //设置基本属性
        hotGoods.setCreatePerson(AuthUtils.getCurrentUserId());
        hotGoods.setUpdatePerson(AuthUtils.getCurrentUserId());
        hotGoods.setVersion(oldHotGoods.getVersion() + 1);
        hotGoods.setIsDeleted(1);

        int status = hotGoodsDao.updateByPrimaryKeySelective(hotGoods);
        if (status > 0) {
            return AppResponse.success("热门位商品信息修改成功");
        }
        return AppResponse.bizError("热门位商品信息修改失败");
    }

    /**
     * 删除热门位商品接口
     *
     * @param hotGoodsIds 热门位商品编号（批量删除用逗号分开）
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteHotGoodsById(String hotGoodsIds) {
        List<String> listIds = Arrays.asList(hotGoodsIds.split(","));
        //删除热门位商品信息列表集合，设置更新人id
        int count = hotGoodsDao.deleteHotGoodsById(listIds, AuthUtils.getCurrentUserId());
        //当要删除的热门位总数和已删除的总数不等时，回滚事物，删除失败
        if (count != listIds.size()) {
            //回滚事物
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return AppResponse.bizError("所选列表有未存在数据，删除失败");
        }
        return AppResponse.success("删除成功");
    }

    /**
     * 查询热门位商品展示数量接口
     *
     * @return
     */
    public AppResponse findDisplayNum() {
        Dict dict = dictDao.selectDictByKey("hotGoodsDisplayNum");
        return AppResponse.success("查询成功", dict);
    }

    /**
     * 修改热门位商品展示数量接口
     *
     * @param dict 要修改的字典信息
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateDisplayNum(Dict dict) {
        if(Integer.parseInt(dict.getDictValue()) <= 0){
            return AppResponse.bizError("展示数量需要大于0");
        }
        int status = dictDao.updateDictByKey(dict, AuthUtils.getCurrentUserId());
        if (status > 0){
            return AppResponse.success("热门商品展示数量修改成功");
        }
        return AppResponse.bizError("热门商品展示数量修改失败");
    }




    /**
     * 查询商品列表接口
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param goods    查询商品信息条件
     * @return
     */

    public AppResponse listAllGoods(Goods goods) {
        PageHelper.startPage(goods.getPageNum(), goods.getPageSize());
        List<Goods> goodses = hotGoodsDao.listAllGoods(goods);
        PageInfo<Goods> pageData = new PageInfo<Goods>(goodses);
        return AppResponse.success("查询成功!", pageData);
    }




}











