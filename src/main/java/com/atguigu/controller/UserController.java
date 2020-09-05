package com.atguigu.controller;


import com.atguigu.domain.User;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
@Controller
public class UserController {

    @Autowired
    UserService userService;

//    @Value("${admin.username}")
//    private String username;

    @Value("${spring.datasource.username}")
    private String username;

    @ResponseBody
    @RequestMapping("/hello")
    public List<User> hello(){
        List<User> all = userService.findAll();
        System.out.println("Controller Username ="+username);
        return all;
    }
}
