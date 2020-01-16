package com.learn.system.service;

import com.learn.system.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findByUsername(String account);
}
