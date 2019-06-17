package com.lb.service;

/**
 * @author LB
 * @create 2019-06-17 13:35
 */
public interface AccountService {

    /**
     * 模拟保存账户
     */
    void saveAccount();

    /**
     * 模拟更新账户
     * @param i
     */
    void updateAccount(int i);

    /**
     * 模拟删除账户
     * @return
     */
    int deleteAccount();
}
