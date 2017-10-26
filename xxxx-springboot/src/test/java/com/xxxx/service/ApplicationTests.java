package com.xxxx.service;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.xxxx.service.Domain.Student;
import com.xxxx.service.Domain.Teacher;
import com.xxxx.service.Domain.User;
import com.xxxx.service.Domain.User1;
import com.xxxx.service.Domain.User2;
import com.xxxx.service.Domain.User2Repository;
import com.xxxx.service.Domain.Primary.Teacher1;
import com.xxxx.service.Domain.Primary.Teacher3;
import com.xxxx.service.Domain.Primary.Teacher3Mapper;
import com.xxxx.service.Tasks.AsyncTask;
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
	
	/*
	 * 测试mybatis
	 */
	@Autowired
	private Teacher3Mapper teacher3Mapper;
	
	/*
	 * 测试redis
	 */
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private RedisTemplate<String, User1> redisTemplate;
	
	/*
	 * 测试mongodb
	 */
	@Autowired
	private User2Repository user2Repository;
	
	
	@Autowired
	 private AsyncTask asyncTask;
	

	@Test
	public void contextLoads() throws InterruptedException, ExecutionException {
		//测试多环境配置
	//	System.out.println(student.getName()+"   "+student.getAge());
		
		//测试jdbcTemplate(并且测试多数据源连接)
		//userServiceRepo.createUser("单数据源", 120);
		//userServiceRepo.deleteByName("3333");
		
		//测试spring-data-jpa(并且测试多数据源连接)
		Teacher1 teacher=new Teacher1();
		teacher.setName("事务处理1");
		teacher.setAge(33);
		//结合演示事务
		teacherServiceRepo.createTeacher(teacher);
		//为了测试EhCache缓存，进行两次查询
		 List<Teacher1> teacher1=teacherServiceRepo.findByName("广州");
		System.out.println("第一次查询为："+teacher1.size());
		 List<Teacher1> teacher11=teacherServiceRepo.findByName("广州");
		System.out.println("第二次查询为："+teacher11.size());
		
//		List<Teacher> teachers=teacherServiceRepo.getTeacher();
//		for(int i=0;i<teachers.size();i++){
//			Teacher teacher=teachers.get(i);
//			System.out.println(teacher.getId()+"   "+teacher.getName()+"     "+teacher.getAge());
//		}
		//基于spring-data-jpa的无参数分页
//		List<Teacher1> teacher1s=teacherServiceRepo.getPageContent(0, 2);
//		for(int i=0;i<teacher1s.size();i++){
//			Teacher1 teacher1=teacher1s.get(i);
//			System.out.println(teacher1.getId()+"   "+teacher1.getName()+"     "+teacher1.getAge());
//		}
		//基于spring-data-jpa的带有参数的分页
//		List<Teacher1> teacher1s=teacherServiceRepo.getNamePageContent(0, 2, "广州");
//		for(int i=0;i<teacher1s.size();i++){
//			Teacher1 teacher1=teacher1s.get(i);
//			System.out.println(teacher1.getId()+"   "+teacher1.getName()+"     "+teacher1.getAge());
//		}
		
		//用mybatis操作msyql
//		teacher3Mapper.insert("张一", 1);
//		teacher3Mapper.insert("张二", 2);
//		teacher3Mapper.insert("张三", 3);
//		teacher3Mapper.insert("张四", 4);
//		teacher3Mapper.insert("张五", 5);
//		teacher3Mapper.insert("张六", 6);
//		Teacher3 teacher3=teacher3Mapper.findByName("张二");
//		System.out.println(teacher3.getName()+"   "+teacher3.getAge());
		//用mybatis操作mysql，以map形式插入到mysql中	
//		 Map<String, Object> map = new HashMap<>();
//    	 map.put("name","mybatis");
//    	 map.put("age",17);
//    	 teacher3Mapper.insertByMap(map);
		//用mybatis操作mysql，以实体类形式插入到mysql中	
//		Teacher3 teacher3=new Teacher3();
//		teacher3.setName("mybatis1");
//		teacher3.setAge(18);
//		teacher3Mapper.insertByTeacher3(teacher3);
	    //用mybatis操作mysql，更新数据
//		teacher3Mapper.update(8);
		//用mybatis操作mysql，删除数据
//		teacher3Mapper.delete(8);
		
		//操作redis,值为string类型
//		stringRedisTemplate.opsForValue().set("aaa", "111");
//		stringRedisTemplate.opsForValue().set("bbb", "222");
//		stringRedisTemplate.opsForValue().set("ccc", "333");
//		System.out.println("-------------------读取到的aaa、bbb、ccc的值分别为："+stringRedisTemplate.opsForValue().get("aaa")+"    "+stringRedisTemplate.opsForValue().get("bbb")+"   "+stringRedisTemplate.opsForValue().get("ccc"));
		
		//操作redis，值为实体类
//
//		User1 user1 = new User1();
//		user1.setName("松树");
//		user1.setAge(30);
//		redisTemplate.opsForValue().set(user1.getName(), user1);
//		User1 user2=redisTemplate.opsForValue().get(user1.getName());
//		System.out.println(user2.getName()+"  "+user2.getAge());
		
		
		//测试mongodb
//		User2 user2=new User2();
//		user2.setId(7);
//		user2.setName("mongodb2");
//		user2.setAge(30);
//		user2Repository.save(user2);
//		User2 user2findone=user2Repository.findOne(1);
//		System.out.println(user2findone.getId()+"   "+user2findone.getName()+"   "+user2findone.getAge());
//		
		//不带返回值的异步回调
//		 asyncTask.dealNoReturnTask();
//		  try {
//	   	  System.out.println("begin to deal other Task!");
//		   Thread.sleep(10000);
//		  } catch (InterruptedException e) {
//		   e.printStackTrace();
//		  }
		//带返回值的异步回调
			//用future.get()来获取异步任务的返回结果
//			Future<String> future = asyncTask.dealHaveReturnTask();
//			System.out.println("begin to deal other Task!");
//			 while (true) {
//			  if(future.isCancelled()){
//				  System.out.println("deal async task is Cancelled");
//			      break;
//			  }
//			  if (future.isDone() ) {
//				  System.out.println("deal async task is Done");
//				  System.out.println("return result is " + future.get());
//			      break;
//			  }
//			  System.out.println("wait async task to end ...");
//			  Thread.sleep(1000);
//			 }
	}

}
