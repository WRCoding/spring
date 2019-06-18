package com.lb.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author LB
 * @create 2019-06-18 8:57
 * 使用XML配置，JdbcTemplate的基本用法
 */
public class JdbcTemplateDemo2 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate",JdbcTemplate.class);
        jdbcTemplate.execute("insert into account (name,money) values ('666',7777)");
    }
}
