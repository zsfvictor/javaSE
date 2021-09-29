package com.zsf.dao.impl;

import com.zsf.dao.EmployeeDao;
import com.zsf.entity.Employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class EmployeeDaoImpl implements EmployeeDao {

  @Override
  public List<Employee> findAll() {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    List<Employee> list = new ArrayList<>();
    try {
      String driver = "com.mysql.cj.jdbc.Driver";
      String url = "jdbc:mysql://127.0.0.1:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
      String user = "root";
      String password = "bb520520bb";
      //1.加载驱动
      Class.forName(driver);

      //2.建立和数据库的连接
      conn = DriverManager.getConnection(url, user, password);

      //3.创建一个SQL命令发射器
      stmt = conn.createStatement();

      //4.准备好SQL语句，通过发射器发送到数据库并得到结果
      String sql = "select * from emp";
      rs = stmt.executeQuery(sql);

      //5.处理结果（封装到list中）

      while (rs.next()){
        //1.将当前行各列的值取出来
        int empno = rs.getInt("empno");
        String ename = rs.getString("ename");
        String job = rs.getString("job");
        int mgr = rs.getInt("mgr");
        Date hireDate = rs.getDate("hireDate");
        double sal = rs.getDouble("sal");
        double comm = rs.getDouble("comm");
        int deptno = rs.getInt("deptno");
        //2.将当前行的各列行的取出来的值封装到一个Employee对象中
        Employee emp = new Employee(empno,ename,job,mgr,hireDate,sal,comm,deptno);
        //3.将对象Employee对象添加到list中
        list.add(emp);
      }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
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
    return list;
  }

  @Override
  public Employee findById(int empno) {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    Employee emp = null;//查询不到
    try {
      String driver = "com.mysql.cj.jdbc.Driver";
      String url = "jdbc:mysql://127.0.0.1:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
      String user = "root";
      String password = "bb520520bb";
      //1.加载驱动
      Class.forName(driver);

      //2.建立和数据库的连接
      conn = DriverManager.getConnection(url, user, password);

      //3.创建一个SQL命令发射器
      stmt = conn.createStatement();

      //4.准备好SQL语句，通过发射器发送到数据库并得到结果
      String sql = "select * from emp where empno ="+empno;
      rs = stmt.executeQuery(sql);

      //5.处理结果（封装到list中）

      if (rs.next()){
        //1.将当前行各列的值取出来
        //int empno = rs.getInt("empno");
        String ename = rs.getString("ename");
        String job = rs.getString("job");
        int mgr = rs.getInt("mgr");
        Date hireDate = rs.getDate("hireDate");
        double sal = rs.getDouble("sal");
        double comm = rs.getDouble("comm");
        int deptno = rs.getInt("deptno");
        //2.将当前行的各列行的取出来的值封装到一个Employee对象中
        emp = new Employee(empno,ename,job,mgr,hireDate,sal,comm,deptno);

      }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
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
    return emp;
  }

  @Override
  public int save(Employee emp) {

    return 0;
  }

  @Override
  public int update(Employee emp) {
    return 0;
  }

  @Override
  public int delete(int empno) {
    return 0;
  }
}
