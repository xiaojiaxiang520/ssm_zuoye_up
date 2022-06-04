package com.biunm.system211.controller;


import com.biunm.system211.pojo.Course;
import com.biunm.system211.pojo.Result;
import com.biunm.system211.pojo.Task;
import com.biunm.system211.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping("/allCourse")
    public Result findCourse(){
        Result result = new Result();
        System.out.println("访问成功////");
        List<Course> list = indexService.findAllCourse();
        result.setMsg("查询成功");
        result.setData(list);
        result.setCode(200);
        return result;
    }

    @RequestMapping("/allTask")
    public Result findTask(Integer id){
        Result result = new Result();

        System.out.println("查询id");
        System.out.println("查询id"+id);
        List<Task> list = indexService.finAllTask(id);
        result.setMsg("查询成功");
        result.setData(list);
        result.setCode(200);
        return result;
    }
}
