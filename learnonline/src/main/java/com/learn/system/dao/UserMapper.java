package com.learn.system.dao;

import com.learn.system.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface UserMapper {

    List<User> findAll();

    User findByUsername(@Param("account")String account);
}
