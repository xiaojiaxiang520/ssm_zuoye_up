package com.biunm.system211.service;

import com.biunm.system211.pojo.Course;

import java.util.List;

public interface CourseService {
    //添加数据
    void AddCourse(Course course);

    //修改数据
    void UpdateCourse(Course course);

    //删除数据
    void DeleteCourse(Course course);

    //查询数据
    List<Course> findLimit(Course course);

    int findCount(Course course);
}
