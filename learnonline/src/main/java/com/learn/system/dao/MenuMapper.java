package com.learn.system.dao;

import com.learn.system.model.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {

    List<Menu> findAll();

    List<Menu> findByAccount(String account);
}
