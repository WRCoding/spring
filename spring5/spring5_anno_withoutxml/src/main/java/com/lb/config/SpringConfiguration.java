package com.lb.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;


/**
 * @author LB
 * @create 2019-06-15 10:56
 *   Configuration：指定当前类是一个配置类，作用与bean.xml相同
 *   ComponentScan: 指定spring在创建容器时是要扫描的包，此注解相当于在.xml中配置了
 *           <context:component-scan base-package="com.lb"/>
 *   Bean：用于把当前方法的返回值作为bean对象存入到spring的IOC容器中，属性：name，用于指定bean的id，默认为当前方法的类名
 *      细节：当使用注解配置方法时，如果方法有参数，spring框架会去容器中查找有没有可用的bean对象，查找的方式和autowired注解的作用一样
 *   import：用于导入其他配置类，属性：value，用于指定其他配置类的字节码，有import注解的类是主配置类，被导入的类是子配置类
 *   PropertySource：用于指定properties文件的位置
 *          classpath: 类路径
 */
@Configuration
@ComponentScan("com.lb")
@Import(JdbcConfig.class)

public class SpringConfiguration {


}
