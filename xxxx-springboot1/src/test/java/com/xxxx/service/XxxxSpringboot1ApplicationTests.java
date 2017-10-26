package com.xxxx.service;

import java.io.File;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.collections.map.HashedMap;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.xxxx.service.Domain.Teacher1;
import com.xxxx.service.Domain.Teacher1Repository;
import com.xxxx.service.mq.Sender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XxxxSpringboot1ApplicationTests {

	@Autowired
	private Teacher1Repository teacher1Repository;
	
	@Autowired
	private CacheManager cacheManager;
	
	//注入邮件依赖
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private VelocityEngine velocityEngine;
	
	@Autowired
	private Sender sender;
	
	@Test
	public void contextLoads() throws MessagingException {
//		Teacher1 teacher1=teacher1Repository.findByName("北京");
//		System.out.println("第一次查询为："+teacher1.getAge());
//		Teacher1 teacher3=new Teacher1();
//		teacher3.setId(4);
//		teacher3.setName("北京");
//		teacher3.setAge(30);
//		teacher1Repository.save(teacher3);
//		Teacher1 teacher2=teacher1Repository.findByName("北京");
//		System.out.println("第二次查询为："+teacher2.getAge());
		
	//发送一个简单的邮件
//	SimpleMailMessage message=new SimpleMailMessage();
//	message.setFrom("619563988@qq.com");
//	message.setTo("79021218@qq.com");
//	message.setSubject("主题：测试邮件发送，简单发送");
//	message.setText("测试邮件简单发送的内容");
//	javaMailSender.send(message);
	  
		//发送一个带有附件的邮件
//		MimeMessage message=javaMailSender.createMimeMessage();
//		
//		MimeMessageHelper helper=new MimeMessageHelper(message,true);
//		helper.setFrom("619563988@qq.com");
//		helper.setTo("79021218@qq.com");
//		helper.setSubject("主题：测试邮件发送，带有附件的发送");
//		//helper.setText("测试邮件简单发送的内容，带有附件");
//		helper.setText("<html><body><img src=\"cid:tupian\"></body></html>",true);
//		
//		FileSystemResource file=new FileSystemResource(new File("/Users/zhangyong/Documents/test/aePicture1.jpg"));
//		//helper.addAttachment("图片.jpg", file);
//		helper.addInline("tupian", file);
//		javaMailSender.send(message);
		
		//发送模板邮件
//		MimeMessage message=javaMailSender.createMimeMessage();		
//		MimeMessageHelper helper=new MimeMessageHelper(message,true);
//		helper.setFrom("619563988@qq.com");
//		helper.setTo("79021218@qq.com");
//		helper.setSubject("主题：测试邮件发送，发送模板邮件");
//        Map<String,Object> model=new HashedMap();
//        model.put("username", "学员们");
//        String text=VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "template.vm", model);
//		helper.setText(text,true);
//		
//		
//		javaMailSender.send(message);
		
		
	//测试发送数据到mq
		sender.send();
	}

}
