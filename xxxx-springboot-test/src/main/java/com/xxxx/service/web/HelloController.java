package com.xxxx.service.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xxxx.service.Exception.MyException;
import com.xxxx.service.repo.TeacherServiceRepo;
import com.xxxx.service.repo.impl.TeacherServiceRepoImpl;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
public class HelloController {
   
  @Autowired
  TeacherServiceRepo teacherServiceRepo;
	
  @RequestMapping(value="/hello",method=RequestMethod.GET)
  public String index(){
	  return "Hello World";
  }
  @RequestMapping(value="/test",method=RequestMethod.GET)
  public String errorTest() throws MyException{
	  throw new MyException("发生错误");
  }
  @ApiOperation(value="测试讲师信息", notes="测试")
  @ApiImplicitParams({
          @ApiImplicitParam(name = "name", value = "name值", required = true, dataType = "String",paramType="path"),
          @ApiImplicitParam(name = "address", value = "地址", required = true, dataType = "String",paramType="path")
  })
  @RequestMapping(value="/jdbctest/{name}/{address}",method=RequestMethod.POST,produces = "text/plain;charset=UTF-8")
  public void insertJdbcTest(@PathVariable String name,@PathVariable String address){
	  teacherServiceRepo.create(name, address);
	 // teacherServiceRepo.deleteByName("张三");
	
  }
}
