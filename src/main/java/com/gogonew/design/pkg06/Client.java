package com.gogonew.design.pkg06;

public class Client {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        final Product product = director.construct();
        product.show();
    }
}
