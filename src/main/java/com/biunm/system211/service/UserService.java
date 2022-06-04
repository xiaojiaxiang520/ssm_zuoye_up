package com.biunm.system211.service;

import com.biunm.system211.pojo.User;

import java.util.List;

public interface UserService {

    User findUserById(Integer id);

    List<User> findUserAll();

    User findUser(User user);
}
