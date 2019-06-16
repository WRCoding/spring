package com.lb.Service.impl;

import com.lb.Service.IAccountService;


/**
 * @author LB
 * @create 2019-05-29 15:03
 */
public class AccountServiceImpl implements IAccountService {

    public AccountServiceImpl() {
        System.out.println("对象创建了");
    }

    @Override
    public void saveAccount() {
        System.out.println("Service中的account方法");
    }

    public void init() {
        System.out.println("对象初始化了");
    }
    public void destroy() {
        System.out.println("对象销毁了");
    }
}
