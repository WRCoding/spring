package com.lb.jdbc;

import java.sql.*;

/**
 * @author LB
 * @create 2019-05-29 14:41
 *
 *      耦合：程序之间的依赖关系
 *              类之间的依赖
 *              方法间的依赖
 *      解耦：减少程序间的依赖
 *      实际开发中：
 *          编译器不依赖，运行时才依赖
 *      思路：
 *          1.使用反射来创建对象，避免使用new关键字
 *          2.通过读取配置文件来获取要创建的对象
 */
public class jdbcDemo {
    public static void main(String[] args) throws Exception {
       // DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring?serverTimezone=GMT%2B8", "root","1001101" );
        PreparedStatement preparedStatement = connection.prepareStatement("select * from account");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString("name"));
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
