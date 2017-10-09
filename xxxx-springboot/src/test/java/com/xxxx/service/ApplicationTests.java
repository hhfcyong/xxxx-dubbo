package com.xxxx.service;



import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xxxx.service.Domain.Student;
import com.xxxx.service.Domain.Teacher;
import com.xxxx.service.Domain.Primary.Teacher1;
import com.xxxx.service.inter.TeacherServiceRepo;
import com.xxxx.service.inter.UserServiceRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
  
	/*
	 * 测试多环境配置
	 */
	@Autowired
	private Student student;
	
	/*
	 * 测试jdbcTemplate
	 */
	@Autowired
	private UserServiceRepo userServiceRepo;
	
	
	/*
	 * 测试spring-data-jpa
	 */
	@Autowired
	private TeacherServiceRepo teacherServiceRepo;
	
	@Test
	public void contextLoads() {
		//测试多环境配置
	//	System.out.println(student.getName()+"   "+student.getAge());
		
		//测试jdbcTemplate(并且测试多数据源连接)
		//userServiceRepo.createUser("单数据源", 120);
		//userServiceRepo.deleteByName("3333");
		
		//测试spring-data-jpa(并且测试多数据源连接)
//		Teacher1 teacher=new Teacher1();
//		teacher.setName("王二麻子2");
//		teacher.setAge(113);
//		teacherServiceRepo.createTeacher(teacher);
//		List<Teacher> teachers=teacherServiceRepo.getTeacher();
//		for(int i=0;i<teachers.size();i++){
//			Teacher teacher=teachers.get(i);
//			System.out.println(teacher.getId()+"   "+teacher.getName()+"     "+teacher.getAge());
//		}
	}

}
