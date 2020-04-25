package com.xzsd.pc.area.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.area.dao.AreaDao;
import com.xzsd.pc.area.entity.Area;
import com.xzsd.pc.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 区域名称业务处理类
 *
 * @author 邓嘉豪
 * @date 2020-03-27
 */
@Service
public class AreaService {

    @Resource
    private AreaDao areaDao;

    /**
     * 查询区域名称列表接口（分页）
     *
     * @param area 分页信息
     * @return
     */
    public AppResponse listAreas(Area area) {
        PageHelper.startPage(area.getPageNum(), area.getPageSize());
        List<Area> areas = areaDao.listAreas();
        PageInfo<Area> pageData = new PageInfo<Area>(areas);
        return AppResponse.success("查询成功!", pageData);
    }

    /**
     * 根据父级编号查询区域名称列表接口
     *
     * @param areaNameParentCode 父级编号
     * @return
     */
    public AppResponse listAreasByParentCode(String areaNameParentCode) {
        //当传入的父级编号为空字符串""或者"null"时，设置为null
        if ("".equals(areaNameParentCode) || "null".equals(areaNameParentCode)) {
            areaNameParentCode = null;
        }
        List<Area> areas = areaDao.listAreasByParentCode(areaNameParentCode);
        return AppResponse.success("查询成功!", areas);
    }

    /**
     * 查询树形区域名称（省包含所有市，市包含所有区（县））
     * @return
     */
    public AppResponse listTreeAreas(){
        return AppResponse.success("查询成功", areaDao.listTreeAreas());
    }

}











