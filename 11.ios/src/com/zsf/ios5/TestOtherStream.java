package com.zsf.ios5;

import java.io.*;

public class TestOtherStream {
    public static void main(String[] args) {
        //1.节点流 ：直接和数据源相邻 必不可少
        FileInputStream fis; //file
        FileOutputStream fos;

        ByteArrayInputStream bais; // 字节数组
        ByteArrayOutputStream baos;
        //2.处理流：对节点流或者处理流进行包装处理，可以提高性能，简化操作
        BufferedInputStream bis;
        BufferedOutputStream bos;
        DataInputStream dis;
        DataOutputStream dos;
        PrintStream ps;
    }
}
