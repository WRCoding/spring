package com.lb.service;

import com.lb.pojo.Account;

/**
 * @author LB
 * @create 2019-06-18 10:59
 */
public interface AccountService {

    Account findById(int id);

    void transfer(String sourceName,String destName,float money);
}
