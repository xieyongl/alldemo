package com.example.alldemo.testdemo;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import com.example.alldemo.es.pojo.User;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class DateDemo {

    public static void main(String[] args) {

//        User user = new User(1, "name1", 22, "男");


        final Date date = Convert.toDate("2022-02-02 12:23:34");
        System.out.println(date);

        final String format = DateUtil.format(date, DatePattern.NORM_DATETIME_FORMAT);

        System.out.println(format);
    }
}
