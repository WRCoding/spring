package com.lb.dao.impl;

import com.lb.dao.AccountDao;
import com.lb.pojo.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * @author LB
 * @create 2019-06-15 9:32
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private QueryRunner runner;

    @Override
    public List<Account> findAll() {
        try {
            return runner.query("select *from account",new BeanListHandler<>(Account.class));
        } catch (SQLException e) {
           throw new RuntimeException();
        }
    }

    @Override
    public Account findById(int id) {
        try {
            String sql = "select *from account where id = ?";
            return runner.query(sql,new BeanHandler<>(Account.class),id);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void save(Account account) {
        try {
            runner.update("insert into account(name,money) values(?,?)",account.getName(),account.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void update(Account account) {
        try {
            runner.update("update  account set name = ?,money = ? where id = ?",account.getName(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void delete(int id) {
        try {
            runner.update("delete from  account  where id = ?",id);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
