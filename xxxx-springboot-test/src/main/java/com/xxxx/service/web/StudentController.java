package com.xxxx.service.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xxxx.service.properties.Student;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/** 
 *@Controller：修饰class，用来创建处理http请求的对象
 *@RestController：Spring4之后加入的注解，原来在@Controller中返回json需要@ResponseBody来配合，
 *如果直接用@RestController替代@Controller就不需要再配置@ResponseBody，默认返回json格式。
 *@RequestMapping：配置url映射
 */

/**
 * GET /students   查询学生列表
 * POST  /students  创建一个学生
 * GET  /students/id   根据id查询一个学生
 * PUT   /students/id   根据id更新一个学生
 * DELETE  /students/id   根据id删除一个学生
 */

@RestController
@RequestMapping("/students")
public class StudentController {
    static Map<Integer, Student> students = Collections.synchronizedMap(new HashMap<Integer, Student>()); 
    
    /**
     * 查询所有学生
     * @return
     */
    @ApiOperation(value="获取学生列表", notes="")
    @RequestMapping(value="/",method=RequestMethod.GET)
    public List<Student> getStudentList(){
    	List<Student> student=new ArrayList<Student>(students.values());
    	return student;
    }
    /**
     * 创建一个学生
     * @param student
     * @return
     */
    @ApiOperation(value="创建学生", notes="根据Student对象创建学生")
    @ApiImplicitParam(name = "student", value = "学生实体Student", required = true, dataType = "Student")
    @RequestMapping(value="/",method=RequestMethod.POST)
    public String addStudents(@ModelAttribute Student student){
    	students.put(student.getId(), student);
    	return students.size()+"";
    }
   /**
    * 根据id查询一个学生
    * @param id
    * @return
    */
    @ApiOperation(value="获取学生详细信息", notes="根据url的id来获取学生详细信息")
    @ApiImplicitParam(name = "id", value = "学生ID", required = true, dataType = "Integer",paramType="path")
    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public Student getStudent(@PathVariable Integer id){
    	return students.get(id);
    }
    /**
     * 根据id更新一个学生
     * @param id
     * @param s
     * @return
     */
    @ApiOperation(value="更新学生详细信息", notes="根据url的id来指定更新对象，并根据传过来的student信息来更新学生详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Integer",paramType="path"),
            @ApiImplicitParam(name = "student", value = "学生详细实体student", required = true, dataType = "Student")
    })
    @RequestMapping(value="/{id}", method=RequestMethod.PUT) 
    public String updateStudent(@PathVariable Integer id, @ModelAttribute Student s) { 
    	Student student = students.get(id); 
    	student.setName(s.getName()); 
    	student.setAge(s.getAge()); 
    	students.put(id, student); 
        return "success"; 
    } 
    /**
     * 根据id删除一个学生
     * @param id
     * @return
     */
    @ApiOperation(value="删除学生", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Integer",paramType="path")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE) 
    public String deleteStudent(@PathVariable Integer id) { 
        students.remove(id); 
        return "success"; 
    } 
}
