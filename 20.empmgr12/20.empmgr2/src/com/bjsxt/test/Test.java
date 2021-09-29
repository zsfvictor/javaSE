package com.bjsxt.test;

import com.bjsxt.dao.EmployeeDao;
import com.bjsxt.dao.impl.EmployeeDaoImpl;
import com.bjsxt.entity.Employee;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/***
 * 前台
 */
public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        do{
            System.out.println("");
            System.out.println("*****欢迎进入员工管理系统*****");
            System.out.println("\t1.查询所有员工信息");
            System.out.println("\t2.查询指定编号员工");
            System.out.println("\t3.添加员工信息");
            System.out.println("\t4.修改员工信息");
            System.out.println("\t5.删除员工信息");
            System.out.println("\t6.退出");
            System.out.println("***************************");
            System.out.print("请选择菜单：");

            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    findAll();
                    break;
                case 2:
                    findById();
                    break;

                case 3:
                    save();
                    break;
                case 4:
                    update();
                    break;
                case 5:
                    delete();
                    break;
                case 6:
                    System.out.println("谢谢使用");
                    return;
                default:
                    System.out.println("输入错误");
            }
            System.out.println("请输入任意键继续");
            //input.next();
            input.nextLine();
            input.nextLine();
        }while(true);

    }
    public static void delete(){
        //从键盘输入要删除的员工编号
        Scanner input = new Scanner(System.in);
       System.out.println("请输入员工编号");
        int  empno =  input.nextInt();
        //调用后台完成添加操作并返回结果
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        int n = employeeDao.delete(empno);
        //输出结果
        if(n>0){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
    }
    public static void update(){
        //从键盘输入要修改的员工信息
        Scanner input = new Scanner(System.in);
        System.out.println("请输入员工岗位");
        String  job =  input.next();
        System.out.println("请输入员工薪水");
        double  sal =  input.nextDouble();
        System.out.println("请输入员工部门编号");
        int  deptno =  input.nextInt();
        System.out.println("请输入员工编号");
        int  empno =  input.nextInt();
        //调用后台完成添加操作并返回结果
        Employee emp = new Employee(empno,job,sal,deptno);
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        int n = employeeDao.update(emp);
        //输出结果
        if(n>0){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
    }
    public static void save(){
        //从键盘输入要添加的员工信息
        Scanner input = new Scanner(System.in);
        System.out.println("请输入员工姓名");
        String  ename =  input.next();
        System.out.println("请输入员工岗位");
        String  job =  input.next();
        System.out.println("请输入员工上级编号");
        int  mgr =  input.nextInt();
        System.out.println("请输入员工入职时间(yyyy-MM-dd)");
        String sdate = input.next(); //"1999-12-23"

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date hireDate = null;
        try {
            hireDate = sdf.parse(sdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("请输入员工薪水");
        double  sal =  input.nextDouble();
        System.out.println("请输入员工津贴");
        double  comm =  input.nextDouble();
        System.out.println("请输入员工部门编号");
        int  deptno =  input.nextInt();
        //调用后台完成添加操作并返回结果
        Employee emp = new Employee(ename, job, mgr, hireDate,
                sal, comm, deptno);
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        int n = employeeDao.save(emp);
        //输出结果
        if(n>0){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
    }


    public static void findById(){
        //从键盘输入员工编号
        Scanner input = new Scanner(System.in);
        System.out.println("请输入员工编号");
        int empno =input.nextInt();
        //调用后台获取指定编号员工
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        Employee emp = employeeDao.findById(empno);

        //在前台输出员工列表
        if(emp == null){
            System.out.println("查无此人");
        }else{
            System.out.println("编号\t姓名\t岗位\t上级编号\t入职时间\t薪水\t补助\t所属部门编号");
            System.out.println(emp.getEmpno()+"\t"+emp.getEname()+"\t"+emp.getJob()+
                    "\t"+emp.getMgr()+"\t"+emp.getHireDate()+
                    "\t"+emp.getSal()+"\t"+emp.getComm()+"\t"+emp.getDeptno());
        }

    }

    /**
     * 查询所有员工的前台
     */
    public static void findAll(){
        //调用后台获取员工列表
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        List<Employee> empList = employeeDao.findAll();

        //在前台输出员工列表
        System.out.println("编号\t姓名\t岗位\t上级编号\t入职时间\t薪水\t补助\t所属部门编号");
        for(Employee emp:empList){
            System.out.println(emp.getEmpno()+"\t"+emp.getEname()+"\t"+emp.getJob()+
                    "\t"+emp.getMgr()+"\t"+emp.getHireDate()+
                    "\t"+emp.getSal()+"\t"+emp.getComm()+"\t"+emp.getDeptno());
        }
    }
}
