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
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

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
            accountDao.save(account);
    }

    @Override
    public void update(Account account){
                accountDao.update(account);
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
