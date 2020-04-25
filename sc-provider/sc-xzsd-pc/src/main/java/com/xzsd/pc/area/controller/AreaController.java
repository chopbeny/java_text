package com.xzsd.pc.area.controller;

import com.xzsd.pc.area.entity.Area;
import com.xzsd.pc.area.service.AreaService;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 区域名称控制器
 *
 * @author 邓嘉豪
 * @date 2020-03-27
 */
@RestController
@RequestMapping("/area")
public class AreaController {

    private static final Logger logger = LoggerFactory.getLogger(AreaController.class);

    @Autowired
    private AreaService areaService;

    /**
     * 查询区域名称列表接口
     *
     * @return
     */
    @PostMapping("/listAreas")
    public AppResponse listAreas(Area area) {
        try {
            return areaService.listAreas(area);
        } catch (Exception e) {
            logger.error("查询区域名称列表异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }

    /**
     * 根据父级编号查询区域名称列表接口
     *
     * @param areaNameParentCode 父级编号
     * @return
     */
    @PostMapping("/listAreasByParentCode")
    public AppResponse listAreasByParentCode(String areaNameParentCode) {
        try {
            return areaService.listAreasByParentCode(areaNameParentCode);
        } catch (Exception e) {
            logger.error("查询父级区域名称列表异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }

    /**
     * 查询树形区域名称（省包含所有市，市包含所有区（县））
     * @return
     */
    @PostMapping("/listTreeAreas")
    public AppResponse listTreeAreas(){
        try {
            return areaService.listTreeAreas();
        } catch (Exception e) {
            logger.error("查询所有区域名称列表异常", e);
            System.out.println(e.toString());
            return AppResponse.bizError("出现异常");
        }
    }

}


















