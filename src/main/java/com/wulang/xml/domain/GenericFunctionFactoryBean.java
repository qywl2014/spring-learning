package com.wulang.xml.domain;

import org.springframework.beans.factory.FactoryBean;

public class GenericFunctionFactoryBean implements FactoryBean<GenericFunction> {
    @Override
    public GenericFunction getObject() throws Exception {
        return new GenericFunction("aa", "bb");
    }

    @Override
    public Class<?> getObjectType() {
        return GenericFunction.class;
    }
}
