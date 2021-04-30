package com.zsf.tcp.upload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 文件上传客户端
 */
public class UploadClient {
    public static void main(String[] args) throws IOException {
        //创建一个socket，指明服务器端IP和监听端口
        Socket socket = new Socket(InetAddress.getLocalHost(), 8800);

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("e:/503.zip"));
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
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
        System.out.println("END");
    }
}
