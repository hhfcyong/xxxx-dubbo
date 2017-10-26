package com.xxxx.service.inter;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import com.xxxx.service.Domain.Teacher;
import com.xxxx.service.Domain.Primary.Teacher1;

public interface TeacherServiceRepo {
    void createTeacher(Teacher1 teacher);
    List<Teacher1> getTeacher();
    List<Teacher1> getPageContent(int page,int size);
    List<Teacher1> getNamePageContent(int page,int size,String name);
    List<Teacher1> findByName(String name);
}
