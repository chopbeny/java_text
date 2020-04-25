package com.xzsd.app.home.service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.app.home.dao.HomeDao;
import com.xzsd.app.home.entity.HomeInfo;
import com.xzsd.app.util.AppResponse;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @author 邓嘉豪
 * @date 2020-04-14
 */
@Service
public class HomeService {
    @Resource
    private HomeDao homeDao;



    /**
     * 查询轮播图列表接口
     * @return
     */
    public AppResponse listRollImages(HomeInfo homeInfo) {
        PageHelper.startPage(homeInfo.getPageNum(), homeInfo.getPageSize());
        List<HomeInfo> rollImages = homeDao.listRollImagesApp(homeInfo);
        PageInfo<HomeInfo> pageData = new PageInfo<HomeInfo>(rollImages);
        return AppResponse.success("查询成功!", pageData);
    }


    /**
     * 查询热门位商品列表接口
     *
     * @return
     */
    public AppResponse listHotGoods(HomeInfo homeInfo) {
        PageHelper.startPage(homeInfo.getPageNum(), homeInfo.getPageSize());
        List<HomeInfo> hotGoodsList = homeDao.listHotGoodsApp(homeInfo);
        PageInfo<HomeInfo> pageData = new PageInfo<HomeInfo>(hotGoodsList);
        return AppResponse.success("查询成功!", pageData);
    }



}
