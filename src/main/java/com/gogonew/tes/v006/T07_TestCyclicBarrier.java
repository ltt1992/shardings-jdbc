package com.gogonew.tes.v006;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class T07_TestCyclicBarrier {
    public static void main(String[] args) {
        //CyclicBarrier barrier = new CyclicBarrier(20);

        CyclicBarrier barrier = new CyclicBarrier(20, () -> System.out.println("ÂúÈË"));

        /*CyclicBarrier barrier = new CyclicBarrier(20, new Runnable() {
            @Override
            public void run() {
                System.out.println("ÂúÈË£¬·¢³µ");
            }
        });*/

        for(int i=0; i<100; i++) {
            int finalI = i;
            new Thread(()->{
                try {
                    System.out.println(finalI);
                    //调用await()方法计数加1，若加1后的值不等于构造方法的值，则线程阻塞
                    barrier.await();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }
}