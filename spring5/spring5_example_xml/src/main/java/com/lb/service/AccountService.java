package com.lb.service;

import com.lb.pojo.Account;

import java.util.List;

/**
 * @author LB
 * @create 2019-06-15 9:22
 * 业务层
 */
public interface AccountService {

    /**
     * 查询所有
     * @return
     */
    List<Account> findAll();

    /**
     * 查询一个
     * @param id
     * @return
     */
    Account findById(int id);

    /**
     * 保存
     * @param account
     */
    void save(Account account);

    /**
     * 更新
     * @param account
     */
    void update(Account account);

    /**
     * 根据id删除
     * @param id
     */
    void delete(int id);

    /**
     * 转账
     * @param sourceName
     * @param destName
     * @param money
     */
    void transfer(String sourceName,String destName,float money);
}
