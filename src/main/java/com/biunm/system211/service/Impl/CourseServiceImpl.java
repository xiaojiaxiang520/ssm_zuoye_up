package com.biunm.system211.service.Impl;

import com.biunm.system211.mapper.CourseMapper;
import com.biunm.system211.pojo.Course;
import com.biunm.system211.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseMapper courseMapper;
    @Override
    public void AddCourse(Course course) {
        courseMapper.AddCourse(course);
    }

    @Override
    public void UpdateCourse(Course course) {
        courseMapper.UpdateCourse(course);
    }

    //删除
    @Override
    public void DeleteCourse(Course course) {
        courseMapper.DeleteCourse(course);
    }

    //查询Course类，limit
    @Override
    public List<Course> findLimit(Course course) {
        return courseMapper.findLimit(course);
    }

    @Override
    public int findCount(Course course) {
        return courseMapper.findCount(course);
    }
}
