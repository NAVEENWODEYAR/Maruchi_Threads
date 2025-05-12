package com.threads.file;

/**
 * @author NaveenWodeyar
 * @date 10-May-2025
 */

public class MultiFileThreadExample {
    public static void main(String[] args) {
        String[] files = {"file1.txt", "file2.txt", "file3.txt"};
        String[] contents = {
            "This is file 1 written by a thread.",
            "File 2 has different content.",
            "Thread writing file 3 here!"
        };

        Thread[] writers = new Thread[files.length];
        Thread[] readers = new Thread[files.length];

        // Start all write threads
        for (int i = 0; i < files.length; i++) {
            writers[i] = new FileWriteThread(files[i], contents[i]);
            writers[i].start();
        }

        // Wait for all writes to finish before reading
        for (Thread writer : writers) {
            try {
                writer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Start all read threads
        for (int i = 0; i < files.length; i++) {
            readers[i] = new FileReadThread(files[i]);
            readers[i].start();
        }
    }
}

