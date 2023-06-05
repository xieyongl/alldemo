package com.example.alldemo.utils.json;


import cn.hutool.core.util.StrUtil;

import java.util.HashMap;
import java.util.Map;

public class JsonUtil {

    public static void main(String[] args) {
//        String qudaoCode = "qudaoCode=";
//        String materialId = "&materialId";
//        String s = "sub/zero/trans/index?page_name=material&distributeCode=M22120091333&qudaoCode=qiwei_material_poster-download_181&materialId=181&materialName=lyx%E7%B4%A0%E6%9D%90&rt=%2Fpages%2Fviews%2Findex%2Findex";
//        System.out.println(s.substring(s.indexOf(qudaoCode) + 10, s.indexOf(materialId)));
        Map<String, String> map = new HashMap<>();
        map.put("code", "200");
        map.put("info", "调用异常");
        String msg = "错误提示:{info}";
        final String format = StrUtil.format(msg, map);
        System.out.println(format);

        System.out.println(map.getOrDefault("code1", "char"));


    }

}