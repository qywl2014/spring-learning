package com.wulang.xml;

public class GenericFunction {
    private String a;
    private String b;
    private String c;
    public GenericFunction(String a){
        this.a=a;
    }
    public GenericFunction(String a,String b){
        this.a=a;
        this.b=b;
    }
    public GenericFunction(String a,String b,String c){
        this.a=a;
        this.b=b;
        this.c=c;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }
}

