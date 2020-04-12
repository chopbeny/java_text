package com.xzsd.pc.goods.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.goods.dao.GoodsDao;
import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @DescriptionDemo 商品实现类
 * @Author 邓嘉豪
 * @Date 2020-03-27
*/
@Service
public class GoodsService {

    @Resource
    private GoodsDao goodsDao;


    /**
     * demo 新增商品
     *
     * @param goodsInfo
     * @return
     * @Author 邓嘉豪
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addGoods(GoodsInfo goodsInfo) {
        // 校验商品是否存在
        int countgoodsAcct = goodsDao.countGoodsId(goodsInfo);
        if (0 != countgoodsAcct) {
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }
        goodsInfo.setgoodsId(StringUtil.getCommonCode(2));
        goodsInfo.setisDeleted(0);
        // 新增用户
        int count = goodsDao.addGoods(goodsInfo);
        if (0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * goods 查询商品列表（分页）
     *
     * @param goodsInfo
     * @return
     * @Author 邓嘉豪
     * @Date 2020-03-26
     */

    public AppResponse listGoods(GoodsInfo goodsInfo) {
        PageHelper.startPage(goodsInfo.getPageNum(), goodsInfo.getPageSize());
        List<GoodsInfo> goodsInfoList = goodsDao.listGoodsByPage(goodsInfo);
        // 包装Page对象
        PageInfo<GoodsInfo> pageData = new PageInfo<GoodsInfo>(goodsInfoList);
        return AppResponse.success("查询成功！", pageData);
    }


    /**
     * goods 修改商品信息
     *
     * @param goodsInfo
     * @return
     * @Author 邓嘉豪
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoods(GoodsInfo goodsInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验商品是否存在
        int countGoodsAcct = goodsDao.countGoodsId(goodsInfo);
        if (0 != countGoodsAcct) {
            return AppResponse.bizError("商品已存在，请重新输入！");
        }
        // 修改状态信息
        int count = goodsDao.updateGoods(goodsInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }


    /**
     * user 删除商品
     *
     * @param goodsId
     * @param goodsid
     * @return
     * @Author 邓嘉豪
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteGoods(String goodsId, String goodsid) {
        List<String> listCode = Arrays.asList(goodsId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除商品
        int count = goodsDao.deleteGoods(listCode, goodsid);
        if (0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }


    /**
     * goods 修改商品状态
     *
     * @param goodsInfo
     * @return
     * @Author 邓嘉豪
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoodsCondition(GoodsInfo goodsInfo) {
        int countGoodsAcct = goodsDao.countGoodsId(goodsInfo);
        if (countGoodsAcct == 0) {
            return AppResponse.bizError("商品不存在，请重新输入");
        } else {
            AppResponse appResponse = AppResponse.success("修改成功");
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }


    }
}
