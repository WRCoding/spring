package com.lb.utils;

/**
 * @author LB
 * @create 2019-06-17 13:39
 * 用于记录日志的工具类，它里面提供了公共的代码
 */
public class Logger {

    /**
     * 用于打印日志，计划让其在切入点方法执行之前执行（切入点方法就是业务层方法）
     */
    public void printLog(){
        System.out.println("Log....");
    }
}
