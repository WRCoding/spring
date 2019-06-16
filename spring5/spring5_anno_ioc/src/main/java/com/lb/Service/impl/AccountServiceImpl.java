package com.lb.Service.impl;

import com.lb.Service.IAccountService;
import com.lb.dao.IAccountDao;
import com.lb.dao.impl.AccountDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * @author LB
 * @create 2019-05-29 15:03
 * 四类注解：
 * 用于创建对象的：
 *          作用与在XML配置中编写一个bean标签实现的功能是一样的
 * `        @Component:
 *              作用：用于把当前对象存入spring容器中
 *              属性：value：指定id，默认为类名首字母小写
 *          @Controller：一般用于表现层
 *          @Service: 一般用于业务层
 *          @Repository：一般用于持久层
 *          以上的注解作用于属性与component相同
 *          是spring为三层架构提供的注解
 * 用于注入数据的
 *          作用与在XML配置中ean标签中的<property></property>的作用是一样的实现的功能是一样的
 *          @ Autowired:自动按照类型注入，只要容器中有唯一的一个bean对象类型和注入的变量类型匹配，如果没有匹配，则报错，就可以注入成功
 *          出现的位置可以是变量上，也可以是方法上
 *          @ Qualifier：在按照类中注入的基础之上再按照名称注入，它在给类成员注入时不能单独使用
 *          @ Resource：直接按照bean的id注入，属性name：用于指定bean的id
 *          属性：value：用于指定注入bean的id
 *          以上注解都只能注入其他bean类型的数据，而基本数据类型和String类型无法使用以上注解注入，集合类型的注入只能通过xml实现
 *          @ value：用于注入基本数据类型和String类型，属性value用于指定数据的值
 * 用于改变作用范围的
 *          作用与bean标签中的<scope></scope>的作用是一样的
 * 和生命周期相关的
 */
@Component(value = "accountService")
public class AccountServiceImpl implements IAccountService {

//    @Autowired
//    @Qualifier("accountDao2")
    @Resource(name = "accountDao2")
    private IAccountDao accountDao;

    public AccountServiceImpl() {
        System.out.println("对象创建了");
    }

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
