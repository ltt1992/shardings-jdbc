package com.gogonew.design.pkg03;

public class SimpleFactory {

    public static Product getProduct(int kind){
        switch (kind) {
            case Const.PRODUCT_A:
                return new ConcreteProduct1();
            case Const.PRODUCT_B:
                return new ConcreteProduct2();
            default:
                System.out.println("无对应类型");
        }
        return null;
     }
}
