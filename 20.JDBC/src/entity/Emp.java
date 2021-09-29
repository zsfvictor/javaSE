package entity;

import java.util.Date;

/**
 * 员工类
 * Emp类对应emp表
 * Emp类的成员变量对应emp表的各个字段
 * Emp类的一个对象对应emp表的一条记录
 */
public class Emp {
  private int empno;
  private String ename;
  private String job;
  private int mgr;
  private Date hireDate;
  private double sal;
  private double comm;
  private int deptno;

  public Emp() {
  }

  public Emp(int empno, String ename, String job, int mgr, Date hireDate, double sal, double comm,
      int deptno) {
    this.empno = empno;
    this.ename = ename;
    this.job = job;
    this.mgr = mgr;
    this.hireDate = hireDate;
    this.sal = sal;
    this.comm = comm;
    this.deptno = deptno;
  }

  public int getEmpno() {
    return empno;
  }

  public String getEname() {
    return ename;
  }

  public String getJob() {
    return job;
  }

  public int getMgr() {
    return mgr;
  }

  public Date getHireDate() {
    return hireDate;
  }

  public double getSal() {
    return sal;
  }

  public double getComm() {
    return comm;
  }

  public int getDeptno() {
    return deptno;
  }

  public void setEmpno(int empno) {
    this.empno = empno;
  }

  public void setEname(String ename) {
    this.ename = ename;
  }

  public void setJob(String job) {
    this.job = job;
  }

  public void setMgr(int mgr) {
    this.mgr = mgr;
  }

  public void setHireDate(Date hireDate) {
    this.hireDate = hireDate;
  }

  public void setSal(double sal) {
    this.sal = sal;
  }

  public void setComm(double comm) {
    this.comm = comm;
  }

  public void setDeptno(int deptno) {
    this.deptno = deptno;
  }

  @Override
  public String toString() {
    return "Emp{" +
        "empno=" + empno +
        ", ename='" + ename + '\'' +
        ", job='" + job + '\'' +
        ", mgr=" + mgr +
        ", hireDate=" + hireDate +
        ", sal=" + sal +
        ", comm=" + comm +
        ", deptno=" + deptno +
        '}';
  }
}
