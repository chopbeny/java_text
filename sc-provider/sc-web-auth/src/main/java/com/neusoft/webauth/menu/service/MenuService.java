package com.neusoft.webauth.menu.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.neusoft.util.UUIDUtils;
import com.neusoft.webauth.menu.dao.MenuDao;
import com.neusoft.webauth.menu.dao.MenuDao;
import com.neusoft.webauth.menu.entity.Menu;
import com.neusoft.webauth.utils.PasswordUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * @DescriptionDemo 实现类
 * @Author 邓嘉豪
 * @Date 2020-03-27
 */
@Service
public class MenuService {

    @Resource
    private MenuDao menuDao;

    /**
     *  新增菜单
     * @param menu
     * @return
     * @Author 邓嘉豪
     * @Date 2020-03-26
     */
    /*
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addMenu(Menu menu) {
        // 检验菜单是否存在
        int countMenu = menuDao.countMenu(menu);
        if(0 != countMenu) {
            return AppResponse.bizError("菜单已存在，请重新输入！");
        }
        menu.setisDeleted(0);
        menu.setupdateTime(StringUtil.getCommonCode(0));
        // 新增菜单
        int count = menuDao.addMenu(menu);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }
*/
    /**
     *查询菜单列表
     * @param menu
     * @return
     * @Author 邓嘉豪
     * @Date 2020-03-26
     */
    public AppResponse listMenu(Menu menu) {
        PageHelper.startPage(menu.getPageNum(), menu.getPageSize());
        List<Menu> menuInfoList = menuDao.listMenuByPage(menu);
        // 包装Page对象
        PageInfo<Menu> pageData = new PageInfo<Menu>(menuInfoList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * 删除菜单
     * @param menuId
     * @param menuid
     * @return
     * @Author 邓嘉豪
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteMenu(String menuId,String menuid) {
        List<String> listCode = Arrays.asList(menuId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除菜单
        int count = menuDao.deleteMenu(listCode,menuid);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * 修改菜单
     * @param menu
     * @return
     * @Author 邓嘉豪
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateMenu(Menu menu) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验菜单是否存在
        int countmenu = menuDao.countMenu(menu);
        if(0 != countmenu) {
            return AppResponse.bizError("菜单已存在，请重新输入！");
        }
        // 修改菜单信息
        int count = menuDao.updateMenu(menu);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }


    /**
     * 查询菜单详情
     * @param menuId
     * @return
     * @Author 邓嘉豪
     * @Date 2020-03-26
     */
    public AppResponse getMenu(String menuId) {
        Menu userInfo = menuDao.getMenu(menuId);
        return AppResponse.success("查询成功！",userInfo);
    }
}


