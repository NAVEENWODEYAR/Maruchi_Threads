package com.threads.file;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author NaveenWodeyar
 * @date 10-May-2025
 */

public class ExecutorFileExample {
    public static void main(String[] args) {
        String[] files = {"file1.txt", "file2.txt", "file3.txt"};
        String[] contents = {
            "Content of file 1 from ExecutorService.",
            "ExecutorService writes file 2 here.",
            "This is file 3 via thread pool."
        };

        // Create a fixed thread pool with 4 threads
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Submit file write tasks
        for (int i = 0; i < files.length; i++) {
            executor.submit(new FileWriteTask(files[i], contents[i]));
        }

        // Gracefully shutdown executor for write tasks
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        // New executor for read tasks
        ExecutorService readExecutor = Executors.newFixedThreadPool(3);
        for (String file : files) {
            readExecutor.submit(new FileReadTask(file));
        }

        readExecutor.shutdown();
    }
}
