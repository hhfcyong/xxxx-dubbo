package com.xxxx.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xxxx.service.Domain.Teacher;

public interface TeacherRepository  extends JpaRepository<Teacher,Integer>{
  //可以用对应的命名规则去写一些特殊的方法
// Teacher findByName(String name);
}
