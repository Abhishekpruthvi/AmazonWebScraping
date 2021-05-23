package com.sellerapp.scrapstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ScrapstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScrapstoreApplication.class, args);
	}

}
