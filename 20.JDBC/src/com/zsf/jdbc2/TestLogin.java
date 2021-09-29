package com.zsf.jdbc2;

import entity.Emp;
import entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 模拟淘宝登录的功能
 */
public class TestLogin {
  /**
   * 前台
   */
  public static void main(String[] args) {
    //1.输入用户名和密码
    Scanner input = new Scanner(System.in);
    System.out.println("请输入用户名");
    String userId = input.next();
    System.out.println("请输入密码");
    String passWord = input.next();
    //2.调用后台判断登录是否成功并返回结果给前台
    User user = login(userId,passWord);
    //3.在前台输入结果
    if (user == null){
      System.out.println("登录失败");

    }else{
      System.out.println("登录成功，欢迎"+user.getRealName());
    }

  }


  public static User login(String userId, String passWord){
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    User user2 = null;//默认登录失败
    try{
      String driver = "com.mysql.cj.jdbc.Driver";
      String url = "jdbc:mysql://127.0.0.1:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
      String user = "root";
      String password = "bb520520bb";
      //1.加载驱动
      Class.forName(driver);
      //2.建立连接
      conn = DriverManager.getConnection(url,user,password);
      //System.out.println(conn);
      //3.创建一个SQL命令发送器
      stmt = conn.createStatement();

      //4.准备一个SQL命令，并使用SQL命令发送器发送过去，并返回结果
      String sql = "select * from t_user where userid = '"+userId+
          "' and password = '"+passWord+"'";
      System.out.println(sql);
      //int n = stmt.executeUpdate(sql);
      rs = stmt.executeQuery(sql);
      //5.处理结果(将result封装到一个list中)
      if (rs.next()){
        //获取当前行各个字段的值
        //String userId = rs.getInt("empno");
        String realName = rs.getString("realName");
        //String password = rs.getString("password");
        double money = rs.getDouble("money");
        //将当前各个字段的值，封装到一个Emp对象中
        user2 = new User(userId,realName,passWord,money);
      }

    }catch (SQLException | ClassNotFoundException e){
      e.printStackTrace();
    }finally {
      //6.关闭资源
      try {
        if (rs != null){
          rs.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
      try {
        if(stmt != null){
          stmt.close();
        }

      } catch (SQLException e) {
        e.printStackTrace();
      }
      try {
        if(conn != null){
          conn.close();
        }

      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return user2;
  }

}



