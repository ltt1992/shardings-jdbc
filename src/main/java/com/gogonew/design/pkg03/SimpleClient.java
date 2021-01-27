package com.gogonew.design.pkg03;

public class SimpleClient {
    public static void main(String[] args) {
        final Product product = SimpleFactory.getProduct(Const.PRODUCT_A);
        System.out.println(product.getClass());
    }
}
