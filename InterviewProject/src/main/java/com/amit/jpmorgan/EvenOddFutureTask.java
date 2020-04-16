package com.amit.jpmorgan;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class EvenOddFutureTask {
    private int count =1;
    private boolean odd;
    private final int MAX =20;
    public static void main(String[] args) {
        EvenOddFutureTask  ft = new EvenOddFutureTask();
        ExecutorService service = Executors.newFixedThreadPool(2);
        FutureTask<String> ft1 = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                ft.printEven();
                return "task 1 successful";

            }
        });
        FutureTask<String> ft2 = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                ft.printOdd();
                return "task 2 successful";

            }
        });
        service.execute(ft1);
        service.execute(ft2);
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
            System.out.println("future task even printing thread :"+ count);
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
            System.out.println("future task odd printing thread :"+ count);
            odd = true;
            count++;
            notify();
        }
    }
}
