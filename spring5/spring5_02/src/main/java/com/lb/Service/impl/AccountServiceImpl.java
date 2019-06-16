package com.lb.Service.impl;

import com.lb.Service.IAccountService;
import com.lb.dao.IAccountDao;
import com.lb.dao.impl.AccountDaoImpl;
import com.lb.factory.BeanFactory;

/**
 * @author LB
 * @create 2019-05-29 15:03
 */
public class AccountServiceImpl implements IAccountService {

//    private IAccountDao accountDao = new AccountDaoImpl();
     private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");
    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
