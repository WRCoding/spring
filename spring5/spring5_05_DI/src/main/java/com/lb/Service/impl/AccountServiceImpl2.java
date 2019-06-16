package com.lb.Service.impl;

import com.lb.Service.IAccountService;

import java.util.Date;


/**
 * @author LB
 * @create 2019-05-29 15:03
 */
public class AccountServiceImpl2 implements IAccountService {

    private String name;
    private int age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public void saveAccount() {
        System.out.println("Service中的account方法:  "+name+","+age+","+birthday);
    }

}
