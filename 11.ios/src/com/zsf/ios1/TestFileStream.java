package com.zsf.ios1;

import java.io.*;

public class TestFileStream {
    public static void main(String[] args) throws IOException {
        //1.创建流
//        File file = new File("e:/readme.txt");
//        InputStream fis = new FileInputStream(file);
        InputStream fis = new FileInputStream(new File("e:/readme.txt"));
//        File file2 = new File("e:/readme2.txt");
//        FileOutputStream fos = new FileOutputStream(file2);
        OutputStream fos = new FileOutputStream(new File("e:/readme2.txt"));
        //2.使用流
        //2.1中转站（一个字节）
        int n;
        n = fis.read();//读原文件的一个字节,赋给n
        while (n>0){//读到了数据，还没到末尾
            fos.write(n);
            n = fis.read();//读原文件的一个字节,赋给n
        }
        //3.关闭流
        fis.close();
        fos.close();
    }
}
