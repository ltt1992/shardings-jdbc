package com.gogonew.tes.c003;

public class T {

    private int count = 10;

    public synchronized void m1(){
        count--;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " count = " + count);
        m2();
    }

    public synchronized void m2(){
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {
        T t = new T();
        t.m1();
        //t.m2();
    }
}
