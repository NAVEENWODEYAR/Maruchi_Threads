package com.threads.sync;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author NaveenWodeyar
 * @date 01-May-2025
 */

public class SafeCounter {
    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementAndGet();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final count: " + counter.get()); // Should be 2000
    }
}

