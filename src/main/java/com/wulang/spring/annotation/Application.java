package com.wulang.spring.annotation;

import com.wulang.spring.annotation.beans.Dog;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Hello world!
 *
 */
@Configuration
@ComponentScan(basePackages = {"com.wulang"})
public class Application
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(Application.class);

        /*
        * AnnotationConfigApplicationContext extends GenericApplicationContext
        * GenericApplicationContext{
        *   private final DefaultListableBeanFactory beanFactory;
        * }
        * beanFacytory.getBean()
        *   -->
        * AbstractBeanFactory.getBean(String name)
        * DefaultSingletonBeanRegistry{
        *   private final Map<String, Object> singletonObjects = new ConcurrentHashMap<String, Object>(256);
        * }
        * */
        Dog dog=(Dog) applicationContext.getBean("dog");
        dog.eat();
    }

    @Test
    public void annotationTest(){
        // 会查找类的注解上的注解，一直往上找
        boolean result = AnnotatedElementUtils.isAnnotated(Dog.class, Component.class.getName());
        System.out.println(result);
    }
}
