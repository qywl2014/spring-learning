package com.wulang.spring.xml;

import com.wulang.spring.xml.domain.GenericFunction;
import com.wulang.spring.xml.domain.GenericFunctionFactoryBean;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BeanFactoryMain {
    public static void main(String[] args) {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("my-container.xml"));
        GenericFunction genericFunction1=(GenericFunction)beanFactory.getBean("1");
        System.out.println(genericFunction1.getA());
    }

    public static DefaultListableBeanFactory getBeanFactory(){
        ClassPathResource resource = new ClassPathResource("my-container.xml"); // <1>
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory(); // <2>
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory); // <3>
        reader.loadBeanDefinitions(resource);
        return factory;
    }

    @Test
    public void defaultListableBeanFactoryTest(){
        DefaultListableBeanFactory factory = getBeanFactory();

        GenericFunction genericFunction1=(GenericFunction)factory.getBean("1");
        System.out.println(genericFunction1.getA());

        GenericFunction myFactoryBean=(GenericFunction)factory.getBean("myFactoryBean");
        System.out.println(myFactoryBean.getA());

        GenericFunctionFactoryBean genericFunctionFactoryBean=factory.getBean(GenericFunctionFactoryBean.class);
        System.out.println(genericFunctionFactoryBean.getObjectType());
    }

    @Test
    public void testDependsOn(){
        DefaultListableBeanFactory factory = getBeanFactory();

        GenericFunction genericFunction1=(GenericFunction)factory.getBean("2");
        System.out.println(genericFunction1.getApple());
        System.out.println(genericFunction1.getOrange());
    }
}
