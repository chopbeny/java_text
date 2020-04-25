package com.xzsd.app.goods.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.app.goods.dao.GoodsDao;
import com.xzsd.app.goods.entity.GoodsCate;
import com.xzsd.app.goods.entity.GoodsInfo;
import com.xzsd.app.user.dao.UserDao;
import com.xzsd.app.user.entity.User;
import com.xzsd.app.util.AppResponse;
import com.xzsd.app.util.AuthUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.bind.SchemaOutputResolver;
import java.util.List;

/**
 * 商品信息业务处理类
 *
 * @author 邓嘉豪
 * @date 2020-04-13
 */
@Service
public class GoodsService {


    @Resource
    private GoodsDao goodsDao;

    @Resource
    private UserDao userDao;

    /**
     * 查询商品详情接口
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param goodsId    查询商品信息条件
     * @return
     */
    public GoodsInfo getGoods(String goodsId, GoodsInfo goodsInfo) {
        //获取当前登录人id
        String userId = AuthUtils.getCurrentGoodsUserId();
        //获取当前登录人信息
        User loginDetail = userDao.selectByPrimaryKey(userId);
        //获取用户邀请码
       // goodsInfo.setinviteCode(loginDetail.getinviteCode());
        String invite = loginDetail.getinviteCode();
        System.out.println(invite);
        System.out.println("123456");
        GoodsInfo goodsManage = goodsDao.selectByPrimaryKey(goodsId,invite,goodsInfo);
        return goodsManage;

    }


    /**
     * 查询商品列表接口
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param goodsInfo    查询商品信息条件
     * @return
     */
    public AppResponse listAllGoods(GoodsInfo goodsInfo) {
        PageHelper.startPage(goodsInfo.getPageNum(), goodsInfo.getPageSize());
        List<GoodsInfo> goodses = goodsDao.listAllGoods(goodsInfo);
        PageInfo<GoodsInfo> pageData = new PageInfo<GoodsInfo>(goodses);
        return AppResponse.success("查询成功!", pageData);
    }



    /**
     * 查询一级商品分类列表接口
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param goodsInfo 查询商品信息条件
     * @return
     */
    public AppResponse listOneGoodsClassify(GoodsInfo goodsInfo) {
        PageHelper.startPage(goodsInfo.getPageNum(), goodsInfo.getPageSize());
        List<GoodsInfo> goodses = goodsDao.listOneGoodsClassify(goodsInfo);
        PageInfo<GoodsInfo> pageData = new PageInfo<GoodsInfo>(goodses);
        return AppResponse.success("查询成功!", pageData);
    }

    /**
     * 查询二级商品分类以及商品接口
     *
     * @return
     */
    public AppResponse listGetClassGoods(GoodsInfo goodsInfo,String classifyId) {
        //设置商品的以及分类编号
        goodsInfo.setclassifyId(classifyId);
        PageHelper.startPage(goodsInfo.getPageNum(), goodsInfo.getPageSize());
        List<GoodsCate> goodsCates = goodsDao.listGetClassGoods(goodsInfo);
        PageInfo<GoodsCate> pageData = new PageInfo<GoodsCate>(goodsCates);
        return AppResponse.success("查询成功!", pageData);
    }






}
