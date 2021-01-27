package com.gogonew.design.pkg01;

public class LazySingClient {

    public static void main(String[] args) {
        /*for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(LazySingleton.getInstance().hashCode())).start();
        }*/

        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(HungrySingleton.getInstance().hashCode())).start();
        }
    }
}
