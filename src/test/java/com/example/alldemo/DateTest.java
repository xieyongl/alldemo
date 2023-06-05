package com.example.alldemo;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.text.StrFormatter;
import cn.hutool.core.text.StrMatcher;
import com.example.alldemo.es.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Slf4j
@SpringBootTest
public class DateTest {

    @Test
    public void testt() {
        String s = "2022-12-12";
        s = s.substring(0, 10);
        System.out.println(s);
    }

    @Test
    public void test() {

        String ss = "page_name=material&distributeCode=${distributeCode}&qudaoCode=${qudaoCode}&materialId=${materialId}&materialName=${materialName}";
        Map<String, String> map = new HashMap<>(4);
        map.put("distributeCode", "1");
        map.put("qudaoCode", "2");
        map.put("materialId", "3");
        map.put("materialName", "4");

        if (ss.contains("$")) {
        String patternString = "\\$\\{(.+?)}";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(ss);
        String text = "";
        while (matcher.find()) {
            String keyString = matcher.group(1);
            String value = map.get(keyString);
            text = matcher.replaceFirst(value);
            matcher = pattern.matcher(text);
            }
            ss = text;
        }
        System.out.println(ss);
    }


    @Test
    void page() {
        List<User> list = new ArrayList<User>();
        list.add(new User(1, "name1", 22, "男"));
        list.add(new User(1, "name1", 22, "男"));
        list.add(new User(1, "name2", 22, "男"));
        list.add(new User(2, "name3", 22, "男"));
        list.add(new User(2, "name4", 22, "男"));

        final List<User> collect = list.stream().distinct().collect(Collectors.toList());
        collect.forEach(System.out::println);

    }
}

@Data
@AllArgsConstructor
class IntegraDetails {

    /**
     * 积分明细
     */
    private String type;

    /**
     * 积分获取时间
     */
    private String time;

    /**
     * 积分值
     */
    private Integer integral;


}