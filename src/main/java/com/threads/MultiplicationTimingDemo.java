package com.threads;

import java.util.concurrent.CountDownLatch;

/**
 * @author NaveenWodeyar
 * @date 23-Jan-2026
 */

class TableTask implements Runnable {
    private int number;
    private int multiplier;
    private CountDownLatch latch;

    TableTask(int number, int multiplier, CountDownLatch latch) {
        this.number = number;
        this.multiplier = multiplier;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            // Simulate 1 second task
            Thread.sleep(1000);

            System.out.println(
                Thread.currentThread().getName() + " → "
                + number + " x " + multiplier + " = "
                + (number * multiplier)
            );
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            latch.countDown(); // signal task completion
        }
    }
}

public class MultiplicationTimingDemo {
    public static void main(String[] args) throws InterruptedException {

        int number = 5;
        int totalThreads = 10;

        CountDownLatch latch = new CountDownLatch(totalThreads);

        long startTime = System.currentTimeMillis();

        // Start 10 threads simultaneously
        for (int i = 1; i <= totalThreads; i++) {
            new Thread(
                new TableTask(number, i, latch),
                "Thread-" + i
            ).start();
        }

        // Wait for all threads to finish
        latch.await();

        long endTime = System.currentTimeMillis();

        System.out.println("--------------------------------");
        System.out.println("Total Time Taken: "
                + (endTime - startTime) + " ms");
    }
}
