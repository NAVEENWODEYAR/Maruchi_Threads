package com.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author NaveenWodeyar
 * @date 11-Jun-2025
 */

public class ThreadPoolExample {

    public static void main(String[] args) {
        // Create a thread pool with 5 threads
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Submit 10 tasks to the thread pool
        for (int i = 1; i <= 100; i++) {
            Runnable worker = new Task("Task " + i);
            executor.execute(worker);
        }

        // Shutdown the executor
        executor.shutdown();

        // Wait until all tasks are finished
        while (!executor.isTerminated()) {
        }

        System.out.println("All tasks finished.");
    }
}

// Task class implementing Runnable
class Task implements Runnable {

    private final String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is executing " + name);
        try {
            Thread.sleep(1000);  // simulate task taking some time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(name + " completed.");
    }
}
