package com.sellerapp.scrapstore.Configuration;

import com.sellerapp.scrapstore.service.StoreIndexer;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Value("${elasticsearch.hostname:localhost}")
    private String hostName;
    @Value("${elasticsearch.port:9200}")
    private int port;

    @Bean
    public RestHighLevelClient client() {
        return new RestHighLevelClient(
                RestClient.builder(new HttpHost(hostName, port)));
    }

    @Bean
    public StoreIndexer getBean(RestHighLevelClient client) {
        return  new StoreIndexer(client);
    }
}
