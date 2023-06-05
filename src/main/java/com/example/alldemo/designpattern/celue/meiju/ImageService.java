package com.example.alldemo.designpattern.celue.meiju;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ImageService implements AttachmentTypeInterface {

    @Override
    public String operational(String type) {
      log.info("图片操作成功...");
        return "图片操作成功...";
    }
}