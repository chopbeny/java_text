package com.xzsd.app.home.controller;
import com.xzsd.app.home.entity.HomeInfo;
import com.xzsd.app.home.service.HomeService;
import com.xzsd.app.user.controller.UserController;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 客户管理控制器
 *
 * @author 邓嘉豪
 * @date 2020-04-12
 */
@RestController
@RequestMapping("/clientHome")
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private HomeService homeService;


    /**
     * 查询首页轮播图列表接口
     * @return
     */
    @PostMapping("/listRotationCharHome")
    public AppResponse listRollImages(HomeInfo homeInfo){
        try {

            return homeService.listRollImages(homeInfo);
        } catch (Exception e) {
            logger.error("查询轮播图列表异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }


    /**
     * 查询热门位商品列表接口
     *
     * @return
     */
    @PostMapping("/listHotGoods")
    public AppResponse listHotGoods(HomeInfo homeInfo) {
        try {
            return homeService.listHotGoods(homeInfo);
        } catch (Exception e) {
            logger.error("查询热门位商品信息列表异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }




}
