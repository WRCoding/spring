package com.lb.ui;

/**
 * @author LB
 * @create 2019-05-29 15:07
 */

import com.lb.Service.IAccountService;
import com.lb.factory.BeanFactory;

/**
 * 模拟表现层
 */
public class Client {
    public static void main(String[] args) {
//        IAccountService accountService = new AccountServiceImpl();
        for (int i = 0;i<5;i++) {
            IAccountService accountService = (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(accountService);
        }
//        accountService.saveAccount();
    }
}
