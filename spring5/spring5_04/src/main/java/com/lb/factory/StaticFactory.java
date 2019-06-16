package com.lb.factory;

import com.lb.Service.IAccountService;
import com.lb.Service.impl.AccountServiceImpl;

/**
 * 模拟一个工厂类
 * @author LB
 * @create 2019-05-29 21:21
 */
public class StaticFactory {
    public static IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
