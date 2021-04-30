package com.zsf.ios1;

import java.io.*;

public class TestFileStream2 {
    public static void main(String[] args) throws IOException {
        //1.创建流
//        File file = new File("e:/readme.txt");
//        InputStream fis = new FileInputStream(file);
        InputStream fis = new FileInputStream(new File("e:/JDK_API_1_6_zh_CN.CHM"));
//        File file2 = new File("e:/readme2.txt");
//        FileOutputStream fos = new FileOutputStream(file2);
        OutputStream fos = new FileOutputStream(new File("e:/JDK_API_1_6_zh_CN2.CHM"));
        //2.使用流
        //2.1中转站（一个字节）
        byte [] buf = new byte[1024];
        int len = fis.read(buf);//输入流读取文件，将读取到的内容放进buf字节数组中，返回的是真正读取的字节数
        while (len != -1){//读到了数据，还没到末尾
            fos.write(buf,0,len);
            len = fis.read(buf);//读原文件,赋给n
        }
        //3.关闭流
        fis.close();
        fos.close();
    }
}
