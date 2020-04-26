package com.xzsd.app.clientShopCart.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.app.clientShopCart.dao.CartDao;
import com.xzsd.app.clientShopCart.entity.CartInfo;
import com.xzsd.app.goods.dao.GoodsDao;
import com.xzsd.app.goods.entity.GoodsInfo;
import com.xzsd.app.util.AppResponse;
import com.xzsd.app.util.AuthUtils;
import com.xzsd.app.util.UUIDUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 购物车信息业务处理类
 *
 * @author 邓嘉豪
 * @date 2020-03-29
 */
@Service
public class CartService {

    @Resource
    private CartDao cartDao;

    @Resource
    private GoodsDao goodsDao;


    /**
     * 新增购物车信息接口
     *邓嘉豪
     * @param cartInfo 购物车信息
     * @return
     */

    @Transactional(rollbackFor = Exception.class)
    public AppResponse addCart(CartInfo cartInfo) {
        GoodsInfo goodsDetail = goodsDao.getGoodsById(cartInfo.getGoodsId());

        int count = goodsDao.countGoodsByIsbn(goodsDetail.getGoodsIsbn());
        //数据库中存在相同isbn的商品
        if (count == 0) {
            return AppResponse.bizError("商品不存在购物车");
        }
        int countCart = cartDao.countCartGoodsById(cartInfo.getGoodsId());

        //数据库中存在相同isbn的商品
        if (countCart != 0) {
            return AppResponse.bizError("商品已存在购物车,如需修改购物车商品数量，请前往修改购物车商品数量");
        }

        if (cartInfo.getCartGoodsCount() > goodsDetail.getGoodsStock()) {
            return AppResponse.bizError("库存不足，请重新输入商品数量");
        }

        //设置UUID为主键
        cartInfo.setShopCartId(UUIDUtils.getUUID());
        //设置购物车所属用户的编号
        cartInfo.setClientCode(AuthUtils.getCurrentUserId());

        //设置基本属性
        cartInfo.setCreatePerson(AuthUtils.getCurrentUserId());
        cartInfo.setUpdatePerson(AuthUtils.getCurrentUserId());
        cartInfo.setVersion(1);
        cartInfo.setIsDeleted(1);

        //新增商品购物车
        int status = cartDao.insertSelective(cartInfo);
        if(status > 0){
            return AppResponse.success("新增商品购物车信息成功");
        }else{
            return AppResponse.bizError("新增商品购物车信息失败");
        }

    }


    /**
     * 查询购物车列表接口
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param cartInfo    查询商品信息条件
     * @return
     */
    public AppResponse listShoppingCarts(CartInfo cartInfo) {
        PageHelper.startPage(cartInfo.getPageNum(), cartInfo.getPageSize());
        List<CartInfo> goodses = cartDao.listShoppingCarts(cartInfo);
        PageInfo<CartInfo> pageData = new PageInfo<CartInfo>(goodses);
        return AppResponse.success("查询成功!", pageData);
    }





    /**
     * 修改购物车信息接口
     *邓嘉豪
     * @param cartInfo 购物车信息
     * @return
     */

    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateShoppingCartsById(CartInfo cartInfo) {
        int count = cartDao.countCartShoppingById(cartInfo.getShopCartId());
        //数据库中存在相同isbn的商品
        if (count != 0) {
            CartInfo cartInfoDetail = cartDao.findCartById(cartInfo.getShopCartId());
            GoodsInfo goodsDetail = goodsDao.getGoodsById(cartInfoDetail.getGoodsId());
            if (cartInfo.getCartGoodsCount() > goodsDetail.getGoodsStock()) {
                return AppResponse.bizError("库存不足，请重新输入商品数量");
            }
            //设置购物车所属用户的编号
            cartInfo.setClientCode(AuthUtils.getCurrentUserId());
            //设置基本属性
            cartInfo.setUpdatePerson(AuthUtils.getCurrentUserId());
            cartInfo.setIsDeleted(1);
            //修改商品购物车
            int status = cartDao.updateCartById(cartInfo);
            if(status > 0){
                return AppResponse.success("修改商品购物车信息成功");
            }
            else {
                return AppResponse.bizError("修改商品购物车信息失败");
            }
        }
        return AppResponse.bizError("商品不存在购物车");

    }




    /**
     * 删除购物车接口
     * @author 邓嘉豪
     * @date 2020-04-13
     * @param shopCartId 商品编号（批量删除用逗号分开）
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteShoppingCart(String shopCartId) {
        List<String> listIds = Arrays.asList(shopCartId.split(","));
        //删除商品信息列表集合，设置更新人id
        int count = cartDao.deleteShoppingCart(listIds, AuthUtils.getCurrentUserId());
        //当要删除的商品总数和已删除的总数不等时，回滚事物，删除失败
        if (count != listIds.size()) {
            //回滚事物
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return AppResponse.bizError("所选列表有未存在数据，删除失败");
        } else {
            return AppResponse.success("删除成功");
        }

    }


}
