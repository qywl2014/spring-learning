package com.wulang.imitate;

import com.wulang.imitate.annotation.MyComponentScan;
import com.wulang.imitate.annotation.MyConfiguration;
import com.wulang.imitate.bean.People;
import com.wulang.imitate.context.MyAnnotationConfigApplicationContext;

@MyConfiguration
@MyComponentScan("com.wulang")
public class Main {
    public static void main(String[] args) throws Exception {
        MyAnnotationConfigApplicationContext myAnnotationConfigApplicationContext=new MyAnnotationConfigApplicationContext(Main.class);
        People people=(People)myAnnotationConfigApplicationContext.getBean("people");
        people.hi();
    }
}

