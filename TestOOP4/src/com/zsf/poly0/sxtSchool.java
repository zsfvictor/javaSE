package com.zsf.poly0;

public class sxtSchool {
    public static Progammer getProgammer(String type){
        Progammer pro = null;
        if ("cn".equals(type)){
            pro = new Chinese();
        }else if ("en".equals(type)){
            pro = new English();
        }
            return pro;


    }
}
