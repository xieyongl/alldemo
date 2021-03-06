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
//        User user = new User(1, "zhangsan", 22, "???");
        User user = new User(2,"??????", 22, "???");

        IndexRequest request = new IndexRequest("posts");
        request.id("1");
        //????????????json
        request.source(JSON.toJSON(user), XContentType.JSON);
        try {
            //??????
            IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
            //????????????????????????
            GetRequest getRequest = new GetRequest("posts","2");
            GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
            System.out.println(getResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    void batchInset() {
        //??????????????????
        BulkRequest bulkRequest = new BulkRequest();
        //????????????
        bulkRequest.timeout("10s");
        //????????????
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(3,"???1",1, "???"));
        users.add(new User(4,"???2",2, "???"));
        users.add(new User(5,"???3",3, "???"));
        users.add(new User(6,"???4",4,"???"));
        int i=0 ;
        //????????????
        for(User user:users){
            bulkRequest.add(
                    new IndexRequest("user")
                            .id(""+i++)
                            .source(JSON.toJSONString(user), XContentType.JSON)
            );
        }
        try {
            //????????????
            BulkResponse bulk = client.bulk(bulkRequest, RequestOptions.DEFAULT);
            //????????????????????????
            System.out.println(bulk.hasFailures());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    void createDoc()  {
        //???????????? --- ????????????
        IndexRequest request = new IndexRequest();
        //????????????????????????????????????????????????id????????????????????????ES???????????????????????????id???
        request.index("user").id("1001");

        //????????????????????????????????????

//        List<TrainingActivityContent> list = trainingActivityContentMapper.getContent();
//        System.out.println(list);

        User user = new User();
        user.setId(11);
        user.setName("?????????");
        user.setSex("???");
        user.setAge(21);

        //???ES????????????????????????????????????????????????JSON
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String userJson = objectMapper.writeValueAsString(user);
            request.source(userJson, XContentType.JSON);

            //???????????? --- ????????????
            IndexResponse response = null;
            response = client.index(request, RequestOptions.DEFAULT);
            System.out.println(response.getResult());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    void test() {
        //???????????? --- ????????????
        IndexRequest request = new IndexRequest();
        request.index("content");
        List<TrainingActivityContent> list = trainingActivityContentMapper.getContent();
        ObjectMapper objectMapper = new ObjectMapper();
        list.forEach(l -> {
            try {
                String strJson = objectMapper.writeValueAsString(l);
                request.source(strJson, XContentType.JSON);
                //???????????? --- ????????????
                IndexResponse response = null;
                response = client.index(request, RequestOptions.DEFAULT);
                System.out.println(response.getResult());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println(list.size());
    }

    //????????????
    @Test
    void fuzzyQuery() throws IOException {

        //????????????????????????
        SearchRequest request = new SearchRequest();

        //???????????? --- ??????????????????????????????????????????
        request.indices("user");

        //????????????????????????
        SearchSourceBuilder builder = new SearchSourceBuilder();
        //FuzzyQueryBuilder fuzzyQueryBuilder = QueryBuilders.fuzzyQuery("name","??????");
        //fuzzyQueryBuilder.fuzziness(Fuzziness.ONE);
        //builder.query(fuzzyQueryBuilder);
        //?????????????????? ????????? ??????????????????
        builder.query(QueryBuilders.fuzzyQuery("nick_name","???").fuzziness(Fuzziness.ONE));
        //?????????????????????????????????????????????????????????
        request.source(builder);

        //???????????? --- ????????????
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        SearchHits responseHits = response.getHits();
        System.out.println(responseHits.getTotalHits()); //??????????????????
        System.out.println(response.getTook());  //?????????
        //???????????????
        for (SearchHit hit : responseHits) {
            System.out.println(hit.getSourceAsString());
        }
    }


    @Test
    public void indexIsExists() throws IOException{

    }



}
