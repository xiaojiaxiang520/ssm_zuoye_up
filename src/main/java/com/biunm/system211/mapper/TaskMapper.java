package com.biunm.system211.mapper;

import com.biunm.system211.mapper.dt.TaskProvider;
import com.biunm.system211.pojo.CourseType;
import com.biunm.system211.pojo.Task;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TaskMapper {

//    @Insert("insert into task (taskname,taskurl,courseid,taskstate,taskdelete) values('作业1','我是链接',4,'true','false')")
//    Course addCourse();

    @Select("select course.courseid,course.name " +
            "from course " +
            "where course.coursestate=true and course.state=TRUE")
    List<CourseType> typeCourse();

    @Insert("insert into task " +
            "(taskname,taskurl,courseid,taskstate,taskdelete,newtime,download) " +
            "values(#{TaskName},#{TaskUrl},#{CourseId},#{TaskState},true,#{newTime},#{Download})")
    @Options(useGeneratedKeys = true,keyProperty ="TaskId",keyColumn = "taskid")
    int addTask(Task task);

    @SelectProvider(type = TaskProvider.class,method = "findLimit")
    List<Task> findLimit(Task task);

    @SelectProvider(type = TaskProvider.class,method = "findCount")
    int findCount(Task task);

    //关闭
    @Update("UPDATE task set taskname=#{TaskName},taskstate=#{TaskState} where taskid=#{TaskId}")
    void UpdateTask(Task task);

    @Update("UPDATE task set taskdelete=false where taskid=#{TaskId}")
    void DeleteCourse(Task task);
    @Update("UPDATE task set taskurl=#{TaskUrl} where taskid=#{TaskId}")
    void updateTaskUrl(Task task);
}
