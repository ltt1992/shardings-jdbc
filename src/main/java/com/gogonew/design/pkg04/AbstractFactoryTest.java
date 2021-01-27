package com.gogonew.design.pkg04;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = new ConcreteFactory1();
        abstractFactory.newProduct().show();

        AbstractFactory abstractFactory2 = new ConcreteFactory2();
        abstractFactory2.newProduct().show();
    }
}
