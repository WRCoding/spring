package com.lb.service.impl;

import com.lb.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * @author LB
 * @create 2019-06-17 13:37
 */
@Service("accountService")
public class AccountSeriveImpl implements AccountService {
    @Override
    public void saveAccount() {
        System.out.println("保存了....");
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("更新了...."+i);
    }

    @Override
    public int deleteAccount() {
        System.out.println("删除了....");
        return 0;
    }
}
