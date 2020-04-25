package com.xzsd.pc.rollimage.service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.goods.entity.Goods;
import com.xzsd.pc.image.dao.ImageDao;
import com.xzsd.pc.image.entity.Image;
import com.xzsd.pc.rollimage.dao.RollImageDao;
import com.xzsd.pc.rollimage.entity.RollImage;
import com.xzsd.pc.util.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 轮播图业务处理类
 *
 * @author 邓嘉豪
 * @date 2020-04-14
 */
@Service
public class RollImageService {

    @Resource
    private RollImageDao rollImageDao;

    @Resource
    private ImageDao imageDao;

    @Resource
    private TencentCOSUtil tencentCOSUtil;

    /**
     * 新增轮播图接口
     *
     * @param rollImage 轮播图信息
     * @param imageId   轮播图图片编号
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addRollImage(RollImage rollImage, String imageId,
                                    String rollImageBeginDateStr, String rollImageEndDateStr) {
        int count = rollImageDao.countRollImageByRollImageGoodsCode(rollImage.getRollImageGoodsCode());
        //如果已经存在该商品的轮播图
        if (count > 0) {
            return AppResponse.bizError("已经存在该商品的轮播图，新增失败");
        }
        //转换时间格式，String --> Date
        Date rollImageBeginDate = DateFormatUtil.string2date(rollImageBeginDateStr, DateFormatUtil.YYYY_MM_DD);
        Date rollImageEndDate = DateFormatUtil.string2date(rollImageEndDateStr, DateFormatUtil.YYYY_MM_DD);
        //设置轮播图时间
        rollImage.setRollImageBeginDate(rollImageBeginDate);
        rollImage.setRollImageEndDate(rollImageEndDate);
        //校验开始和结束时间是否符合规定
        if (rollImage.getRollImageBeginDate().equals(rollImage.getRollImageEndDate())) {
            return AppResponse.bizError("开始和结束时间不能一致");
        } else {
            if (rollImage.getRollImageBeginDate().after(rollImage.getRollImageEndDate())) {
                return AppResponse.bizError("开始时间不能在结束时间之后");
            }
        }

        //查询是否有相同排序的轮播图
        int weightCount = rollImageDao.countRollImageByWeight(rollImage.getRollImageWeight());
        if (weightCount > 0) {
            return AppResponse.bizError("排序已存在，新增失败");
        }
        //设置UUID为主键
        rollImage.setRollImageId(UUIDUtils.getUUID());
        //设置图片状态默认为1：启用
        rollImage.setRollImageCondition("1");
        //设置基本属性
        rollImage.setCreateTime(new Date());
        rollImage.setCreatePerson(AuthUtils.getCurrentUserId());
        rollImage.setUpdateTime(new Date());
        rollImage.setUpdatePerson(AuthUtils.getCurrentUserId());
        rollImage.setVersion(1);
        rollImage.setIsDeleted(1);
        int status = rollImageDao.insertSelective(rollImage);
        //轮播图新增成功
        if (status > 0) {
            //如果新增轮播图时有上传图片
            if(imageId != null && !"".equals(imageId)){
                Image image = new Image();
                rollImage.setCreatePerson(AuthUtils.getCurrentUserId());
                rollImage.setUpdatePerson(AuthUtils.getCurrentUserId());
                image.setUpdatePerson(AuthUtils.getCurrentUserId());
                image.setCreatePerson(AuthUtils.getCurrentUserId());
                image.setIsDeleted(1);
                image.setImageId(imageId);
                rollImage.setIsDeleted(1);
                image.setImageCateCode(rollImage.getRollImageId());
                //通过图片的id修改图片的分类编号，把轮播图表的轮播图信息和图片表的轮播图图片关联起来
                int headImageStatus = imageDao.updateByPrimaryKeySelective(image);
                //轮播图图片和轮播图信息没有关联成功
                if(headImageStatus == 0){
                    //回滚事务
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return AppResponse.bizError("新增轮播图信息失败，请输入正确的头像地址");
                }
            }
            return AppResponse.success("新增轮播图信息成功");
        }
        return AppResponse.bizError("新增轮播图信息失败");
    }

    /**
     * 上传轮播图
     *
     * @param rollImage     轮播图图片
     * @param imageCateCode 图片类别编号，此处是轮播图编号
     * @return
     */
    private int uploadHeadImage(MultipartFile rollImage, String imageCateCode) {
        Image image = new Image();
        //设置UUID为主键
        image.setImageId(UUIDUtils.getUUID());
        //设置图片类别为头像
        image.setImageCate(TencentCOSUtil.ROLLIMAGECATE);
        //设置上传头像的用户编号
        image.setImageCateCode(imageCateCode);
        //设置基本属性
        image.setCreatePerson(AuthUtils.getCurrentUserId());
        image.setUpdatePerson(AuthUtils.getCurrentUserId());
        image.setIsDeleted(1);
        image.setVersion(1);
        //当传入头像图片时
        if (!rollImage.isEmpty()) {
            String url = null;
            try {
                //上传到指定的文件夹里面
                url = tencentCOSUtil.uploadImage(rollImage, TencentCOSUtil.ROLLIMAGEFOLDER);
            } catch (Exception e) {
                //表示上传图片出现异常
                return -1;
            }
            //设置图片的url
            image.setImageUrl(url);
        }
        return imageDao.insertSelective(image);
    }

    /**
     * 查询轮播图列表接口
     *
     * @param rollImageCondition 轮播图状态
     * @return
     */
    public AppResponse listRollImages(RollImage rollImage, String rollImageCondition) {
        PageHelper.startPage(rollImage.getPageNum(), rollImage.getPageSize());
        List<RollImage> rollImages = rollImageDao.listRollImages(rollImageCondition);
        PageInfo<RollImage> pageData = new PageInfo<RollImage>(rollImages);
        return AppResponse.success("查询成功!", pageData);
    }

    /**
     * 修改轮播图状态接口
     * @param rollImageIds 轮播图编号列表
     * @param rollImageCondition 轮播图状态
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateRollImageConditionById(String rollImageIds, int rollImageCondition) {
        List<String> listIds = Arrays.asList(rollImageIds.split(","));
        //根据轮播图编号查询出轮播图列表
        List<RollImage> rollImageList = rollImageDao.listRollImagesByIds(listIds);
        //批量修改轮播图信息
        int status = rollImageDao.updateRollImageListCondition(rollImageList, AuthUtils.getCurrentUserId(), rollImageCondition);
        //当修改的轮播图信息和查询出来的轮播图信息不一致
        if (status != rollImageList.size()) {
            //回滚事物
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return AppResponse.bizError("批量修改轮播图状态失败");
        }
        return AppResponse.success("批量修改轮播图状态成功");
    }

    /**
     * 删除轮播图接口
     * @param rollImageIds 轮播图编号列表（批量删除用逗号分开）
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteRollImageById(String rollImageIds){
        List<String> listIds = Arrays.asList(rollImageIds.split(","));
        //删除轮播图信息列表集合，设置更新人id
        int count = rollImageDao.deleteRollImageById(listIds, AuthUtils.getCurrentUserId());
        //当要删除的轮播图总数和已删除的总数不等时，回滚事物，删除失败
        if (count != listIds.size()) {
            //回滚事物
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return AppResponse.bizError("所选列表有未存在数据，删除失败");
        }
        return AppResponse.success("删除成功");
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
        List<Goods> goodses = rollImageDao.listAllGoods(goods);
        PageInfo<Goods> pageData = new PageInfo<Goods>(goodses);
        return AppResponse.success("查询成功!", pageData);
    }



}











