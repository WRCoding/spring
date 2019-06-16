package com.lb.Service.impl;

import com.lb.Service.IAccountService;

import java.util.*;


/**
 * @author LB
 * @create 2019-05-29 15:03
 */
public class AccountServiceImpl3 implements IAccountService {

    private String[] myStr;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String,String> myMap;
    private Properties myProps;

    public void setMyStr(String[] myStr) {
        this.myStr = myStr;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setMyProps(Properties myProps) {
        this.myProps = myProps;
    }

    @Override
    public void saveAccount() {
        System.out.println("String[]: "+Arrays.toString(myStr));
        System.out.println("List: "+myList);
        System.out.println(mySet);
        System.out.println(myMap);
        System.out.println(myProps );
    }

}
