package com.amit.jpmorgan;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    private int count;
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(5);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(" t1 Thread : "+sem.availablePermits());
                try {
                    sem.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    sem.release();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(" t2 Thread : "+sem.availablePermits());
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(" t3 Thread : "+sem.availablePermits());
            }
        });Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(" t4 Thread : "+sem.availablePermits());

            }
        });
        Thread t5 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(" t5 Thread : "+sem.availablePermits());

            }
        });


    }
}
