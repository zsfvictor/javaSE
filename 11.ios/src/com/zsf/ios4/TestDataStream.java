package com.zsf.ios4;

import java.io.*;

public class TestDataStream {
    public static void main(String[] args) throws IOException {
        write();
        read();
    }

    public static void write() throws IOException {
        OutputStream os = new FileOutputStream("d:/readme.txt");
        BufferedOutputStream bos = new BufferedOutputStream(os);
        DataOutputStream dos = new DataOutputStream(bos);

        dos.writeInt(10);
        dos.writeUTF("com.zsf");
        dos.close();
    }

    public static void read() throws IOException {
        InputStream is = new FileInputStream("d:/readme.txt");
        BufferedInputStream bis = new BufferedInputStream(is);
        DataInputStream dis = new DataInputStream(bis);

        System.out.println(dis.readInt());
        System.out.println(dis.readUTF());

        dis.close();

    }
}
