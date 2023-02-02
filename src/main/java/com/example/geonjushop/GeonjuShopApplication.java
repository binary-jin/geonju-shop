package com.example.geonjushop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class GeonjuShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeonjuShopApplication.class, args);
    }

}
