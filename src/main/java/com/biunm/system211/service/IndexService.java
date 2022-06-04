package com.biunm.system211.service;

import com.biunm.system211.pojo.Course;
import com.biunm.system211.pojo.Task;

import java.util.List;

public interface IndexService {

    List<Course> findAllCourse();

    List<Task> finAllTask(int id);
}
