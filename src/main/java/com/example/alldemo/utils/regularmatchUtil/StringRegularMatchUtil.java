package com.example.alldemo.utils.regularmatchUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串正则匹配 - 替換字符串模板中 ${} 中的内容
 */
public class StringRegularMatchUtil {

    public static void main(String[] args) {


        Map<String, String> map = new HashMap<>();
        map.put("distributeCode", "替换值1");
        map.put("qudaoCode", "替换值2");

        String baseString = "sub/zero/trans/index?page_name=material&distributeCode={distributeCode}&qudaoCode={qudaoCode}";
        if (baseString.contains("{")) {
            String patternString = "\\{(.+?)}";
            //构建一个匹配模式(模板) 一个匹配模式就是一个对象
            Pattern pattern = Pattern.compile(patternString);
            //根据匹配模板构建一个 匹配器
            Matcher matcher = pattern.matcher(baseString);
            String newString = "";
            while (matcher.find()) {
                String key = matcher.group(1);
                String value = map.get(key);
                newString = matcher.replaceFirst(value);
                matcher = pattern.matcher(newString);
            }
            baseString = newString;

        }
        System.out.println("替换后的结果：" + baseString);
    }
}