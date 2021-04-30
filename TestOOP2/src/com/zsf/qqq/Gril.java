package com.zsf.qqq;

public class Gril {
    private int age;

    //读取年龄
    public int loadAge(){
        return age;
    }
    //设置年龄
    public void setAge(int age){
        if(age>18) {
            this.age = 18;
        }else {
            this.age = age;
        }
    }

}
