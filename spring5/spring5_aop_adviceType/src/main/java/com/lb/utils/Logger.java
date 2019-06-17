package com.lb.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author LB
 * @create 2019-06-17 13:39
 * 用于记录日志的工具类，它里面提供了公共的代码
 */
public class Logger {

    /**
     * 前置通知
     */
    public void beforePrintLog(){
        System.out.println("前置通知Log....");
    }

    /**
     * 后置通知
     */
    public void afterPrintLog(){
        System.out.println("后置通知Log....");
    }

    /**
     * 异常通知
     */
    public void throwingPrintLog(){
        System.out.println("异常通知Log....");
    }

    /**
     * 最终通知
     */
    public void finalPrintLog(){
        System.out.println("最终通知Log....");
    }

    /**
     * 环绕通知
     * spring框架为我们提供了一个接口，ProceedingJoinPoint,该接口有一个proceed方法，此方法就相当于明确调用切入点方法，该接口可以作为环绕通知的方法参数，在程序执行时，spring框架会为我们提供该接口的实现类供我们使用
     */
    public Object aroundPrintLog(ProceedingJoinPoint joinPoint){
        Object value = null;
        try {
            Object[] args = joinPoint.getArgs();
            value = joinPoint.proceed(args);//明确调用业务层方法(切入点方法)
            System.out.println("环绕通知Log...");
            return value;
        }catch (Throwable t){
            throw new RuntimeException(t);
        }finally {

        }
    }
}
