package com.lb.proxy;

/**
 * @author LB
 * @create 2019-06-16 18:44
 */
public interface Iproducer {
    /**
     * 销售
     * @param money
     */
    void seller(float money);
    /**
     * 售后
     * @param money
     */
    void afterService(float money);
}
