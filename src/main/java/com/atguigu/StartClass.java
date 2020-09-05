package com.atguigu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @MapperScan(basePackages = "com.atguigu.dao")
 * 扫描指定包下的所有Mapper接口，将动态代理的实现类对象注入Spring容器中
 * basePackages属性：指定扫描的包路径地址
 * 作用相当于：
 * <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
 *     <property name="basePackage" value="com.atguigu.dao"/>
 * </bean>
 */
@EnableTransactionManagement
@MapperScan("com.atguigu.dao")
@SpringBootApplication
public class StartClass {
    public static void main(String[] args) {
       SpringApplication.run(StartClass.class, args);
       System.out.println("master的一个小小的修改");   //master ：时间：2020/9/5
       System.out.println("一个小小的修改");   //div：时间:2020/9/25
    }
}
