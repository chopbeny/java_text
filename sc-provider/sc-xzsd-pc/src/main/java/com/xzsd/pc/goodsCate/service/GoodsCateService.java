package com.xzsd.pc.goodsCate.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.goodsCate.dao.GoodsCateDao;
import com.xzsd.pc.goodsCate.entity.GoodsCateInfo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @DescriptionDemo 商品分类实现类
 * @Author 邓嘉豪
 * @Date 2020-03-27
 */
@Service
public class GoodsCateService {
    @Resource
    private GoodsCateDao goodsCateDao;

    /**
     * goodsCate 新增商品分类
     *
     * @param goodsCateInfo
     * @return
     * @Author 邓嘉豪
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addGoodsCate(GoodsCateInfo goodsCateInfo) {
        // 校验商品分类是否存在
        int countgoodsCateAcct = goodsCateDao.countCateId(goodsCateInfo);
        if (0 != countgoodsCateAcct) {
            return AppResponse.bizError("商品分类已存在，请重新输入！");
        }
        goodsCateInfo.setCateId(StringUtil.getCommonCode(2));
        goodsCateInfo.setisDeleted(0);
        // 新增商品分类
        int count = goodsCateDao.addGoodsCate(goodsCateInfo);
        if (0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }


    /**
     * goodsCate 查询商品分类列表（分页）
     *
     * @param goodsCateInfo
     * @return
     * @Author 邓嘉豪
     * @Date 2020-03-26
     */

    public AppResponse listGoodsCate(GoodsCateInfo goodsCateInfo){
        PageHelper.startPage(goodsCateInfo.getPageNum(), goodsCateInfo.getPageSize());
        List<GoodsCateInfo> goodsCateInfoList = goodsCateDao.listGoodsCateByPage(goodsCateInfo);
        PageInfo<GoodsCateInfo> pageData = new PageInfo<GoodsCateInfo>(goodsCateInfoList);
        return AppResponse.success("查询成功！", pageData);
    }


    /**
     * goods 查询商品分类详情接口
     *
     * @param cateId
     * @return
     * @Author 邓嘉豪
     * @Date 2020-03-26
     */

    public AppResponse findGoodsCateById(String cateId){
        GoodsCateInfo goodsCateInfo = goodsCateDao.findGoodsCateById(cateId);
        return AppResponse.success("查询成功！",goodsCateInfo);
    }




    /**
     * goodsCate 修改商品分类信息
     *
     * @param goodsCateInfo
     * @return
     * @Author 邓嘉豪
     * @Date 2020-03-26
     */

    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoodsCateById(GoodsCateInfo goodsCateInfo){
        AppResponse appResponse = AppResponse.success("修改成功");
        int countGoodsCate = goodsCateDao.countCateId(goodsCateInfo);
        if (0 != countGoodsCate) {
            return AppResponse.bizError("商品已存在，请重新输入！");
        }

        int count = goodsCateDao.updateGoodsCateById(goodsCateInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;

    }

    /**
     * 删除商品详情接口
     * @param cateId
     * @param cateid
     * @APpResponse
     * @author 邓嘉豪
     * @Date 2020-04-04
     */

    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteGoodsCateById(String cateId, String cateid) {
        List<String> listCode = Arrays.asList(cateId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除商品
        int count = goodsCateDao.deleteGoodsCateById(listCode, cateid);
        if (0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }











}
