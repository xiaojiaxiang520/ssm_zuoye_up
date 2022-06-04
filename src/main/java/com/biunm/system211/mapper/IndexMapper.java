package com.biunm.system211.mapper;

import com.biunm.system211.pojo.Course;
import com.biunm.system211.pojo.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IndexMapper {

    @Select("select *  " +
            "FROM course " +
            "WHERE course.state=TRUE and course.coursestate=TRUE")
    List<Course> findAllCourse();

    @Select("select * from task " +
            "where task.courseid=#{id} and task.taskdelete=true and taskstate=TRUE order by taskid desc")
    List<Task> finAllTask(int id);
}
