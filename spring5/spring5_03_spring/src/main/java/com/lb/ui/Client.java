package com.lb.ui;

/**
 * @author LB
 * @create 2019-05-29 15:07
 */

import com.lb.Service.IAccountService;
import com.lb.Service.impl.AccountServiceImpl;
import com.lb.dao.IAccountDao;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.annotation.Resources;


/**
 * 模拟表现层
 */
public class Client {
    /**
     * 获得spring的IOC核心容器，并根据id获取对象
     * ApplicationContext三个常用实现类
     *      ClassPathXmlApplicationContext：可以加载类路径下的配置文件，要求配置文件必须在类路径下，不在的话，加载不了。(常用)
     *      FileSystemXmlApplicationContext： 可以加载磁盘任意路径下的配置文件（必须有访问权限）
     *      AnnotationConfigApplicationContext：用于读取注解创建容器的
     *
     * 核心容器的两个接口引发出的问题
     * ApplicationContext：立即加载方式，一读取完配置文件，就创建对象 (适合单例对象)
     * BeanFactory: 延迟加载方式，什么时候要获取对象，什么时候才创建对象（适合多例对象）
     * @param args
     */
    public static void main(String[] args) {
        //获取核心容器对象
        //------------ApplicationContext----------------
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
////        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("C:\\work\\bean.xml");
//        //根据id获取bean对象
//        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService");
//        IAccountDao accountDao =  applicationContext.getBean("accountDao",IAccountDao.class);
//        System.out.println(accountService);
//        System.out.println(accountDao);
//        accountService.saveAccount();

        //------------BeanFactory----------------
        Resource resources = new ClassPathResource("bean.xml");
        BeanFactory factory = new XmlBeanFactory(resources);
        IAccountService accountService = (IAccountService) factory.getBean("accountService");
        System.out.println(accountService);

    }
}
