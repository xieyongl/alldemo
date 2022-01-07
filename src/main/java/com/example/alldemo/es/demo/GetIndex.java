package com.example.alldemo.es.demo;

import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description: TODO
 * @author: xieyong
 * @date: 2022/1/7 17:34
 **/
public class GetIndex {

    @Autowired
    private RestHighLevelClient client;

    public static void main(String[] args) {

        GetRequest getRequest = new GetRequest();

    }
}