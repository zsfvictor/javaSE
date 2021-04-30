package com.zsf2;

import org.omg.PortableServer.ForwardRequest;
import sun.text.resources.cldr.ii.FormatData_ii;

import java.util.IllegalFormatCodePointException;

public class Test {
    public static void main(String[] args) {


        Person p = new Person();
        /*
        p.age = 10;
        p.name = "lili";
        p.height = 184.2;
         */

        Person LL = new Person(18,"lili",183.4);
        System.out.println(LL.age);
        System.out.println(LL.name);
        System.out.println(LL.height);
        p.eat();
        int sum = p.sleep(10,20);
        System.out.println(sum);

    }
}
