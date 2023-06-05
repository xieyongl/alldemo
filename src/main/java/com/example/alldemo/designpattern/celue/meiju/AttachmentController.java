package com.example.alldemo.designpattern.celue.meiju;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("attachment")
@RequiredArgsConstructor
public class AttachmentController {

    private final AttachmentSpringContext attachmentSpringContext;

    @GetMapping("/test")
    public String errorCodeList(String type) {
        final AttachmentTypeInterface service = attachmentSpringContext.getService(type);
        return service.operational(type);
    }
}