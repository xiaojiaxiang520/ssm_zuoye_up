package com.biunm.system211.service.Impl;

import com.biunm.system211.mapper.IndexMapper;
import com.biunm.system211.pojo.Course;
import com.biunm.system211.pojo.Task;
import com.biunm.system211.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    private IndexMapper mapper;

    @Override
    public List<Course> findAllCourse() {
        return mapper.findAllCourse();
    }

    @Override
    public List<Task> finAllTask(int id) {
        return mapper.finAllTask(id);
    }
}
