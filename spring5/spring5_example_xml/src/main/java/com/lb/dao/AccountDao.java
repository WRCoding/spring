package com.lb.dao;

import com.lb.pojo.Account;

import java.util.List;

/**
 * @author LB
 * @create 2019-06-15 9:31
 */
public interface AccountDao {
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
     * 根据名字查找账户
     * @param accountName
     * @return
     */
    Account findByName(String accountName);
}
