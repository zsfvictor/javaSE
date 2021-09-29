package com.zsf.jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {

  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://127.0.0.1:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
    String user = "root";
    String password = "bb520520bb";
    //1.加载驱动
    Class.forName(driver);
    //2.建立连接
    Connection conn = DriverManager.getConnection(url,user,password);
    //System.out.println(conn);
    //3.创建一个SQL命令发送器
    Statement stmt = conn.createStatement();

    //4.准备一个SQL命令，并使用SQL命令发送器发送过去，并返回结果
    //String sql = "insert into dept values(50,'教学部','北京')";
    String sql = "insert into dept values(50,'教学部','北京')";
    stmt.executeUpdate(sql);

    sql = "insert into dept values(60,'教学部','北京')";
    stmt.executeUpdate(sql);

    sql = "insert into dept values(70,'教学部','北京')";
    stmt.executeUpdate(sql);

    sql = "insert into dept values(80,'教学部','北京')";
    stmt.executeUpdate(sql);

    sql = "insert into dept values(90,'教学部','北京')";
    stmt.executeUpdate(sql);




    //6.关闭资源
    stmt.close();
    conn.close();

  }

}
