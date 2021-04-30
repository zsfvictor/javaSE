package com.zsf.poly1;

import com.zsf.poly0.Chinese;
import com.zsf.poly0.Progammer;
import com.zsf.poly0.sxtSchool;

public class Test {
    public static void main(String[] args) {
        Chinese ch = new Chinese();
        ch.eat();
        ch.writeCode();
        ch.taiji();
        System.out.println("---------");
        Progammer pro = new Chinese();
        pro.eat();
        pro.writeCode();
        Chinese pro1 = (Chinese) pro;
        pro1.taiji();
        Progammer pro2 = sxtSchool.getProgammer("cn");
        pro2.eat();
    }
}
