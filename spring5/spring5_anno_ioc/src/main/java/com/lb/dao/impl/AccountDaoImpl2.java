package com.lb.dao.impl;

import com.lb.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * @author LB
 * @create 2019-05-29 15:05
 */
@Repository("accountDao2")
public class AccountDaoImpl2 implements IAccountDao {
    @Override
    public void saveAccount() {
        System.out.println("保存了账户2222222222222");
    }
}
