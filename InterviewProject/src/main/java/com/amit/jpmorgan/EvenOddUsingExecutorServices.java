package com.amit.jpmorgan;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenOddUsingExecutorServices {

    private int count =1;
    private boolean odd;
    private final int MAX = 20;

    public static void main(String[] args) {

        EvenOddUsingExecutorServices eo = new EvenOddUsingExecutorServices();
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(new Runnable() {
            @Override
            public void run() {
                eo.printEven();
            }
        });
        service.execute(new Runnable() {
            @Override
            public void run() {
                eo.printOdd();
            }
        });
        System.out.println("main thread last line");
        service.shutdown();
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
            System.out.println("executor services even thread printing : "+ count);
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
            System.out.println("executor services odd thread printing : "+ count);
            odd = true;
            count++;
            notify();
        }

    }
}
