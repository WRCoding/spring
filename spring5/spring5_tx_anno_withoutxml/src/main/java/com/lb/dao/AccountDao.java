package com.lb.dao;

import com.lb.pojo.Account;


/**
 * @author LB
 * @create 2019-06-18 10:49
 */
public interface AccountDao {
    Account findById(int id);

    Account findByName(String name);

    void update(Account account);
}
