package com.example.alldemo.designpattern.celue.meiju;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class VideoService implements AttachmentTypeInterface{

    @Override
    public String operational(String type) {
        log.info("视频操作成功...");
        return "视频操作成功...";
    }
}