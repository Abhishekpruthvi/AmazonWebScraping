package com.sellerapp.scrapstore.dto;

import lombok.Data;

@Data
public class RequestDto {
    private String productName;
    private String imageUrl;
    private String numberOfReviews;
    private String mrp;
    private String price;
    private String description;
}
