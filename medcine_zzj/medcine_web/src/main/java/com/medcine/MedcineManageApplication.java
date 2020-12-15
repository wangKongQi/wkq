package com.medcine;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 项目的启动类
 */
@SpringBootApplication
@MapperScan(basePackages = "com.medcine.dao") // 使用通用mapper接口工具，扫描mapper的路径
@EnableTransactionManagement //开启事务，在方法添加注解@Transactional 控制事务
@EnableCaching
public class MedcineManageApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication.run(MedcineManageApplication.class, args);

    }
}
