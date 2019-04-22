package com.wulang.imitate.bean;

import com.wulang.imitate.annotation.MyAutowired;
import com.wulang.imitate.annotation.MyComponent;

@MyComponent
public class People {

    @MyAutowired
    private Cat cat;

    public void hi(){
        if(cat==null){
            System.out.println("cat null");
        }else{
            cat.hi();
        }
        System.out.println("I am People");
    }
}

