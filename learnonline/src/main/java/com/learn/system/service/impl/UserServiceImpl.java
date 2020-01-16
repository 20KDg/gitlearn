package com.learn.system.service.impl;

import com.learn.system.dao.UserMapper;
import com.learn.system.model.User;
import com.learn.system.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findByUsername(String account) {
        User user = userMapper.findByUsername(account);
        System.out.println(user);
        return user;
    }
}
