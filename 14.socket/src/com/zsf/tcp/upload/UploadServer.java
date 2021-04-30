package com.zsf.tcp.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 文件上传，服务器端
 */
public class UploadServer {
    public static void main(String[] args) throws IOException {
        //1.创建一个ServerSocket
        ServerSocket serverSocket = new ServerSocket(8800);
        //2.使用ServerSocket在指定的端口监听
        Socket socket = serverSocket.accept();

        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("e:/503(2).zip"));
        //使用流
        //准备一个中转站
        byte[] buf = new byte[1024];
        //先读一个字节
        int len = bis.read(buf);//读原文件的一个字节赋予给n
        while (len != -1){
            //写一个字节
            bos.write(buf,0,len);
            //再读一个字节
            len = bis.read(buf);
        }
        //关闭流
        bis.close();
        bos.close();
    }
}
