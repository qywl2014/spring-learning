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
}
