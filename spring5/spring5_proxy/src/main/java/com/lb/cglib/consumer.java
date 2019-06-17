package com.lb.cglib;

import com.lb.proxy.Iproducer;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

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
         * 使用Enhancer类中的create方法
         * 创建代理对象的要求：
         *      被代理类不能是最终类
         *  create方法的参数：
         *      Class：字节码
         *          是用于指定被代理对象的字节码
         *      Callback：用于提供增强的代码
         *          一般写该接口的子接口实现类，MethodInterceptor
         */
        Producer producer1 = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {

            /**
             *
             * @param proxy
             * @param method
             * @param objects
             * @param methodProxy 当前执行方法的代理对象
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object proxy, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                //提供增强的代码
                Object returnValue = null;
                //获取方法执行的参数
                Float money = (Float) objects[0];
                //判断当前方法
                if("seller".equals(method.getName())){
                    returnValue = method.invoke(producer,money*0.8f);
                }
                return returnValue;
            }
        });
        producer1.seller(1200f);
    }
}
