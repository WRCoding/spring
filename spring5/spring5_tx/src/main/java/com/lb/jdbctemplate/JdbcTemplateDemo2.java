package com.lb.jdbctemplate;

import com.lb.dao.AccountDao;
import com.lb.dao.impl.AccountDaoImpl;
import com.lb.pojo.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author LB
 * @create 2019-06-18 8:57
 * 使用XML配置，JdbcTemplate的基本用法
 */
public class JdbcTemplateDemo2 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        AccountDao accountDao = applicationContext.getBean("accountDao", AccountDaoImpl.class);
        Account account = accountDao.findById(3);
        System.out.println(account);
    }
}
