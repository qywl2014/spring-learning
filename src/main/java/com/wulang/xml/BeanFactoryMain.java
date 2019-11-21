package com.wulang.xml;

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

    @Test
    public void defaultListableBeanFactoryTest(){
        ClassPathResource resource = new ClassPathResource("my-container.xml"); // <1>
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory(); // <2>
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory); // <3>
        reader.loadBeanDefinitions(resource);
        GenericFunction genericFunction1=(GenericFunction)factory.getBean("1");
        System.out.println(genericFunction1.getA());
    }
}
