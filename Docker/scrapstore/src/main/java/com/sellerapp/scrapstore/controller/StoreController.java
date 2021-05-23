package com.sellerapp.scrapstore.controller;

import com.sellerapp.scrapstore.dto.RequestDto;
import com.sellerapp.scrapstore.service.StoreIndexer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.logging.Logger;

@RestController
public class StoreController {

    static Logger logger = Logger.getLogger(StoreController.class.getName());
    @Autowired
    StoreIndexer storeIndexer ;
    @PostMapping("/store")
    public void elasticSearchStore(@RequestBody RequestDto requestDto) throws IOException {
        logger.info("Entered inside the controller===========================");
        storeIndexer.indexer(requestDto);
    }

}
