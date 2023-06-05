package com.example.alldemo.designpattern.celue.meiju;

import lombok.Getter;

@Getter
public enum AttachmentEnum {

    IMAGE("图片", "image", "imageService"),
    VIDEO("视频", "video", "videoService"),
    MINI_PROGRAM("小程序", "miniprogram", "miniprogramService"),
    FILE("文件", "file", "fileService");


    private final String name;
    private final String type;
    private final String serviceName;



    AttachmentEnum(String name, String type, String serviceName) {
        this.name = name;
        this.type = type;
        this.serviceName = serviceName;
    }


    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getServiceName() {
        return serviceName;
    }

    public static AttachmentEnum getAttachmentEnumByType(String type) {

        for (AttachmentEnum attachmentEnum : AttachmentEnum.values()) {
            if (attachmentEnum.getType().equals(type)) {
                return attachmentEnum;
            }
        }

        return null;
    }

}
