package com.xxxx.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching   //开启缓存
public class XxxxSpringboot1Application {

	public static void main(String[] args) {
		SpringApplication.run(XxxxSpringboot1Application.class, args);
	}
}
