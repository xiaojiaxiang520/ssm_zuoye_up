package com.biunm.system211.service.Impl;

import com.biunm.system211.mapper.UserMapper;
import com.biunm.system211.pojo.User;
import com.biunm.system211.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public List<User> findUserAll() {
        return userMapper.getUserAll();
    }

    @Override
    public User findUser(User user) {
        return userMapper.getUser(user);
    }
}
