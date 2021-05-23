package com.sellerapp.webscrap.controller;


import com.sellerapp.webscrap.dto.ResponseDto;
import com.sellerapp.webscrap.dto.ScrapDto;
import com.sellerapp.webscrap.service.ScrapService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

@RestController
public class WebScrapController {

    @Autowired
    ScrapService scrapService;

    @PostMapping("/webscrap/url")
    public @ResponseBody ResponseEntity<Object> webScrap(@RequestBody ScrapDto scrap) throws IOException {
        ResponseDto responseDto = new ResponseDto();
//        File input = new File("/home/abhishek/Downloads/local.html");
//        Document doc = Jsoup.parse(input, null);
        Document doc=null;
        try{
            doc = Jsoup.connect(scrap.getUrl()).get();
        }catch(Exception e){
            return new ResponseEntity<>("Unable to fetch the url",HttpStatus.BAD_REQUEST);
        }

        responseDto =  scrapService.fetchDetailsInDoc(doc);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
