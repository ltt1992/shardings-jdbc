package com.gogonew.design.pkg06;

/**
 * 抽象建造者：包含创建产品各个子部件的抽象方法
 */
abstract class Builder {
    protected Product product = new Product();
    public abstract void buildPartA();
    public abstract void buildPartB();
    public abstract void buildPartC();

    public Product getProduct(){
        return product;
    }
}
