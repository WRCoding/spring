package com.lb.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author LB
 * @create 2019-06-17 13:39
 * 用于记录日志的工具类，它里面提供了公共的代码
 * 使用注解的AOP，最好使用环绕通知，注解的通知在调用上有问题
 *
 */
@Component("logger")
@Aspect//表示当前类是切面类
public class Logger {

    @Pointcut("execution(* com.lb.service.impl.*.*(..))")
    public void pCut(){}
    /**
     * 前置通知
     */
   // @Before("pCut()")
    public void beforePrintLog(){
        System.out.println("前置通知Log....");
    }

    /**
     * 后置通知
     */
   // @AfterReturning("pCut()")
    public void afterPrintLog(){
        System.out.println("后置通知Log....");
    }

    /**
     * 异常通知
     */
  // @AfterThrowing("pCut()")
    public void throwingPrintLog(){
        System.out.println("异常通知Log....");
    }

    /**
     * 最终通知
     */
   //@After("pCut()")
    public void finalPrintLog(){
        System.out.println("最终通知Log....");
    }

    /**
     * 环绕通知
     * spring框架为我们提供了一个接口，ProceedingJoinPoint,该接口有一个proceed方法，此方法就相当于明确调用切入点方法，该接口可以作为环绕通知的方法参数，在程序执行时，spring框架会为我们提供该接口的实现类供我们使用
     */
    @Around("pCut()")
    public Object aroundPrintLog(ProceedingJoinPoint joinPoint){
        Object value = null;
        try {
            Object[] args = joinPoint.getArgs();
            System.out.println("前置通知Log...");
            value = joinPoint.proceed(args);//明确调用业务层方法(切入点方法)
            System.out.println("后置通知Log...");
            return value;
        }catch (Throwable t){
            System.out.println("异常通知Log...");
            throw new RuntimeException(t);
        }finally {
            System.out.println("最终通知Log...");
        }
    }
}
