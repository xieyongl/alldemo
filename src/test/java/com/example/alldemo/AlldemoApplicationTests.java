package com.example.alldemo;

import com.alibaba.fastjson.JSON;
import com.example.alldemo.es.mapper.TrainingActivityContentMapper;
import com.example.alldemo.es.pojo.TrainingActivityContent;
import com.example.alldemo.es.pojo.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
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
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class AlldemoApplicationTests {

    @Autowired
    private RestHighLevelClient client;

    @Autowired
    private TrainingActivityContentMapper trainingActivityContentMapper;

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
        GetIndexRequest request = new GetIndexRequest("animal111");
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


    @Test
    void createDoc()  {
        //创建文档 --- 请求对象
        IndexRequest request = new IndexRequest();
        //设置索引及索引中文档的唯一性标识id（如果不指定，则ES会默认随机生成一个id）
        request.index("user").id("1001");

        //创建数据对象（文档内容）

//        List<TrainingActivityContent> list = trainingActivityContentMapper.getContent();
//        System.out.println(list);

        User user = new User();
        user.setId(11);
        user.setName("张起灵");
        user.setSex("男");
        user.setAge(21);

        //向ES中插入数据，必须将数据格式转换为JSON
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String userJson = objectMapper.writeValueAsString(user);
            request.source(userJson, XContentType.JSON);

            //发送请求 --- 获取响应
            IndexResponse response = null;
            response = client.index(request, RequestOptions.DEFAULT);
            System.out.println(response.getResult());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    void test() {
        //创建文档 --- 请求对象
        IndexRequest request = new IndexRequest();
        request.index("content");
        List<TrainingActivityContent> list = trainingActivityContentMapper.getContent();
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
    @Test
    void fuzzyQuery() throws IOException {

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


    @Test
    public void indexIsExists() throws IOException{

    }



}
