package com.gogonew.design.pkg06;

/**
 * 指挥者：调用建造者中的方法完成复杂对象的创建
 */
public class Director {
    private Builder builder;
    public Director(Builder builder) {
        this.builder = builder;
    }

    public Product construct(){
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getProduct();
    }
}
