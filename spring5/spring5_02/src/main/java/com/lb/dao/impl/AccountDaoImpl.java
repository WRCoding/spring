package com.lb.dao.impl;

import com.lb.dao.IAccountDao;

/**
 * @author LB
 * @create 2019-05-29 15:05
 */
public class AccountDaoImpl implements IAccountDao {
    @Override
    public void saveAccount() {
        System.out.println("保存了账户");
    }
}
