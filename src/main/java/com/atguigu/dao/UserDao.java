package com.atguigu.dao;

import com.atguigu.domain.User;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface UserDao {
    public List<User> findAll();
}
