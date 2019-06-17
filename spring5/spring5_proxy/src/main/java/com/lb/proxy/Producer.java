package com.lb.proxy;

/**
 * @author LB
 * @create 2019-06-16 18:43
 */
public class Producer implements Iproducer {

    /**
     * 销售
     * @param money
     */
    @Override
    public void seller(float money){
        System.out.println("卖出去了，拿到了钱了："+money);
    }

    /**
     * 售后
     * @param money
     */
    @Override
    public void afterService(float money){
        System.out.println("售后服务，拿到钱了："+money);
    }
}
