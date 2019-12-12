package com.wulang.spring.xml;

import com.wulang.spring.xml.domain.GenericFunction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("my-container.xml");
        GenericFunction genericFunction1=(GenericFunction)applicationContext.getBean("1");
        GenericFunction genericFunction2=(GenericFunction)applicationContext.getBean("2");
        System.out.println(genericFunction1.getA());
        System.out.println(genericFunction2.getA());
    }

}

