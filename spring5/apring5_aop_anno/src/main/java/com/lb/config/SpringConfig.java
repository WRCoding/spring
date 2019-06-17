package com.lb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author LB
 * @create 2019-06-17 22:59
 * @EnableAspectJAutoProxy 开启aop注解支持
 */
@Configuration
@ComponentScan("com.lb")
@EnableAspectJAutoProxy
public class SpringConfig {

}
