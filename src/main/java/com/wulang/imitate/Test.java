package com.wulang.imitate;

import java.io.File;
import java.net.URL;
import java.util.Enumeration;

public class Test {
    public static void main(String[] args) throws Exception{
        Enumeration<URL> enumeration=Thread.currentThread().getContextClassLoader().getResources("com/wulang");
        if(enumeration.hasMoreElements()){
            URL url=enumeration.nextElement();
            File file=new File(url.getFile());
            if(!file.exists()){
                System.out.println("not exist");
            }
            if(!file.canRead()){
                System.out.println("can not read");
            }
            System.out.println("ok");

        }
    }
}

