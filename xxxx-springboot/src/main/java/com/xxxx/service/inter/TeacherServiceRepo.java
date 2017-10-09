package com.xxxx.service.inter;

import java.util.List;

import com.xxxx.service.Domain.Teacher;
import com.xxxx.service.Domain.Primary.Teacher1;

public interface TeacherServiceRepo {
    void createTeacher(Teacher1 teacher);
    List<Teacher1> getTeacher();
}
