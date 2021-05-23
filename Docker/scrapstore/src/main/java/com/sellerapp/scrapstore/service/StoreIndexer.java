package com.sellerapp.scrapstore.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sellerapp.scrapstore.dto.RequestDto;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class StoreIndexer {

    Logger logger = Logger.getLogger(StoreIndexer.class.getName());

    RestHighLevelClient client;

    public StoreIndexer(RestHighLevelClient client) {
        super();
        this.client = client;
    }

    public void indexer(RequestDto requestDto) throws IOException {
        logger.info(" inside the Indexer===========================");
        Map<String,Object> jsonMap = new HashMap<String,Object>();

        jsonMap.put("Product Name",requestDto.getProductName());
        jsonMap.put("Total Reviews",requestDto.getNumberOfReviews());
        jsonMap.put("Image URL", requestDto.getImageUrl());
        jsonMap.put("M.R.P", requestDto.getMrp());
        jsonMap.put("Price",requestDto.getPrice());
        jsonMap.put("Description",requestDto.getDescription());
        jsonMap.put("Updated Time",new Date());

        logger.info("Request elastic search===========================");
        IndexRequest indexRequest = new IndexRequest("seller_app")
            .id(requestDto.getImageUrl()).source(jsonMap);

        IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);

    }
//    IndexRequest indexRequest = new IndexRequest("search_index")
//            .id(json.get("data").get("meta").get("farmerUUID").asText()).source(jsonMap);
//
//    IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
}
