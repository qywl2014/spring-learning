package com.wulang.spring.annotation.beans;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Dog {
    public void eat(){
        System.out.println("eating");
    }
}

