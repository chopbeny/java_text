package com.xzsd.pc.image.service;

import com.xzsd.pc.image.dao.ImageDao;
import com.xzsd.pc.image.entity.Image;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.AuthUtils;
import com.xzsd.pc.util.TencentCOSUtil;
import com.xzsd.pc.util.UUIDUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;

/**
 * 图片业务处理类
 *
 * @author 邓嘉豪
 * @date 2020-03-27
 */
@Service
public class ImageService {

    @Resource
    private ImageDao imageMapper;

    @Resource
    private TencentCOSUtil tencentCOSUtil;

    /**
     * 上传头像接口
     * @param imageFile 图片文件
     * @author 邓嘉豪
     * @date 2020-03-27
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse uploadImage(MultipartFile imageFile) {
        //校验图片是否存在
        if (imageFile.isEmpty()) {
            return AppResponse.bizError("上传失败，请选择图片");
        }
        //给上传的图片分文件夹
        String imageFolder = "default";

        imageFolder = TencentCOSUtil.HEADIMAGEFOLDER;

        String url = null;
        try {
            //上传到指定的文件夹里面
            url = tencentCOSUtil.uploadImage(imageFile, imageFolder);
        }catch (IOException e){
            return AppResponse.bizError("图片上传出现异常");
        }
        Image image = new Image();
        //设置UUID为主键
        image.setImageId(UUIDUtils.getUUID());
        //设置图片类别

        //设置图片的url
        image.setImageUrl(url);
        //设置基本属性
        image.setCreatePerson(AuthUtils.getCurrentUserId());
        image.setUpdatePerson(AuthUtils.getCurrentUserId());
        image.setIsDeleted(1);
        image.setVersion(1);

        int status = imageMapper.insertSelective(image);
        if (status > 0) {
            return AppResponse.success("图片上传成功", image);
        }
        return AppResponse.bizError("图片上传失败");
    }

}






















