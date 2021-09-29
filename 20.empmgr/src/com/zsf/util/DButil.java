package com.zsf.util;

import com.zsf.entity.Employee;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 * 数据库访问工具类
 */
public abstract class DButil {
  //定义一个日志记录器
  private static Logger logger = Logger.getLogger(DButil.class.getName());

  //在合适的位置使用日志记录器


    private DButil(){

    }

  static String driver = "";
  static String url = "";
  static String user = "";
  static String password = "";

    static {
      //创建Properties对象
      Properties prop = new Properties();

      //读取属性文件
      InputStream is = DButil.class.getResourceAsStream("/db.properties");
      try {
        prop.load(is);
        logger.info("正确读取了jdbc.properties"+prop);
      } catch (IOException e) {
        e.printStackTrace();
        logger.error("读取JDBC.properties文件出错：");
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
        logger.error("建立数据库连接失败"+e.toString());
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
        logger.debug("关闭结果集成功");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    try {
      if (stmt != null){
        stmt.close();
        logger.debug("关闭statement成功");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    try {
      if (conn != null){
        conn.close();
        logger.debug("关闭了数据库连接");
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
      conn = DButil.getConnection();
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
      logger.error("执行DML操作失败："+e);
    } finally {
      //6.关闭资源
      DButil.closeAll(rs,pstmt,conn);
    }
    return n;
  }

}