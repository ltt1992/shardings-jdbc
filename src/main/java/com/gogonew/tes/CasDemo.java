package com.gogonew.tes;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class CasDemo {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private static CountDownLatch countDownLatch = new CountDownLatch(100);

    public static void main(String[] args) throws InterruptedException {
       /* Long t1 = System.currentTimeMillis();
        atomic();
        countDownLatch.await();
        System.out.println(atomicInteger.get());
        System.out.println(System.currentTimeMillis()-t1);

        System.out.println(sum(10));*/
        final short a = 30;
        byte b = a;
        System.out.println(b);

    }

    public static int sum(int i){
        if(i == 1){
            return 1;
        }
        return sum(i-1)+i;
    }


    public static void atomic(){
        for (int i = 0; i < 100; i++) {
            new MyThread(atomicInteger,countDownLatch).start();
        }
    }
}

class MyThread extends Thread {

    private AtomicInteger atomicInteger;
    private CountDownLatch countDownLatch;

    public MyThread (AtomicInteger atomicInteger, CountDownLatch countDownLatch){
        this.atomicInteger = atomicInteger;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (int j = 0; j < 10; j++) {
            atomicInteger.incrementAndGet();
        }
        countDownLatch.countDown();
    }
}
