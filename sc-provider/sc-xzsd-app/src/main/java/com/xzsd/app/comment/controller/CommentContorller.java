package com.xzsd.app.comment.controller;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.comment.entity.CommentInfo;
import com.xzsd.app.comment.service.CommentService;
import com.xzsd.app.goods.controller.GoodsController;
import com.xzsd.app.goods.service.GoodsService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * 评价信息控制器
 *
 * @author 邓嘉豪
 * @date 2020-04-13
 */
@RestController
@RequestMapping("/clientOrder")
public class CommentContorller {
    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Autowired
    private CommentService commentService;


    /**
     * 对订单进行评价
     * 邓嘉豪
     * 2020-04-13 20:15
     */

    @PostMapping(value = "addGoodsEvaluate")
    public AppResponse addGoodsEvaluate(CommentInfo commentInfo) {
        try {
            String userId = SecurityUtils.getCurrentUserId();
            commentInfo.setCreatePerson(userId);
            return commentService.addGoodsEvaluate(commentInfo);
        } catch (Exception e) {
            logger.error("对商品进行评价异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }









}
