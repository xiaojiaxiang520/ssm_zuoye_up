package com.biunm.system211.service.Impl;

import com.biunm.system211.Utils.QiniuFileUpload;
import com.biunm.system211.mapper.TaskMapper;
import com.biunm.system211.pojo.CourseType;
import com.biunm.system211.pojo.Task;
import com.biunm.system211.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskMapper mapper;

    @Override
    public List<CourseType> typeCourse() {
        return mapper.typeCourse();
    }

    @Override
    public int addTask(MultipartFile file,Task task) {
        //现在数据库中添加数据
        int i =mapper.addTask(task);
        System.out.println(task);

        QiniuFileUpload fileUpload = new QiniuFileUpload();
        String url = fileUpload.saveFile(file, task);
        task.setTaskUrl(url);
        mapper.updateTaskUrl(task);
        return i;
    }

    @Override
    public List<Task> findLimit(Task task) {
        return mapper.findLimit(task);
    }

    @Override
    public int findCount(Task task) {
        return mapper.findCount(task);
    }

    @Override
    public void UpdateTask(Task task) {
        mapper.UpdateTask(task);
    }

    @Override
    public void DeleteCourse(Task task) {
        mapper.DeleteCourse(task);
    }
}
