package com.biunm.system211.mapper.dt;


import com.biunm.system211.pojo.Course;
import org.apache.ibatis.jdbc.SQL;

public class CourseProvider {
    public String findLimit(Course course)
    {
        return new SQL(){{
            SELECT("course.courseid,course.name,course.newtime,course.coursestate,(select SUM(download) from task where task.courseid=course.courseid) as 'download'");
            SELECT("(select count(*) from task where task.courseid=course.courseid GROUP BY task.courseid) as 'count'");
            FROM("course");
            WHERE("course.state=true");
            LIMIT("#{Limit},10");
        }}.toString();
    }
    public String findCount()
    {
        return new SQL(){
            {
                SELECT("count(*)");
                FROM("course");
                WHERE("course.state=true");
            }
        }.toString();
    }
}
