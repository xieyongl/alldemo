package com.example.alldemo.es.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: TODO
 * @author: xieyong
 * @date: 2022/1/7 17:15
 **/
@Configuration
public class EsConfig {

    @Bean
    public RestHighLevelClient getRestHighLevelClient(){
        RestHighLevelClient client = new RestHighLevelClient(
                //如果是集群再配置多个
                RestClient.builder(new HttpHost("1.12.250.75",9200,"http"))
        );

        return client;
    }

}