package com.lb.ui;

/**
 * @author LB
 * @create 2019-05-29 15:07
 */

import com.lb.Service.IAccountService;
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
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //获取核心容器对象
        //------------ApplicationContext----------------
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //根据id获取bean对象
        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService");
        accountService.saveAccount();
        //手动关闭容器
        applicationContext.close();

    }
}
