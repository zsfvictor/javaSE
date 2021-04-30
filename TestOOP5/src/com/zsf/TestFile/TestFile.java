package com.zsf.TestFile;

import java.io.File;
import java.io.IOException;

public class TestFile {
    public static void main(String[] args) {
        File file = new File("e:/sxt/ai/readme.txt");
        if (file.exists()){
            file.delete();
        }else {
            File dir = file.getParentFile();
            if (!dir.exists()){
                dir.mkdirs();
            }
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
