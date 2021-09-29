package com.zsf.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSelect {

  public static void main(String[] args) {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
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
      //String sql = "insert into dept values(50,'教学部','北京')";
      //String sql = "update dept set dname = '咨询部' where deptno = 50";
      String sql = "select * from emp";
      //int n = stmt.executeUpdate(sql);
      rs = stmt.executeQuery(sql);
      //5.处理结果
      System.out.println("编号\t姓名\t岗位\t上级编号\t入职时间\t薪水\t补助\t所属部门编号");
      while (rs.next()){
        //1.获取当前行各列的数据
//        int empno = rs.getInt(1);
//        String ename = rs.getString(2);
//        String job = rs.getString(3);
//        int mgr = rs.getInt(4);
//        Date hireDate = rs.getDate(5);
//        double sal = rs.getDouble(6);
//        double comm = rs.getDouble(7);
//        int deptno = rs.getInt(8);
        int empno = rs.getInt("empno");
        String ename = rs.getString("ename");
        String job = rs.getString("job");
        int mgr = rs.getInt("mgr");
        Date hireDate = rs.getDate("hireDate");
        double sal = rs.getDouble("sal");
        double comm = rs.getDouble("comm");
        int deptno = rs.getInt("deptno");
        //2.输出当前行各列的数据
        System.out.println(empno+"\t"+ename+"\t"+job+"\t"+mgr+"\t"+hireDate+"\t"+
            sal+"\t"+comm+"\t"+deptno);
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




  }

}
