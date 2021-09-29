package com.zsf.jdbc;

import entity.Emp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestSelect2 {

  /**
   * 前台
   * 返回结果集resultset到前台不可取
   * @param args
   */
  public static void main(String[] args) {
    //调用后台获取结果
    List<Emp> list = findAll();

    //在前台输出结果
    System.out.println("编号\t姓名\t岗位\t上级编号\t入职时间\t薪水\t补助\t所属部门编号");
    for (Emp emp :list){
      System.out.println(emp.getEmpno()+"\t"+emp.getEname()+"\t"+emp.getJob()+
          "\t"+emp.getMgr()+"\t"+emp.getSal()+"\t"+emp.getComm()+"\t"+emp.getDeptno());

    }
  }

  /**
   * 后台
   */
  public static List<Emp> findAll(){
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    List<Emp> list = new ArrayList<Emp>();
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
      //5.处理结果(将result封装到一个list中)
      while (rs.next()){
        //获取当前行各个字段的值
        int empno = rs.getInt("empno");
        String ename = rs.getString("ename");
        String job = rs.getString("job");
        int mgr = rs.getInt("mgr");
        Date hireDate = rs.getDate("hireDate");
        double sal = rs.getDouble("sal");
        double comm = rs.getDouble("comm");
        int deptno = rs.getInt("deptno");
        //将当前各个字段的值，封装到一个Emp对象中
        Emp emp = new Emp(empno,ename,job,mgr,hireDate,sal,comm,deptno);
        //将EMP对象添加到集合中
        list.add(emp);
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
    return list;
  }

}
