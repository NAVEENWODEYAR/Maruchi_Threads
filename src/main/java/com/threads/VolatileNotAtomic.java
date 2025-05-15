package com.threads;

/**
 * @author NaveenWodeyar
 * @date 15-May-2025
 */

public class VolatileNotAtomic {
    private static volatile int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                count++;
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("Final Count: " + count);
    }
}

