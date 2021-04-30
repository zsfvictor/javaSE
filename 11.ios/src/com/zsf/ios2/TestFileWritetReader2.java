package com.zsf.ios2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class TestFileWritetReader2 {
    public static void main(String[] args) throws IOException {
        //1.创建流
        Reader fr = new FileReader("e:/readme.txt");
        FileWriter fw = new FileWriter("e:/readme2.txt",true);
        //2.使用流
        //2.1定义一个中转站
        int n;
        //2.2读一个字符
        n = fr.read();
//        while (n != -1){
//            //写一个字符
//            fw.write(n);
//            //再读一个字符
//            n = fr.read();
//        }

        char [] cbuf = new char[1024];
        int len = fr.read(cbuf);
        while (len != -1){
            fw.write(cbuf,0,len);
            //fw.write(cbuf);
            len = fr.read(cbuf);

        }
        //3.关闭流
        fr.close();
        fw.close();
    }


}
