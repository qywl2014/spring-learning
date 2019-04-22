package com.wulang.imitate.bean;


import com.wulang.imitate.annotation.MyAutowired;
import com.wulang.imitate.annotation.MyComponent;

@MyComponent
public class Cat {
    @MyAutowired
    private Dog dog;

    public void hi(){
        dog.bark();
        System.out.println("I am cat");
    }
}

