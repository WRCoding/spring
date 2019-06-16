package com.lb.ui;

/**
 * @author LB
 * @create 2019-05-29 15:07
 */

import com.lb.Service.IAccountService;
import com.lb.dao.IAccountDao;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


/**
 * 模拟表现层
 */
public class Client {

    public static void main(String[] args) {
        //获取核心容器对象
        //------------ApplicationContext----------------
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("C:\\work\\bean.xml");
        //根据id获取bean对象
        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService");
//        System.out.println(accountService);
        accountService.saveAccount();
    }
}
