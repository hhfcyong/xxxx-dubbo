package com.xxxx.service.repo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.xxxx.service.repo.TeacherServiceRepo;

@Service
public class TeacherServiceRepoImpl implements TeacherServiceRepo{
   
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Qualifier("secondJdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void create(String name, String address) {
		jdbcTemplate.update("insert into teacher(name,address) values('"+name+"','"+address+"')");
	}

	@Override
	public void deleteByName(String name) {
	   jdbcTemplate.update("delete from teacher where name=?",name);
	}

	@Override
	public void deleteTeacher(String name) {
		// TODO Auto-generated method stub
		
	}

}
