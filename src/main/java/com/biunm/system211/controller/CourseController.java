package com.biunm.system211.controller;

import com.biunm.system211.pojo.Course;
import com.biunm.system211.pojo.Result;
import com.biunm.system211.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins="*")
public class CourseController {
    @Autowired
    CourseService courseService;

    //分页查询
    @RequestMapping("/zz/admin/selectCourse")
    public Result selectCourse(Course course){
        System.out.println(course.getLimit());
        Result result = new Result();
        //接受到的数据
        List<Course> list = courseService.findLimit(course);
        int count =courseService.findCount(course);
//
        Map<String, Object> map = new HashMap<>();
        map.put("courses", list);
        map.put("count",count);
        result.setCode(200);
        result.setMsg("查询成功");
        result.setData(map);
        return result;
    }

    //添加数据
    @RequestMapping("/zz/admin/addCourse")
    public Result addCourse(Course course){
        //时间
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd'-'HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());

        //设置时间
        course.setNewTime(formatter.format(date));
        //设置是否删除,默认为true
        course.setState(true);
        if(course.getCourseState()==null)
        {
            course.setCourseState(false);
        }
        System.out.println(course.toString());

        Result result = new Result();
        //接受到的数据
        courseService.AddCourse(course);
        if(course.getCourseId()!=0)
        {
            result.setCode(200);
            result.setMsg("添加成功");
            result.setData(course);
        }else {
            result.setCode(204);
            result.setMsg("添加失败");
        }
        return result;
    }
    //修改数据
    @RequestMapping("/zz/admin/updateCourse")
    public Result updateCourse(Course course){
        Result result = new Result();
        try {
            courseService.UpdateCourse(course);
            result.setMsg("修改成功");
            System.out.println(course.toString()+"修改成功！");
            result.setCode(200);
        }catch (Exception e)
        {
            result.setMsg("修改失败");
            result.setCode(201);
        }
        return result;
    }
    //删除数据
    @RequestMapping("/zz/admin/deleteCourse")
    public Result deleteCourse(Course course){
        Result result = new Result();
        try {
            System.out.println(course.toString());
            courseService.DeleteCourse(course);
            result.setMsg("删除成功");
            System.out.println(course.toString()+"修改成功！");
            result.setCode(200);
        }catch (Exception e)
        {
            result.setMsg("删除成功");
            result.setCode(201);
        }
        return result;
    }

}
