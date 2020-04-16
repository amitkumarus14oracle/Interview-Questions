package com.amit.jpmorgan;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class BoundedArrayList<T> {
    private List<T> list ;
    private Semaphore sem;

    public BoundedArrayList(int limit) {
        list = new ArrayList<T>();
        sem = new Semaphore(limit);
    }

    public void add(T element) {
        try {
            sem.acquire();
            list.add(element);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            sem.release();
        }
    }

    public boolean remove(T element) {
        sem.release();
        return list.remove(element);
    }

    public static void main(String[] args) {
        BoundedArrayList bal = new BoundedArrayList(5);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(" t1 Thread : "+bal.sem.availablePermits());
                bal.add("Amit");
                System.out.println(" t1 Thread "+bal.list);
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(" t2 Thread : "+bal.sem.availablePermits());
                bal.add("Amit1");
                System.out.println(" t2 Thread "+bal.list);
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(" t3 Thread : "+bal.sem.availablePermits());
                bal.add("Amit2");
                System.out.println(" t3 Thread "+bal.list);
            }
        });Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(" t4 Thread : "+bal.sem.availablePermits());
                bal.add("Amit3");
                System.out.println(" t4 Thread "+bal.list);
            }
        });
        Thread t5 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(" t5 Thread : "+bal.sem.availablePermits());
                bal.add("Amit4");
                System.out.println(" t5 Thread "+bal.list);
            }
        });
        Thread t6 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(" t6 Thread : "+bal.sem.availablePermits());
                bal.add("Amit5");
                System.out.println(" t6 Thread "+bal.list);
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}
