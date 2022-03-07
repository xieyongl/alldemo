package com.example.alldemo.es.controller;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @description: TODO ES 高级查询操作
 * @author: xieyong
 * @date: 2022/2/28 16:40
 **/
@RestController
@RequestMapping("/SeniorIndex")
@Slf4j
public class SeniorController {

    @Autowired
    private RestHighLevelClient client;

    //查询索引中全部数据
    @GetMapping("/getDataByindex")
    public void query() throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("user");

        new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());

        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);

        SearchHits searchHits = response.getHits(); //获取查询结果
        System.out.println(searchHits.getTotalHits()); //查询条数
        System.out.println(response.getTook()); //查询时间
        //查询的具体数据
        for (SearchHit searchHit : searchHits) {
            System.out.println(searchHit.getSourceAsString() );
        }

        System.out.println(response);

    }




}