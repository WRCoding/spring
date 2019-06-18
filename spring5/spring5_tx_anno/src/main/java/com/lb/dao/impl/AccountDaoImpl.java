package com.lb.dao.impl;

import com.lb.dao.AccountDao;
import com.lb.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LB
 * @create 2019-06-18 10:50
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account findById(int id) {
        List<Account> accounts = jdbcTemplate.query("select *from account where id = ?",new BeanPropertyRowMapper<>(Account.class),id);
        return accounts.get(0);
    }

    @Override
    public Account findByName(String name) {
        List<Account> accounts = jdbcTemplate.query("select *from account where name = ?",new BeanPropertyRowMapper<>(Account.class),name);
        return accounts.get(0);
    }

    @Override
    public void update(Account account) {
        jdbcTemplate.update("update account set name = ?,money = ? where id = ?",account.getName(),account.getMoney(),account.getId());
    }
}
