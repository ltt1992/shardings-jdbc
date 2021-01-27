package com.gogonew.tes.c005;

public class T implements Runnable {

    private /*volatile*/ int count = 10;

    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {
        T t = new T();
        for(int i=0; i<10; i++) {
            new Thread(t, "THREAD" + i).start();
        }
    }

}
