package com.example.alldemo.designpattern.celue.meiju;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class AttachmentSpringContext {


    /**
     * 自动注入，从Spring上下文找到合适的bean来注入，默认按照类型来装配bean，bean必须存在
     * value的泛型为Strategy，则spring将注入到容器里的bean放入value,key则为bean的名称
     */
    @Autowired
    private final Map<String, AttachmentTypeInterface> strategyMap = new ConcurrentHashMap<>(4);

    public AttachmentTypeInterface getService(String type) {
        AttachmentEnum attachmentEnum = AttachmentEnum.getAttachmentEnumByType(type);
        return strategyMap.get(attachmentEnum.getServiceName());
    }

}