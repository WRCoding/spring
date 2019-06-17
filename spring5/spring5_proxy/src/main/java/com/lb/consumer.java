package com.lb;

import com.lb.proxy.Producer;
import com.lb.proxy.Iproducer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author LB
 * @create 2019-06-16 18:46
 */
public class consumer {
    public static void main(String[] args) {
        Producer producer = new Producer();
        producer.seller(1000f);
        /**
         * 动态代理：
         * 特点：字节码随用随创建，随用随加载
         * 作用：不修改源码的基础上对方法增强
         * 分类：
         *       基于接口的动态代理
         *       基于子类的动态代理
         * 使用Proxy类中的newProxyInstance方法
         * 创建代理对象的要求：
         *  被代理类最少实现一个接口，如果没有则不能创建
         *  newProxyInstance方法的参数：
         *      ClassLoader;类加载器
         *          它是用于加载代理对象字节码的，和被代理对象使用相同的类加载器
         *      Class[]: 字节码数组
         *          用于让代理对象和被代理对象有相同的方法
         *      InvocationHandler：用于提供增强的代码
         *          是让我们写如何代理，通常都是匿名内部类
         *          谁用谁写
         */
       Iproducer proxyProducer = (Iproducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 执行被代理对象的任何接口方法都会经过该方法
                     * @param proxy 代理对象的引用
                     * @param method 当前执行的方法
                     * @param args  当前执行方法所需的参数
                     * @return      和被代理对象方法有相同的返回值
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //提供增强的代码
                        Object returnValue = null;
                        //获取方法执行的参数
                        Float money = (Float) args[0];
                        //判断当前方法
                        if("seller".equals(method.getName())){
                            returnValue = method.invoke(producer,money*0.8f);
                        }
                        return returnValue;
                    }
                });
            proxyProducer.seller(1000f);
    }
}
