package com.atguigu;

import com.atguigu.domain.User;
import com.atguigu.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {
    @Autowired
    UserService userService;

    @Test
    public void test01(){

        List<User> all = userService.findAll();
        for (User item : all){
            System.out.println("item = " + item);
        }

    }

    @Autowired
    DataSource dataSource;

    @Test
    public void test02() throws SQLException {
//        System.out.println(dataSource);     //默认数据源为HikariDataSource (null)：性能很高
        //在配置文件里设置为Druid数据源类型后：数据源为
        /**
         *    type: com.alibaba.druid.pool.DruidDataSource
         */
        System.out.println(dataSource);
        System.out.println(dataSource.getClass());
        System.out.println(dataSource.getConnection());
        /**
         * {
         * 	CreateTime:"2020-09-02 20:12:22",
         * 	ActiveCount:0,
         * 	PoolingCount:0,
         * 	CreateCount:0,
         * 	DestroyCount:0,
         * 	CloseCount:0,
         * 	ConnectCount:0,
         * 	Connections:[
         * 	]
         * }
         * class com.alibaba.druid.pool.DruidDataSource
         * com.mysql.cj.jdbc.ConnectionImpl@1a4d1ab7
         */
    }
}
