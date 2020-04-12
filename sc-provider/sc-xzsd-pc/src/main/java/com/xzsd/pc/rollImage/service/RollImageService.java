package com.xzsd.pc.rollImage.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.rollImage.dao.RollImageDao;
import com.xzsd.pc.rollImage.entity.RollImageInfo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @DescriptionDemo 轮播图实现类
 * @Author 邓嘉豪
 * @Date 2020-03-30
 */
@Service
public class RollImageService {



    @Resource
    private RollImageDao rollImageDao;

    /**
     * rollImage 轮播图新增
     *
     * @param rollImageInfo
     * @return
     * @Author 邓嘉豪
     * @Date 2020-03-30
     */

    @Transactional(rollbackFor = Exception.class)
    public AppResponse addRollImage(RollImageInfo rollImageInfo) {
        // 校验商品分类是否存在
        int countrollImage = rollImageDao.countRollImage(rollImageInfo);
        if (0 != countrollImage) {
            return AppResponse.bizError("轮播图已存在，请重新输入！");
        }
        rollImageInfo.setrollImageId(StringUtil.getCommonCode(2));
        rollImageInfo.setisDeleted(0);
        // 新增商品分类
        int count = rollImageDao.addRollImage(rollImageInfo);
        if (0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");

    }

    /**
     * rollImage 获取轮播图列表
     *
     * @param rollImageInfo
     * @return
     * @Author 邓嘉豪
     * @Date 2020-03-30
     */
    public AppResponse listRollImagesByPage(RollImageInfo rollImageInfo) {
        PageHelper.startPage(rollImageInfo.getPageNum(), rollImageInfo.getPageSize());
        List<RollImageInfo> rollImageInfoList = rollImageDao.listRollImagesByPage(rollImageInfo);
        PageInfo<RollImageInfo> pageData = new PageInfo<RollImageInfo>(rollImageInfoList);
        return AppResponse.success("查询成功！", pageData);
    }

    /**
     *rollImage 修改轮播图状态
     *
     * @param rollImageInfo
     * @return
     * @Author 邓嘉豪
     * @Date 2020-03-30
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateRollImageConditionById(RollImageInfo rollImageInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        int countrollImageId = rollImageDao.countRollImage(rollImageInfo);
        if (0 != countrollImageId) {
            return AppResponse.bizError("轮播图已存在，请重新输入！");
        }

        int count = rollImageDao.updateRollImageConditionById(rollImageInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;



    }


    /**
     * rollImage 删除轮播图
     * @param rollImageId
     * @param rollImageId
     * @APpResponse
     * @author 邓嘉豪
     * @Date 2020-04-04
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteGoodsCateById(String rollImageId, String rollImageid) {
        List<String> listCode = Arrays.asList(rollImageId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除商品
        int count = rollImageDao.deleteRollImageById(listCode, rollImageid);
        if (0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;


    }




}
