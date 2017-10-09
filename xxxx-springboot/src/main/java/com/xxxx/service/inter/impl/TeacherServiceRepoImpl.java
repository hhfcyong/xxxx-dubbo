package com.xxxx.service.inter.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxxx.service.Domain.Teacher;
import com.xxxx.service.Domain.Primary.Teacher1;
import com.xxxx.service.Domain.Primary.Teacher1Repository;
import com.xxxx.service.inter.TeacherServiceRepo;
import com.xxxx.service.repo.TeacherRepository;

@Service
public class TeacherServiceRepoImpl implements TeacherServiceRepo {
    
	@Autowired
	Teacher1Repository teacherRepository;
	
	@Override
	public void createTeacher(Teacher1 teacher) {
		// TODO Auto-generated method stub
		teacherRepository.save(teacher);	
	}

	@Override
	public List<Teacher1> getTeacher() {
		// TODO Auto-generated method stub
		return teacherRepository.findAll();
	}

}
