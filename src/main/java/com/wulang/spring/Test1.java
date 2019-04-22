package com.wulang.spring;

import com.wulang.spring.beans.Dog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Hello world!
 *
 */
@Configuration
@ComponentScan(basePackages = {"com.wulang"})
public class Test1
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(Test1.class);
        Dog dog=(Dog) applicationContext.getBean("dog");
        dog.eat();
    }
}
