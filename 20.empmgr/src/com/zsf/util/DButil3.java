package com.zsf.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 数据库访问工具类
 */
public abstract class DButil3 {
    private DButil3(){

    }

  static String driver = "";
  static String url = "";
  static String user = "";
  static String password = "";

    static {
      //创建Properties对象
      Properties prop = new Properties();

      //读取属性文件
      InputStream is = DButil3.class.getResourceAsStream("/db.properties");
      try {
        prop.load(is);
      } catch (IOException e) {
        e.printStackTrace();
      }
      //根据key获取values
      driver = prop.getProperty("driver");
      url = prop.getProperty("url");
      user = prop.getProperty("user");
      password = prop.getProperty("pwd");
    }

  /**
   * 获取数据库连接
   * @return
   */
    public static Connection getConnection(){


      Connection conn = null;
      try {
        //1.加载驱动
        Class.forName(driver);
        //2.建立和数据库的连接
        conn = DriverManager.getConnection(url, user, password);
      } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
      }
      return conn;
    }

  /**
   * 关闭各种资源
   */
  public static void closeAll(ResultSet rs, Statement stmt,Connection conn){
    //6.关闭资源
    try {
      if (rs != null){
        rs.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    try {
      if (stmt != null){
        stmt.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    try {
      if (conn != null){
        conn.close();
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * 完成DML操作：insert、update和delete操作
   * @param sql
   * @param params
   * @return
   */
  public static int executeUpdate(String sql,Object [] params) {

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    int n = 0;//添加失败
    try {
      //2.建立和数据库的连接
      conn = DButil3.getConnection();
      //3.创建一个SQL命令发射器
      pstmt = conn.prepareStatement(sql);

      //4.准备好SQL语句，通过发射器发送到数据库并得到结果
      for (int i = 0; i < params.length; i++) {
        pstmt.setObject(i+1,params[i]);
      }
      n = pstmt.executeUpdate();
      System.out.println(n);
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      //6.关闭资源
      DButil3.closeAll(rs,pstmt,conn);
    }
    return n;
  }

}