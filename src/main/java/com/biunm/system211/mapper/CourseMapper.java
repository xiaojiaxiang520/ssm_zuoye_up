package com.biunm.system211.mapper;

import com.biunm.system211.mapper.dt.CourseProvider;
import com.biunm.system211.pojo.Course;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CourseMapper {

    //添加数据  标题，是否显示，创建时间，是否删除标记
    @Insert("insert into course (name,state,newtime,coursestate) values(#{Name},#{State},#{NewTime},#{CourseState})")
    @Options(useGeneratedKeys = true,keyProperty ="CourseId",keyColumn = "courseid")
    void AddCourse(Course course);

    //修改数据
    @Update("UPDATE course set name=#{name},coursestate=#{CourseState} where courseid=#{CourseId}")
    void UpdateCourse(Course course);

    //删除数据
    @Update("UPDATE course set state=false where courseid=#{CourseId}")
    void DeleteCourse(Course course);

    @SelectProvider(type = CourseProvider.class,method = "findLimit")
    List<Course> findLimit(Course course);

    @SelectProvider(type = CourseProvider.class,method = "findCount")
    int findCount(Course course);
}
