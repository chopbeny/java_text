package com.xzsd.pc.user.controller;

import com.neusoft.core.exception.ScServerException;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.TencentCOSUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/imageUpload")
@Validated
public class imageUpload {
    private static final Logger logger = LoggerFactory.getLogger(imageUpload.class);
    //    private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);
    // 问题：在一个工具类中，通过@Value来映射配置文件的值，得到的总是null
    // 原因：不能用new工具类的方式，应该是用容器注册（@Autowried）的方式使用此工具类，就能得到配置文件里的值
    @Autowired
    private TencentCOSUtil tencentCOSUtil;//不能通过new来调用
    /**
     * markdown图片上传到腾讯云
     * @param file
     * @return
     */
    @PostMapping("/uploadImage")
    public AppResponse uploadImage(@RequestParam("file") MultipartFile file){
        try {
            System.out.println(file.getContentType().substring(6));// image/png
            if (file.isEmpty()) {
                return AppResponse.bizError("上传失败，请选择文件");
            }
            String url = tencentCOSUtil.uploadImage(file, "head");
            return AppResponse.success("上传成功", url);
        } catch (Exception e) {
            logger.error("上传图片异常异常", e);
            throw new ScServerException("上传错误，请重试");
        }
    }
}