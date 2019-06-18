package com.lb.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * @author LB
 * @create 2019-06-18 8:57
 * JdbcTemplate的CRUD
 *
 * 当有多个Dao实现类的时候，可以通过继承JdbcDaoSupport,减少jdbcTemplate的定义
 */
public class JdbcTemplateDemo3 extends JdbcDaoSupport {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate",JdbcTemplate.class);
       //保存
//        jdbcTemplate.update("insert into account (name,money) values (?,?)","999",2345);
       //更新
//        jdbcTemplate.update("update account set name = ? ,money = ? where id = ?","bbb","6789",5);
       //删除
//        jdbcTemplate.update("delete from account where id = ?",7);
       //查询所有
//        List<Account> accounts = jdbcTemplate.query("select *from account where money > ?", new BeanPropertyRowMapper<>(Account.class),1000);
//        for (Account account : accounts) {
//            System.out.println(account);
//        }
        //查询一个
//        List<Account> accounts = jdbcTemplate.query("select *from account where id = ?", new BeanPropertyRowMapper<>(Account.class),6);
//        System.out.println(accounts.get(0));
       //聚会函数
//        Integer integer = jdbcTemplate.queryForObject("select count(*) from account", Integer.class);
//        System.out.println(integer);
    }
}
