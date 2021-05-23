package com.sellerapp.webscrap.service;

import com.sellerapp.webscrap.dto.ResponseDto;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import java.util.logging.Logger;

public class ScrapService {

    static Logger logger = Logger.getLogger(ScrapService.class.getName());

    @Autowired
    RestTemplate restTemplate;

    public ResponseDto fetchDetailsInDoc(Document doc) {
        ResponseDto responseDto = new ResponseDto();
        Elements container =   doc.select("div.a-container");

        Elements leftCol = container.select("div.leftCol");
        String imageUrl = leftCol.select("div#imgTagWrapperId").select("img[src$=.jpg]").attr("src");
        Elements centerCol =  container.select("div.centerColAlign.centerColAlign-bbcxoverride");
        Elements title =  centerCol.select("div.a-section.a-spacing-none");
        String productName = title.select("h1").text();

        String globalRating = centerCol.select("span#acrCustomerReviewText").text();
        String mrp = centerCol.select("span.priceBlockStrikePriceString.a-text-strike").text();
        String dealPrice =  centerCol.select("span.a-size-medium.a-color-price.priceBlockDealPriceString").text();
        String buyPrice =  centerCol.select("span.a-size-medium.a-color-price.priceBlockBuyingPriceString").text();
        String actualPrice = dealPrice.isEmpty() ? buyPrice : dealPrice;
        String description =  centerCol.select("ul.a-unordered-list.a-vertical.a-spacing-mini").text();

        responseDto.setProductName(productName);
        responseDto.setImageUrl(imageUrl);
        responseDto.setNumberOfReviews(globalRating);
        responseDto.setMrp(mrp);
        responseDto.setPrice(actualPrice);
        responseDto.setDescription(description);

        logger.info("Calling Template=====================");
        HttpEntity<ResponseDto> entity = new HttpEntity<ResponseDto>(responseDto);

        restTemplate.exchange("http://localhost:8082/store", HttpMethod.POST, entity, String.class).getBody();

        return  responseDto;
    }
}

