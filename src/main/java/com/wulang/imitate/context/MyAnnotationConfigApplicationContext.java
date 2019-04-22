package com.wulang.imitate.context;

import com.wulang.imitate.annotation.MyAutowired;
import com.wulang.imitate.annotation.MyComponent;
import com.wulang.imitate.annotation.MyComponentScan;
import com.wulang.imitate.annotation.MyConfiguration;
import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.*;

public class MyAnnotationConfigApplicationContext {


    private List<String> beanList=new ArrayList<>();

    private Map<String,Object> beanNameObjectMap=new HashMap<>(16);

    public MyAnnotationConfigApplicationContext(Class<?> annotatedClass) throws Exception{

        if(!annotatedClass.isAnnotationPresent(MyConfiguration.class)){
            System.out.println("缺少@MyConfiguration注解");
            return;
        }
        if(!annotatedClass.isAnnotationPresent(MyComponentScan.class)){
            System.out.println("缺少@MyComponentScan注解");
            return;
        }
        MyComponentScan myComponentScan=annotatedClass.getAnnotation(MyComponentScan.class);
        String basePackage=myComponentScan.value();
        basePackage=basePackage.replace('.','/');
        getFileSet(basePackage);
        for(String str:beanList){
            Class<?> cazz=Class.forName(str);
            if(cazz.isAnnotationPresent(MyComponent.class)){
                beanNameObjectMap.put(firstUpperToLower(cazz.getSimpleName()),cazz.newInstance());
            }
        }
        for(Map.Entry<String,Object> entry:beanNameObjectMap.entrySet()){
            Field[] fields=entry.getValue().getClass().getDeclaredFields();
            for(Field field:fields){
                field.setAccessible(true);
                if(field.isAnnotationPresent(MyAutowired.class)){
                    String beanName=field.getType().getSimpleName();
                    Object autowiredBean=beanNameObjectMap.get(firstUpperToLower(beanName));
                    field.set(entry.getValue(),autowiredBean);
                }
            }
        }
    }

    private String firstUpperToLower(String str){
        char[] chars=str.toCharArray();
        chars[0]=(char)(chars[0]+32);
        return String.valueOf(chars);
    }

    private void getFileSet(String basePackage) throws Exception{
        URL url=Thread.currentThread().getContextClassLoader().getResource(basePackage);
        File file=new File(url.getFile());
        if(file.isDirectory()){
            File[] files=file.listFiles();
            for(File item:files){
                getFileSet(basePackage+"/"+item.getName());
            }
        }else{
            if(file.getName().endsWith(".class")){
                beanList.add(basePackage.replace('/','.').replace(".class",""));
            }
        }
    }

    public Object getBean(String beanName){
        return beanNameObjectMap.get(beanName);
    }
}

