package com.zsf.ios2;

import java.io.*;

public class TestFileWritetReader {
    public static void main(String[] args) throws IOException {
        //1.创建流
        Reader fr = new FileReader("e:/readme.txt");
        FileWriter fw = new FileWriter("e:/readme2.txt");
        //2.使用流
        //2.1定义一个中转站
        int n;
        //2.2读一个字符
        n = fr.read();
        while (n != -1){
            //写一个字符
            fw.write(n);
            //再读一个字符
            n = fr.read();
        }

        //3.关闭流
        fr.close();
        fw.close();
    }


}
