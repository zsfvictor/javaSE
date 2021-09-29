package com.zsf.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;


/**
 * 连接池
 */
public class ConnectionPool {

  /**
   * 存放多个数据库的连接
   * 获取连接：出队  删除 删除第一个
   * 关闭连接：入队  添加 添加到末尾
   * 建议使用linklist
   */
  private static LinkedList<Connection> list = new LinkedList<Connection>();

  /**
   * 第一次加载类的实现执行一次，就执行这一次
   */

  static {
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://127.0.0.1:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
    String user = "root";
    String password = "bb520520bb";

    try {
      //1.加载驱动
      Class.forName(driver);
      for (int i = 0; i < 10; i++) {
        //2.建立和数据库的连接
        Connection conn = newConnection();
        list.addLast(conn);
      }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

  }

  /**
   * 创建一个新连接
   * @return
   */
  public static Connection newConnection(){

    String url = "jdbc:mysql://127.0.0.1:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
    String user = "root";
    String password = "bb520520bb";
    Connection conn = null;
    try {
      conn = DriverManager.getConnection(url, user, password);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return  conn;
  }
  /**
   * 从连接池拿一个连接
   * @return
   */
  public Connection getConnection(){
    if (list.size()>0){
      return list.removeFirst();
    }else {
      return newConnection();
    }

  }

  /**
   * 数据库连接使用完毕，放回连接池
   *
   */
  public void returnConnection(Connection conn){
    if (list.size()<10){
      list.addLast(conn);
    }else {//连接池满了，直接关闭
      try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

}
