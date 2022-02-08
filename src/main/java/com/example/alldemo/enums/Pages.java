package com.example.alldemo.enums;

/**
 * 页面中英文枚举类
 */
public enum Pages {

    INDEX("index", "首页"),
    ESSENCE_ZONE("essence_zone", "精华专区"),
    SEARCH_BOX("search_box", "搜索框"),
    INDUSTRY_LABEL("INDUSTRY_LABEL", "行业分类标签"),
    PUBLISH("publish", "发布"),
    EDIT_PAGE("edit_page", "编辑页");

    private final String EnglishName;
    private final String ChinasName;

    Pages(String EnglishName, String ChinasName) {
        this.EnglishName = EnglishName;
        this.ChinasName = ChinasName;
    }


    public String getEnglishName() {
        return EnglishName;
    }

    public String getChinasName() {
        return ChinasName;
    }

    public static String getChiansByEnglish(String englishName) {
        Pages[] pages = values();
        for (Pages page : pages) {
            if (page.getEnglishName().equals(englishName)) {
                return page.getChinasName();
            }
        }
        return null;
    }

    public static String getEngliahsByChinas(String chinasName) {
        Pages[] pages = values();
        for (Pages page : pages) {
            if (page.getChinasName().equals(chinasName)) {
                return page.getEnglishName();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String s = "index";
        String str = getChiansByEnglish(s);
        System.out.println(str);
    }
}
