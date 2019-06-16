package com.lb.Service.impl;

import com.lb.Service.IAccountService;

import java.util.Date;


/**
 * @author LB
 * @create 2019-05-29 15:03
 */
public class AccountServiceImpl implements IAccountService {

    private String name;
    private int age;
    private Date birthday;

    public AccountServiceImpl(String name, int age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public void saveAccount() {
        System.out.println("Service中的account方法: "+name+","+age+","+birthday);
    }

}
