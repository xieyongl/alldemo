package com.example.alldemo.utils.qiniuyun.controller;

import com.example.alldemo.common.entity.Result;
import com.example.alldemo.utils.qiniuyun.util.QiNiuUtils;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @description: TODO
 * @author: xieyong
 * @date: 2022/2/8 11:25
 **/
@RestController
@RequestMapping("/common")
@Slf4j
@CrossOrigin(allowCredentials = "true")
public class CommonController {

    @Autowired
    private QiNiuUtils qiNiuUtils;

    @ApiOperation("上传图片接口")
    @PostMapping("/upload")
    public ResponseEntity upload(@RequestBody MultipartFile imgFile){
        try {
            //IMG_DIR_NAME为路径
            String fileName = qiNiuUtils.preCustom(imgFile, "IMG_DIR_NAME");
            String imgUrl = qiNiuUtils.uploadFile(imgFile.getBytes(), fileName);
            return Result.success(imgUrl);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("上传图片错误:{}",e.getMessage());
            return Result.error(HttpStatus.INTERNAL_SERVER_ERROR,"上传失败");
        }
    }
}