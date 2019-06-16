package com.lb.dao.impl;

import com.lb.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * @author LB
 * @create 2019-05-29 15:05
 */
@Repository("accountDao1")
public class AccountDaoImpl implements IAccountDao {
    @Override
    public void saveAccount() {
        System.out.println("保存了账户11111111111");
    }
}
