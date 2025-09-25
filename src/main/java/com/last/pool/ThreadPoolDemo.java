package com.last.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author NaveenWodeyar
 * @date 25-Sept-2025
 */

class WorkerTask implements Runnable {
    private final String taskName;

    public WorkerTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started: " + taskName);
        try {
            // Simulate work
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println("Task interrupted: " + taskName);
        }
        System.out.println(Thread.currentThread().getName() + " finished: " + taskName);
    }
}

public class ThreadPoolDemo {
    public static void main(String[] args) {
        // Create a thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit 6 tasks to the thread pool
        for (int i = 1; i <= 6; i++) {
            WorkerTask task = new WorkerTask("Task-" + i);
            executor.execute(task);
        }

        // Shut down the executor
        executor.shutdown();

        try {
            // Wait until all tasks are finished
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("All tasks completed.");
    }
}

