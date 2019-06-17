package com.lb.service.impl;

import com.lb.dao.AccountDao;
import com.lb.pojo.Account;
import com.lb.service.AccountService;
import com.lb.utils.TransactionManager;

import java.util.List;

/**
 * @author LB
 * @create 2019-06-15 9:30
 */
public class AccountServiceImpl2 implements AccountService {
    private AccountDao accountDao;
    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAll() {
            return accountDao.findAll();
    }

    @Override
    public Account findById(int id) {
            return accountDao.findById(id);

    }

    @Override
    public void save(Account account) {
        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            accountDao.save(account);
            //3.提交事务
            transactionManager.commit();
        } catch (Exception e) {
            //4.回滚事务
            transactionManager.rollback();
            throw new RuntimeException(e);
        } finally {
            //5.释放事务
            transactionManager.release();
        }
    }

    @Override
    public void update(Account account){
        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            accountDao.update(account);
            //3.提交事务
            transactionManager.commit();
        } catch (Exception e) {
            //4.回滚事务
            transactionManager.rollback();
            throw new RuntimeException(e);
        } finally {
            //5.释放事务
            transactionManager.release();
        }

    }

    @Override
    public void delete(int id) {
            accountDao.delete(id);
    }

    @Override
    public void transfer(String sourceName, String destName, float money) {
        System.out.println("transfer....");
            Account source = accountDao.findByName(sourceName);
            Account dest = accountDao.findByName(destName);
            source.setMoney(source.getMoney() - money);
            dest.setMoney(dest.getMoney() + money);
            accountDao.update(source);
//            int i = 1/0;
            accountDao.update(dest);
    }
}
