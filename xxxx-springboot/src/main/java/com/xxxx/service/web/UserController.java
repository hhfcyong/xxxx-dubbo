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

import com.xxxx.service.Domain.User;





@RestController
@RequestMapping(value="/users")
public class UserController {
      
	   static Map<Integer, User> Users = Collections.synchronizedMap(new HashMap<Integer, User>()); 
	   
	  
	    @RequestMapping(value="/",method=RequestMethod.GET)
	    public List<User> getUserList(){
	    	List<User> User=new ArrayList<User>(Users.values());
	    	return User;
	    }
	   
	    @RequestMapping(value="/",method=RequestMethod.POST)
	    public String addUsers(@ModelAttribute User User){
	    	Users.put(User.getId(), User);
	    	return Users.size()+"";
	    }
	  
	    @RequestMapping(value="/{id}",method=RequestMethod.GET)
	    public User getUser(@PathVariable Integer id){
	    	return Users.get(id);
	    }
	   
	    @RequestMapping(value="/{id}", method=RequestMethod.PUT) 
	    public String updateUser(@PathVariable Integer id, @ModelAttribute User s) { 
	    	User User = Users.get(id); 
	    	User.setName(s.getName()); 
	    	User.setAge(s.getAge()); 
	    	Users.put(id, User); 
	        return "success"; 
	    } 
	  
	    @RequestMapping(value="/{id}", method=RequestMethod.DELETE) 
	    public String deleteUser(@PathVariable Integer id) { 
	        Users.remove(id); 
	        return "success"; 
	    } 
}
