package com.zsf.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * class Properties extends Hashtable<Object,Object> 一种map存储键值对
 *
 * key，value 都是string
 *
 * 建议使用 setproperty getProperty 而不是put get
 *
 * 写 key-value到属性文件
 *    OutputStream os = new FileOutputStream("d:/jdbc.properties");
 *     prop.store(os,"jdbc connection parameter");
 * 读属性文件中内容到prop中
 *    InputStream is = new FileInputStream("d:/jdbc.properties");
 *     prop.load(is);
 *
 * 读取项目中的属性文件
 *     InputStream is = TestProperties.class.getResourceAsStream("/db.properties");
 *     prop.load(is);
 */
public class TestProperties {

  public static void main(String[] args) throws IOException {
    Properties prop = new Properties();
    //prop.setProperty("driver","com.mysql.cj.jdbc.Driver");
    //prop.setProperty("user","root");
    //prop.setProperty("password","bb520520bb");
    //写 key-value到属性文件
    //OutputStream os = new FileOutputStream("d:/jdbc.properties");
    //prop.store(os,"jdbc connection parameter");
    //读属性文件中内容到prop中
    //System.out.println(prop);
    //InputStream is = new FileInputStream("d:/jdbc.properties");
    //prop.load(is);
    System.out.println(prop);

    //读取项目中的属性文件
    InputStream is = TestProperties.class.getResourceAsStream("/db.properties");
    prop.load(is);
    System.out.println(prop);

  }

}
