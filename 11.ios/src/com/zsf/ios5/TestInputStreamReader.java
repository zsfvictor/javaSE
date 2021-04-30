package com.zsf.ios5;

import java.io.*;

/**
 *
 * 转换流:字节流变字符流
 * InputStreamReader
 * OutputStreamWriter
 *
 * 功能：读取来自键盘的数据，写入到硬盘文件中
 *
 * 设计模式：适配器模式（转换器）
 *
 * Reader------InputStreamReader-------InputStream
 * 三相插座         转换器                     两相插头
 */
public class TestInputStreamReader {
    public static void main(String[] args) throws IOException {
        //1.创建流
//        BufferedReader br = new BufferedReader(new FileReader("d:/readme.txt"));
        InputStream in = System.in;
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(isr);
        PrintWriter pw = new PrintWriter("d:/readme2.txt");

        //2.使用流
        String str = br.readLine();
        while (!"bye".equals(str)){
            //把当前行写到文件中
            pw.println(str);
            //再读一行
            str = br.readLine();
        }
        //3.关闭流
        br.close();
        pw.close();

    }
}
