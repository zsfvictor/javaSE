package com.zsf.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert2 {

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
    String sql = "update dept set dname = '咨询部' where deptno = 50";
    int n = stmt.executeUpdate(sql);
    System.out.println(n);
    //5.处理结果
    if(n>0){
      System.out.println("更改成功");
    }else{
      System.out.println("更改失败");
    }
    //6.关闭资源
    stmt.close();
    conn.close();

  }

}
