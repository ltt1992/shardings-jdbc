package com.gogonew.design.pkg04;

public class ConcreteFactory1 implements AbstractFactory{
    @Override
    public Product newProduct() {
        return new ConcreteProduct1();
    }
}
