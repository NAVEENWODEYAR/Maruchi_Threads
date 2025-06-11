package com.threads;

import java.util.concurrent.*;

/**
 * @author NaveenWodeyar
 * @date 11-Jun-2025
 */

public class CustomThreadPoolExample {

    public static void main(String[] args) {
        int corePoolSize = 3;
        int maxPoolSize = 6;
        long keepAliveTime = 10;
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(10);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            corePoolSize, maxPoolSize, keepAliveTime,
            TimeUnit.SECONDS, queue, new ThreadPoolExecutor.CallerRunsPolicy()
        );

        for (int i = 1; i <= 15; i++) {
            executor.execute(new Task("Custom Task " + i));
        }

        executor.shutdown();
    }
}
