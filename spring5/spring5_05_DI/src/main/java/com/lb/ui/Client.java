package com.lb.ui;

/**
 * @author LB
 * @create 2019-05-29 15:07
 */

import com.lb.Service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 模拟表现层
 */
public class Client {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //获取核心容器对象
        //------------ApplicationContext----------------
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //根据id获取bean对象
//        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService");
//        accountService.saveAccount();
//        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService2");
//        accountService.saveAccount();
        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService3");
        accountService.saveAccount();

    }
}
