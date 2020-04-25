package com.xzsd.pc.goods.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.goods.dao.GoodsDao;
import com.xzsd.pc.goods.entity.Goods;
import com.xzsd.pc.image.dao.ImageDao;
import com.xzsd.pc.image.entity.Image;
import com.xzsd.pc.util.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
    private ImageDao imageDao;

    @Resource
    private TencentCOSUtil tencentCOSUtil;



    /**
     * 新增商品接口
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param goods   商品信息
     * @param imageId 商品图片编号
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addGoods(Goods goods, String imageId) {
        int count = goodsDao.countGoodsByIsbn(goods.getGoodsIsbn());
        //数据库中存在相同isbn的商品
        if (count != 0) {
            return AppResponse.bizError("商品已存在");
        }
        //设置UUID为主键
        goods.setGoodsId(UUIDUtils.getUUID());
        //设置商品展示的编号（年月日时分秒+2位随机数）
        goods.setGoodsCode(StringUtil.getCommonCode(2));
        //设置商品默认销售状态为0：未发布
        goods.setGoodsCondition("0");
        //设置商品默认总访问量为0
        goods.setGoodsVisitNum("0");
        //设置商品默认销售量为0
        goods.setGoodsSaleSum("0");
        //设置商品评价星级默认为0
        goods.setGoodsStar("0");
        //设置基本属性
        goods.setCreatePerson(AuthUtils.getCurrentUserId());
        goods.setUpdatePerson(AuthUtils.getCurrentUserId());
        goods.setVersion(1);
        goods.setIsDeleted(1);
        int status = goodsDao.insertSelective(goods);
        //商品新增成功
        if (status > 0) {
            //如果新增商品时有上传商品图片
            if (imageId != null && !"".equals(imageId)) {
                Image image = new Image();
                image.setImageId(imageId);
                image.setCreatePerson(AuthUtils.getCurrentUserId());
                image.setUpdatePerson(AuthUtils.getCurrentUserId());
                image.setImageCateCode(goods.getGoodsId());
                image.setIsDeleted(1);
                //通过图片的id修改图片的分类编号，把商品表的商品信息和图片表的商品图片关联起来
                int headImageStatus = imageDao.updateByPrimaryKeySelective(image);
                //商品图片和商品信息没有关联成功
                if (headImageStatus == 0) {
                    //回滚事务
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return AppResponse.bizError("新增商品信息失败，请输入正确的头像地址");
                }
            }
            return AppResponse.success("新增商品信息成功");
        }
        return AppResponse.bizError("新增商品信息失败");
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
        List<Goods> goodses = goodsDao.listAllGoods(goods);
        PageInfo<Goods> pageData = new PageInfo<Goods>(goodses);
        return AppResponse.success("查询成功!", pageData);
    }

    /**
     * 修改商品信息接口
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param goods   要修改的商品信息
     * @param imageId 要修改的商品图片编号
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoodsById(Goods goods, String imageId) {
        //校验数据库中有没有该id的记录
        Goods oldGoods = goodsDao.selectByPrimaryKey(goods.getGoodsId());
        if (oldGoods == null) {
            return AppResponse.bizError("没有该商品信息");
        } else if (!oldGoods.getVersion().equals(goods.getVersion())) {
            return AppResponse.bizError("信息已更新，请重试");
        }
        //设置基本信息
        goods.setCreatePerson(AuthUtils.getCurrentUserId());
        goods.setUpdatePerson(AuthUtils.getCurrentUserId());
        goods.setVersion(oldGoods.getVersion() + 1);
        goods.setIsDeleted(1);
        int status = goodsDao.updateByPrimaryKeySelective(goods);
        if (status > 0) {
            //如果修改商品时有上传商品图
            if (imageId != null && !"".equals(imageId)) {
                //把之前的商品图片进行删除
                imageDao.deleteImageByImageCateCode(goods.getGoodsId(), AuthUtils.getCurrentUserId());
                Image image = new Image();
                image.setImageId(imageId);
                image.setCreatePerson(AuthUtils.getCurrentUserId());
                image.setUpdatePerson(AuthUtils.getCurrentUserId());
                image.setImageCateCode(goods.getGoodsId());
                image.setIsDeleted(1);
                image.setImageCateCode(goods.getGoodsId());
                //通过图片的id，把商品表的商品信息和图片表的商品图片关联起来
                int headImageStatus = imageDao.updateByPrimaryKeySelective(image);
                //商品图片和商品信息没有关联成功
                if (headImageStatus == 0) {
                    //回滚事务
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return AppResponse.bizError("修改商品信息失败，请输入正确的头像地址");
                }
            }
            return AppResponse.success("修改商品信息成功");
        } else {
            return AppResponse.bizError("修改商品信息失败");
        }
    }

    /**
     * 修改商品状态接口
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param goodsIds       要修改的商品编号（批量修改用逗号分开）
     * @param goodsCondition 要修改的商品状态
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoodsConditionById(String goodsIds, int goodsCondition) {
        //获取商品id列表
        List<String> listIds = Arrays.asList(goodsIds.split(","));
        //当上架商品时，需要剔除库存小于0的商品
        if (goodsCondition == 1) {
            //查询商品id列表里的所有商品列表信息
            List<Goods> goodsList = goodsDao.findGoodsById(listIds);
            //初始化商品id列表，可以重新添加剔除后的商品id列表
            listIds = new ArrayList<String>();
            //循环查询商品列表
            for (Goods goods : goodsList) {
                //当商品还有库存时才符合上架条件
                if (goods.getGoodsStock() > 0) {
                    listIds.add(goods.getGoodsId());
                }
            }
        }
        //修改商品信息（上架、下架、上架时间）
        int status = goodsDao.updateGoodsListCondition(listIds, goodsCondition, AuthUtils.getCurrentUserId());
        if (status > 0) {
            return AppResponse.success("商品状态修改成功");
        }
        return AppResponse.bizError("商品状态修改失败");
    }

    /**
     * 删除商品接口
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param goodsIds 商品编号（批量删除用逗号分开）
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteGoodsById(String goodsIds) {
        List<String> listIds = Arrays.asList(goodsIds.split(","));
        //删除商品信息列表集合，设置更新人id
        int count = goodsDao.deleteGoodsById(listIds, AuthUtils.getCurrentUserId());
        //当要删除的商品总数和已删除的总数不等时，回滚事物，删除失败
        if (count != listIds.size()) {
            //回滚事物
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return AppResponse.bizError("所选列表有未存在数据，删除失败");
        } else {
            //同时删除商品信息列表关联的商品图片
            imageDao.deleteImageByGoodsId(listIds, AuthUtils.getCurrentUserId());
            return AppResponse.success("删除成功");
        }
        //todo
        //删除商品还需要判断是否在轮播图里，是否在热门位里，完成轮播图和热门位在来完成这个，待完成
    }



    /**
     * 查询商品详情接口
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param goodsId    查询商品信息条件
     * @return
     */
    public Goods getGoods(String goodsId,Goods goods) {

        Goods goodsManage = goodsDao.selectByPrimaryKey(goodsId);
        goods.setgoodsCateCode(goodsManage.getgoodsCateCode());

        return goodsDao.getGoodsById(goodsId,goods);
    }


}























