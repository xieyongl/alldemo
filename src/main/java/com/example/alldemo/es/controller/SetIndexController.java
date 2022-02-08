package com.example.alldemo.es.controller;

import com.alibaba.fastjson.JSON;
import com.example.alldemo.es.pojo.TrainingActivityContent;
import com.example.alldemo.es.pojo.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

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



    //=============================【索引】==============================

    //创建索引
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

    //获取索引
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


    //创建用户索引
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


    //=============================【文档】==============================

    //创建文档
    @GetMapping("createDoc")
    public void createDoc() {
        GetIndexRequest request = new GetIndexRequest("animal");
        try {
            boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
            System.out.println(exists);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //批量创建
    @GetMapping("beachCreateDoc")
    public void beachCreateDoc() {
        //创建文档 --- 请求对象
        IndexRequest request = new IndexRequest();
        request.index("content");
        List<TrainingActivityContent> list = null; //数据查询语句
        ObjectMapper objectMapper = new ObjectMapper();
        list.forEach(l -> {
            try {
                String strJson = objectMapper.writeValueAsString(l);
                request.source(strJson, XContentType.JSON);
                //发送请求 --- 获取响应
                IndexResponse response = null;
                response = client.index(request, RequestOptions.DEFAULT);
                System.out.println(response.getResult());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println(list.size());

    }


    //模糊查询
    @GetMapping("fuzzyQuery")
    public void fuzzyQuery() throws IOException {

        //创建搜索请求对象
        SearchRequest request = new SearchRequest();

        //设置参数 --- 表示查询哪个索引中的文档内容
        request.indices("user");

        //构建查询的请求体
        SearchSourceBuilder builder = new SearchSourceBuilder();
        //FuzzyQueryBuilder fuzzyQueryBuilder = QueryBuilders.fuzzyQuery("name","小张");
        //fuzzyQueryBuilder.fuzziness(Fuzziness.ONE);
        //builder.query(fuzzyQueryBuilder);
        //上面三行代码 等价于 下面这行代码
        builder.query(QueryBuilders.fuzzyQuery("nick_name","羊").fuzziness(Fuzziness.ONE));
        //将构建好的查询请求体存入搜索请求对象中
        request.source(builder);

        //发送请求 --- 获取响应
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        SearchHits responseHits = response.getHits();
        System.out.println(responseHits.getTotalHits()); //结果集的条数
        System.out.println(response.getTook());  //总耗时
        //遍历结果集
        for (SearchHit hit : responseHits) {
            System.out.println(hit.getSourceAsString());
        }
    }




    //
    @GetMapping("Query")
    public void Query() throws IOException {

    }


    }