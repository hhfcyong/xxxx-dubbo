package com.xxxx.service.repo;

public interface TeacherServiceRepo {

	void create(String name,String address);
	
	void deleteByName(String name);
	
	void deleteTeacher(String name);
}
