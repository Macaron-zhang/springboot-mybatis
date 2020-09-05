package com.atguigu.service.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.domain.User;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Transactional  //也可以在类上开启事务，但事务的具体配置以方法上的设置为准
@Service
public class UserServiceImpl implements UserService {

    @Autowired
//    @Resource
    UserDao userDao;

//    @Value("${admin.username}")
//    private String username;

    @Value("${spring.datasource.username}")
    private String username;

    //开启事务：propagation传播特性；isolation隔离级别；readOnly是否只读
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ,readOnly = true)      //开启事务
    @Override
    public List<User> findAll() {
        List<User> all = userDao.findAll();
        System.out.println("ServiceImpl Username = "+username);
        return all;
    }
}
