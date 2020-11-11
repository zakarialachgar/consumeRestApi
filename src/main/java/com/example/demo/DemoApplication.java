package com.example.demo;

import org.json.JSONException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoApplication {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
    return builder.build();
}

    public static void main(String[] args){

        SpringApplication.run(DemoApplication.class, args);


    }

}
