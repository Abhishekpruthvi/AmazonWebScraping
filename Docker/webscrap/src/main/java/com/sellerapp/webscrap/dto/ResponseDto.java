package com.sellerapp.webscrap.dto;

import lombok.Data;

@Data
public class ResponseDto {
    private String productName;
    private String imageUrl;
    private String numberOfReviews;
    private String mrp;
    private String price;
    private String description;
}
