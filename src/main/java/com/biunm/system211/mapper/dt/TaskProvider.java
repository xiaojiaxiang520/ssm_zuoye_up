package com.biunm.system211.mapper.dt;
import com.biunm.system211.pojo.Task;
import org.apache.ibatis.jdbc.SQL;

public class TaskProvider {

    //查询指定分页数据
    public String findLimit(Task task){
        return new SQL(){{
            SELECT("task.* ,course.name as 'courseName'");
            FROM("task");
            LEFT_OUTER_JOIN("course on task.courseid =course.courseid");
            WHERE("task.taskdelete=TRUE");
            LIMIT("#{Limit},10");
        }}.toString();
    }

    public String findCount()
    {
        return new SQL(){{
            SELECT("count(*)");
            FROM("task");
            WHERE("task.taskdelete=TRUE");
        }}.toString();
    }
}
