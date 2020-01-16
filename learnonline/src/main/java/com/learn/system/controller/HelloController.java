package com.learn.system.controller;

import com.learn.system.dao.UserMapper;
import com.learn.system.model.User;
import com.learn.system.service.UserService;
import com.learn.system.util.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/hello")
    public ResponseEntity<Map<String, Object>> hello() {
        Map<String, Object> map = new HashMap<>();
        List<User> list = userService.findAll();
        System.out.println(list);
        map.put("userList", list);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
