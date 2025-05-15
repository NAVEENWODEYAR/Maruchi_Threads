package com.threads;

/**
 * @author NaveenWodeyar
 * @date 15-May-2025
 */

import java.util.concurrent.*;

public class CyclicBarrierExample {
    static final int THREADS = 300;

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(THREADS, () -> {
            System.out.println("All threads reached barrier. Proceeding...");
        });

        for (int i = 0; i < THREADS; i++) {
            final int id = i;
            new Thread(() -> {
                System.out.println("Thread " + id + " is doing work...");
                try {
                    Thread.sleep(1000 * id); // simulate different timings
                    System.out.println("Thread " + id + " waiting at barrier");
                    barrier.await();
                    System.out.println("Thread " + id + " passed barrier");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}

