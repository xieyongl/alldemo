package com.example.alldemo.utils.gsonUtil;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @description: TODO
 * @author: xieyong
 * @date: 2022/11/16 16:41
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable {

    private Integer id;
    private String name;
    private Integer age;
    private Integer sex;
    private List<String> mobiles;

    public static User formJson(String json) {
        return ObjectGsonBuilder.create().fromJson(json, User.class);
    }

}