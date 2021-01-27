package com.gogonew.design.pkg02;

public class PrototypeClient {

    public static void main(String[] args) throws CloneNotSupportedException {
        Realizetype realizetype1 = new Realizetype();
        realizetype1.setName("1");
        final Realizetype clone = (Realizetype) realizetype1.clone();
        System.out.println(clone.getName()+"hashCode:"+realizetype1.hashCode()+"---"+clone.hashCode());
        System.out.println(realizetype1 == clone);
    }
}
