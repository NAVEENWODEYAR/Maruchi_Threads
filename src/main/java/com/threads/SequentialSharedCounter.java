package com.threads;

/**
 * @author NaveenWodeyar
 * @date 01-May-2025
 */

public class SequentialSharedCounter {
    private static int counter = 1; // Shared counter
    private static final int MAX = 500;

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis(); // Start timing

        Thread[] threads = new Thread[100];

        for (int i = 0; i < 100; i++) {
            int threadId = i + 1;
            threads[i] = new Thread(() -> {
                while (true) {
                    int task;
                    synchronized (SequentialSharedCounter.class) {
                        if (counter > MAX) break;
                        task = counter++;
                    }
                    System.out.println("Thread " + threadId + " processing task: " + task);
                    try {
                        Thread.sleep(100); // Simulate work per task
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            threads[i].start();
        }

        // Wait for all threads to complete
        for (Thread t : threads) {
            t.join();
        }

        long endTime = System.currentTimeMillis(); // End timing

        System.out.println("All 500 tasks completed.");
        System.out.println("Total time taken (ms): " + (endTime - startTime));
        System.out.println("Total time taken (seconds): " + ((endTime - startTime) / 1000.0));
    }
}

