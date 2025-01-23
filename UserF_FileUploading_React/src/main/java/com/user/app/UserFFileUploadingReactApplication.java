 package com.user.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class UserFFileUploadingReactApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserFFileUploadingReactApplication.class, args);
	}
    @Bean
    public ObjectMapper mapper()
    {
    	return new ObjectMapper();
    }
}
