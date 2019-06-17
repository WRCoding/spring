package com.lb.factory;

import com.lb.service.AccountService;
import com.lb.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author LB
 * @create 2019-06-16 20:09
 */
public class BeanFactory {
    private AccountService accountService;
    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public final void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public AccountService getAccountService() {
       return (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object value = null;
                try {
                    //1.开启事务
                    transactionManager.beginTransaction();
                    //2.执行操作
                    value = method.invoke(accountService, args);
                    //3.提交事务
                    transactionManager.commit();
                    //4.返回结果
                    return value;
                } catch (Exception e) {
                    //4.回滚事务
                    transactionManager.rollback();
                    throw new RuntimeException(e);
                } finally {
                    //5.释放事务
                    transactionManager.release();
                }
            }
        });
    }
}
