package com.biunm.system211.controller;


import com.alibaba.fastjson.JSONObject;
import com.biunm.system211.pojo.CourseType;
import com.biunm.system211.pojo.Result;
import com.biunm.system211.pojo.Task;
import com.biunm.system211.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins="*")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @RequestMapping("/zz/admin/addTask")//@RequestParam("file")
    public Result addTask(@RequestParam("formdata") MultipartFile formdata,@RequestParam("task") String task){
        Result result = new Result();
        if(formdata==null)
        {
            result.setMsg("文件不能为空");
            result.setCode(201);
            return result;
        }else {
            Task task1 = JSONObject.parseObject(task, Task.class);
            System.out.println(task1);
            System.out.println(formdata.getOriginalFilename());

            //创建时间
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd'-'HH:mm:ss");
            Date date = new Date(System.currentTimeMillis());
            task1.setNewTime(formatter.format(date));//设置时间
            task1.setTaskDelete(true);//设置删除标记
            //设置下载次数
            task1.setDownload(0);
            taskService.addTask(formdata,task1);
            System.out.println("存入数据库成功！");

        }

        result.setMsg("接受成功");
        result.setCode(200);
        return result;
    }
    //查询数据
    @RequestMapping("/zz/admin/courseType")
    public Result selectCourse(){
        System.out.println("查询");

        Result result = new Result();
        List<CourseType> list = taskService.typeCourse();
        result.setData(list);
        result.setMsg("查询成功");
        result.setCode(200);
        return result;
    }
    @RequestMapping("/zz/admin/findTaskLimit")
    public Result findTaskLimit(Task task1){
        Result result = new Result();

        List<Task> tasks = taskService.findLimit(task1);
        int count =taskService.findCount(task1);


        Map<String, Object> map = new HashMap<>();
        map.put("tasks", tasks);
        map.put("count",count);

        result.setData(200);
        result.setMsg("查询成功");
        result.setData(map);


        return result;
    }

    //修改
    @RequestMapping("/zz/admin/updateTask")
    public Result updateTask(Task task){
        Result result = new Result();
        try {
            System.out.println(task.toString());
            taskService.UpdateTask(task);
            result.setMsg("修改成功");
            System.out.println(task.toString());
            result.setCode(200);
        }catch (Exception e)
        {
            result.setMsg("修改失败");
            result.setCode(201);
        }
        return result;
    }
    //删除数据
    @RequestMapping("/zz/admin/deleteTask")
    public Result deleteCourse(Task task){
        Result result = new Result();
        try {
            System.out.println(task.toString());
            taskService.DeleteCourse(task);
            result.setMsg("删除成功");
            result.setCode(200);
        }catch (Exception e)
        {
            result.setMsg("删除成功");
            result.setCode(201);
        }
        return result;
    }


    public void test(){

    }
}
