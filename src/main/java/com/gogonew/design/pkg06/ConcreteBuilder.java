package com.gogonew.design.pkg06;

/**
 * 具体建造者：实现了抽象建造者接口
 */
public class ConcreteBuilder extends Builder{
    @Override
    public void buildPartA() {
        product.setPartA("build partA");
    }

    @Override
    public void buildPartB() {
        product.setPartB("build partB");
    }

    @Override
    public void buildPartC() {
        product.setPartC("build partC");
    }


}
