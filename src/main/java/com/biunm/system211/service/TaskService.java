package com.biunm.system211.service;

import com.biunm.system211.pojo.CourseType;
import com.biunm.system211.pojo.Task;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TaskService {
    List<CourseType> typeCourse();

    int addTask(MultipartFile formdata, Task task);

    List<Task> findLimit(Task task);

    int findCount(Task task);

    void UpdateTask(Task task);

    void DeleteCourse(Task task);

}
