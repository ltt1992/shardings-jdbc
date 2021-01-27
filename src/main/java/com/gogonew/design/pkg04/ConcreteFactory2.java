package com.gogonew.design.pkg04;

public class ConcreteFactory2 implements AbstractFactory{
    @Override
    public Product newProduct() {
        return new ConcreteProduct2();
    }
}
