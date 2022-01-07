package com.example.alldemo;

import com.alibaba.fastjson.JSON;
import com.example.alldemo.es.pojo.User;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
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
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;

@SpringBootTest
class AlldemoApplicationTests {

    @Autowired
    private RestHighLevelClient client;

    @Test
    void createIndex() {
        CreateIndexRequest request = new CreateIndexRequest("company");
        try {
            CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);
            System.out.println(createIndexResponse.index());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getIndex() {
        GetIndexRequest request = new GetIndexRequest("animal");
        try {
            boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
            System.out.println(exists);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    void createUserIndex() {
//        User user = new User(1, "zhangsan", 22, "男");
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


    @Test
    void batchInset() {
        //创建批量请求
        BulkRequest bulkRequest = new BulkRequest();
        //超时时间
        bulkRequest.timeout("10s");
        //模拟数据
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(3,"张1",1, "男"));
        users.add(new User(4,"张2",2, "男"));
        users.add(new User(5,"张3",3, "男"));
        users.add(new User(6,"张4",4,"男"));
        int i=0 ;
        //批量插入
        for(User user:users){
            bulkRequest.add(
                    new IndexRequest("user")
                            .id(""+i++)
                            .source(JSON.toJSONString(user), XContentType.JSON)
            );
        }
        try {
            //发送请求
            BulkResponse bulk = client.bulk(bulkRequest, RequestOptions.DEFAULT);
            //获取是否失败标志
            System.out.println(bulk.hasFailures());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
