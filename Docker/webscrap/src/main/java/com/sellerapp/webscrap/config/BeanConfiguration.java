package com.sellerapp.webscrap.config;

import com.sellerapp.webscrap.service.ScrapService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfiguration {

    @Bean
    public ScrapService getBean() {
        return  new ScrapService();
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
