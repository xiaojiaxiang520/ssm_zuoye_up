package com.biunm.system211.mapper;

import com.biunm.system211.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    //查询所有用户
    @Select("select * from user")
    List<User> getUserAll();

    //根据id查询用户
    @Select("select * from user where userid=#{userid}")
    User getUserById(Integer id);

    //根据账号密码查询用户
    @Select("select * from user where username=#{username} and password=#{password}")
    User getUser(User user);


}
