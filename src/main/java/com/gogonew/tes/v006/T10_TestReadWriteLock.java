package com.gogonew.tes.v006;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class T10_TestReadWriteLock {

    static Lock lock = new ReentrantLock();
    private static int value;
    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static Lock readLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();

    public static void read(Lock lock){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(1);
            System.out.println("read Over"+value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void write(Lock lock,int i){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(1);
            value = i;
            System.out.println("write Over"+value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        //Runnable r1 = ()-> read(lock);
        Runnable r1 = () -> read(readLock);
        //Runnable r2 = ()->write(lock, new Random().nextInt());
        Runnable r2 = () -> write(writeLock, new Random().nextInt());
        for (int i = 0; i < 18; i++) {
            new Thread(r1,"r:"+i).start();
        }
        for (int i = 0; i < 2; i++) {
            new Thread(r2,"w:"+i).start();
        }
    }


}
