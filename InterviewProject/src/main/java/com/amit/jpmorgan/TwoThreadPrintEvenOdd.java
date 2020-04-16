package com.amit.jpmorgan;

public class TwoThreadPrintEvenOdd {
    private int count = 1;
    private boolean odd;
    private final int MAX =20;
    //static Object lock = new Object();

    public static void main(String[] args) {

        final TwoThreadPrintEvenOdd resource = new TwoThreadPrintEvenOdd();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
               resource.printEven();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                resource.printOdd();
            }
        });
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized void printEven() {
        while(count < MAX) {
            while(!odd) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(" even thread printing : "+ count);
            odd = false;
            count++;
            notify();
        }
    }

    public synchronized void printOdd() {
        while(count < MAX) {
            while(odd) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(" odd thread printing : "+ count);
            odd = true;
            count++;
            notify();
        }

    }
}


class PrintThreadOdd extends Thread {

    public void run() {

    }

}

class PrintThreadEven extends Thread {

    TwoThreadPrintEvenOdd source;

    public void run() {

    }

}