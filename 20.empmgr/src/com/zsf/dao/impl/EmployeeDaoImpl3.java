package com.zsf.dao.impl;

import com.zsf.dao.EmployeeDao;
import com.zsf.entity.Employee;
import com.zsf.util.DButil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class EmployeeDaoImpl3 implements EmployeeDao {
  @Override
  public List<Employee> findAll() {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    List<Employee> list = new ArrayList<>();
    try {
      //2.建立和数据库的连接
      conn = DButil.getConnection();

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
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      //6.关闭资源
      DButil.closeAll(rs,stmt,conn);
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
      //2.建立和数据库的连接
      conn = DButil.getConnection();
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
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      //6.关闭资源
      DButil.closeAll(rs,stmt,conn);
    }
    return emp;
  }

  @Override
  public int save(Employee emp) {
    String sql = "insert into emp values(null,?,?,?,?,?,?,?)";
    Object [] params= {emp.getEname(),emp.getJob(),emp.getMgr(),new java.sql.Date(emp.getHireDate().getTime()),
        emp.getSal(),emp.getComm(),emp.getDeptno()};
    return DButil.executeUpdate(sql,params);
  }

  @Override
  public int update(Employee emp) {
    String sql = "update emp set job = ?,sal = ?,deptno = ? where empno = ?";
    Object [] params = {emp.getJob(),emp.getSal(),emp.getDeptno(),emp.getEmpno()};
    return DButil.executeUpdate(sql,params);
  }

  @Override
  public int delete(int empno) {
    return DButil.executeUpdate("delete from emp where empno = ?",new Object[]{empno});
  }
}
