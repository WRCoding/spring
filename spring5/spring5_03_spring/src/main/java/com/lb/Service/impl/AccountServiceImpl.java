package com.lb.Service.impl;

import com.lb.Service.IAccountService;
import com.lb.dao.IAccountDao;
import com.lb.dao.impl.AccountDaoImpl;


/**
 * @author LB
 * @create 2019-05-29 15:03
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao = new AccountDaoImpl();

    public AccountServiceImpl() {
        System.out.println("对象创建了");
    }

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
