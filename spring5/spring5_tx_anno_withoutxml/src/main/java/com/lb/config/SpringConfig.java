package com.lb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author LB
 * @create 2019-06-18 12:25
 */
@Configuration
@ComponentScan("com.lb")
@EnableTransactionManagement//开启事务注解支持
@Import({JdbcConfig.class,TransactionConfig.class})
public class SpringConfig {
}
