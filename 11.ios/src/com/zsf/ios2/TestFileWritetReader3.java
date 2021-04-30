package com.zsf.ios2;

import java.io.*;

public class TestFileWritetReader3 {
    public static void main(String[] args) throws IOException {
        Reader fr = null;
        FileWriter fw = null;
        try{
            //1.创建流
            fr = new FileReader("e:/readme.txt");
            fw = new FileWriter("e:/readme2.txt",true);
            char [] cbuf = new char[1024];
            int len = fr.read(cbuf);
            while (len != -1){
                fw.write(cbuf,0,len);
                len = fr.read(cbuf);

            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fr != null){
                    //3.关闭流
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fw != null){
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }



    }


}
