package com.zsf.ios4;

import java.io.*;
import java.util.Date;

public class TestObjectStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //write();
        read();
    }

    public static void write() throws IOException {
        OutputStream os = new FileOutputStream("d:/readme.txt");
        BufferedOutputStream bos = new BufferedOutputStream(os);
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        oos.writeInt(10);
        oos.writeUTF("com.zsf");
        oos.writeObject(new Date());
        oos.writeObject(new Student(1,"lili",12,56.6));
        oos.close();
    }

    public static void read() throws IOException, ClassNotFoundException {
        InputStream is = new FileInputStream("d:/readme.txt");
        BufferedInputStream bis = new BufferedInputStream(is);
        ObjectInputStream ois = new ObjectInputStream(bis);

        System.out.println(ois.readInt());
        System.out.println(ois.readUTF());
        Object obj = ois.readObject();
        System.out.println(obj);
        Student stu = (Student)ois.readObject();
        System.out.println(stu.getAge());

        ois.close();

    }
}
