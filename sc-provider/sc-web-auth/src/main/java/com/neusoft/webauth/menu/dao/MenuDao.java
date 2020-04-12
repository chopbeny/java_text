package com.neusoft.webauth.menu.dao;

import com.neusoft.webauth.menu.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName menu
 * @Description nmenu
 * @Author 邓嘉豪
 * @Date 2020-03-26
 */
@Mapper
public interface MenuDao {
    /**
     * 统计菜单数量
     * @param menu 菜单信息
     * @return
     */
    int countMenu(Menu menu);

    /**
     * 新增菜单
     * @param menu 菜单信息
     * @return
     */
    int addMenu(Menu menu);

    /**
     * 获取所有菜单信息
     * @param menu 菜单信息
     * @return 所有菜单信息
     */
    List<Menu> listMenuByPage(Menu menu);

    /**
     * 删除菜单
     * @param listCode 选中的用户编号集合
     * @param menuid 更新人
     * @return
     */
    int deleteMenu(List<String> listCode, @Param("menuid") String menuid);

    /**
     * 修改菜单信息
     * @param menu 用户信息
     * @return 修改结果
     */
    int updateMenu(Menu menu);

    /**
     * 查询菜单信息
     * @param menuId 用户编号
     * @return 修改结果
     */
    Menu getMenu(@Param("menuId") String menuId);
}
