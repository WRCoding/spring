package com.lb.cglib;

import com.lb.proxy.Iproducer;

/**
 * @author LB
 * @create 2019-06-16 18:43
 */
public class Producer  {

    /**
     * 销售
     * @param money
     */

    public void seller(float money){
        System.out.println("卖出去了，拿到了钱了："+money);
    }

    /**
     * 售后
     * @param money
     */

    public void afterService(float money){
        System.out.println("售后服务，拿到钱了："+money);
    }
}
