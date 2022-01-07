package com.example.alldemo.es.controller;

import com.alibaba.fastjson.JSON;
import com.example.alldemo.es.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @description: TODO 新建索引
 * @author: xieyong
 * @date: 2022/1/7 17:50
 **/
@RestController
@RequestMapping("/index")
@Slf4j
public class SetIndexController {

    @Autowired
    private RestHighLevelClient client;

    @GetMapping("createIndex")
    public void SetIndex() {
        CreateIndexRequest request = new CreateIndexRequest("company");
        try {
            CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);
            System.out.println(createIndexResponse.index());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("getIndex")
    public void getIndex() {
        GetIndexRequest request = new GetIndexRequest("animal");
        try {
            boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
            System.out.println(exists);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @GetMapping("createUserIndex")
    public void createUserIndex() {
        User user = new User(2,"测试", 22, "女");

        IndexRequest request = new IndexRequest("posts");
        request.id("1");
        //对象转为json
        request.source(JSON.toJSON(user), XContentType.JSON);
        try {
            //发送
            IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
            //获取索引内容看看
            GetRequest getRequest = new GetRequest("posts","2");
            GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
            System.out.println(getResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}