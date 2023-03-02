package com.example.alldemo.utils.dateUtil;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;

public class StringDateUtil {

    /**
     * 截取String类型时间 年月日
     * @return
     */
    private static String getYmd() {

        String s = "2023-02-27 00:00:00";
        String format = DateUtil.format(DateUtil.parse(s), DatePattern.NORM_DATE_PATTERN);
        return format;
    }

    public static void main(String[] args) {
        System.out.println(getYmd());
    }

}