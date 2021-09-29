package com.zsf.jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTransaction {

  public static void main(String[] args) {
    Connection conn = null;
    try {
      String driver = "com.mysql.cj.jdbc.Driver";
      String url = "jdbc:mysql://127.0.0.1:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
      String user = "root";
      String password = "bb520520bb";
      //1.加载驱动
      // Class.forName(driver);
      //2.建立连接
      conn = DriverManager.getConnection(url, user, password);
      //System.out.println(conn);
      //3.创建一个SQL命令发送器
      Statement stmt = conn.createStatement();

      //设置设置不再自动提交
      conn.setAutoCommit(false);

      //4.准备一个SQL命令，并使用SQL命令发送器发送过去，并返回结果
      //String sql = "insert into dept values(50,'教学部','北京')";
      String sql = "insert into dept values(50,'教学部','北京')";
      //int n = stmt.executeUpdate(sql);
      stmt.executeUpdate("update t_user set money = money - 2000 where userid = 'lisi'");
      stmt.executeUpdate("update t_user set money = money + 2000 where userid = 'zhangsan'");

      //事务成功结束
      conn.commit();

    } catch (SQLException e) {
      e.printStackTrace();

      //事务失败结束
      try {
        conn.rollback();
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    } finally {
      //6.关闭资源
      //stmt.close();
      //conn.close();
    }
  }

}
