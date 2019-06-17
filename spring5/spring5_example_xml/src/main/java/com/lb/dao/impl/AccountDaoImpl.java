package com.lb.dao.impl;

import com.lb.dao.AccountDao;
import com.lb.pojo.Account;
import com.lb.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author LB
 * @create 2019-06-15 9:32
 */
public class AccountDaoImpl implements AccountDao {

    private QueryRunner runner;
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    @Override
    public List<Account> findAll() {
        try {
            return runner.query(connectionUtils.getConnection(),"select *from account",new BeanListHandler<>(Account.class));
        } catch (SQLException e) {
           throw new RuntimeException();
        }
    }

    @Override
    public Account findById(int id) {
        try {
            String sql = "select *from account where id = ?";
            return runner.query(connectionUtils.getConnection(),sql,new BeanHandler<>(Account.class),id);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void save(Account account) {
        try {
            runner.update(connectionUtils.getConnection(),"insert into account(name,money) values(?,?)",account.getName(),account.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void update(Account account) {
        try {
            runner.update(connectionUtils.getConnection(),"update  account set name = ?,money = ? where id = ?",account.getName(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void delete(int id) {
        try {
            runner.update(connectionUtils.getConnection(),"delete from  account  where id = ?",id);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public Account findByName(String accountName) {
        try {
            String sql = "select *from account where name = ?";
            List<Account> accounts = runner.query(connectionUtils.getConnection(),sql,new BeanListHandler<>(Account.class),accountName);
            if(accounts == null || accounts.size() == 0){
                return null;
            }
            if(accounts.size() > 1){
                throw new RuntimeException("结果有误");
            }
            return accounts.get(0);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
