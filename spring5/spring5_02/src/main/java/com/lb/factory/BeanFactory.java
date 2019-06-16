package com.lb.factory;

/**
 * @author LB
 * @create 2019-05-29 15:10
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 一个创建Bean对象的工厂
 * Bean:可重用组件
 * JavaBean：用Java语言编写的可重用组件
 *          javabean>实体类
 * 1.通过配置文件来配置service和dao
 *      内容：唯一标识 = 全限定类名(key-value)
 * 2.通过读取配置文件中的内容，反射创建对象
 *
 * 配置文件可以是XML，properties
 */
public class BeanFactory {

    //定义一个Properties对象
    private static Properties properties;
    //定义一个Map,用于存放我们要创建的对象，称之为容器
    private static Map<String,Object> beans;

    static {
        try {
            properties = new Properties();
            //获取流对象
            InputStream inputStream = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            properties.load(inputStream);
            //实例化容器
            beans = new HashMap<>();
            //取出配置文件中的所有的KEY
            Enumeration<Object> keys = properties.keys();
            //遍历枚举
            while (keys.hasMoreElements()){
                //取出每个key
                String key = keys.nextElement().toString();
                String beanPath = (String) properties.get(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //把key和value存入容器中
                beans.put(key,value );
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化失败");
        }
    }

    /**
     * 单利
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }
    //根据名字获取bean对象
//    public static Object getBean(String beanName){
//        Object bean = null;
//        try {
//            String beanPath = properties.getProperty(beanName);
//            bean = Class.forName(beanPath).newInstance();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return bean;
//    }
}
