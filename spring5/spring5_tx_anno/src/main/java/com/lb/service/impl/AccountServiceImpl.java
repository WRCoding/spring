package com.lb.service.impl;

import com.lb.dao.AccountDao;
import com.lb.pojo.Account;
import com.lb.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author LB
 * @create 2019-06-18 11:00
 */
@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public Account findById(int id) {
        return accountDao.findById(id);

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
