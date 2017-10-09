package com.xxxx.service.Domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 多环境配置
 * @author zhangyong
 *
 */
@Component
public class Student {
	
	@Value("${com.xxxx.service.Domain.Student.name}")
	private String name;
	@Value("${com.xxxx.service.Domain.Student.age}")
	private Integer age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

}
