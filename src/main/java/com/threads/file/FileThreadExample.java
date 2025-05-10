package com.threads.file;

/**
 * @author NaveenWodeyar
 * @date 10-May-2025
 */

public class FileThreadExample {
    public static void main(String[] args) {
        String fileName = "example.txt";
        String content = "Hello from threaded file writing in Java!";

        FileWriteThread writer = new FileWriteThread(fileName, content);
        FileReadThread reader = new FileReadThread(fileName);

        writer.start();
        
        // Wait for writing to finish before reading
        try {
            writer.join();  // Ensures read starts after write completes
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        reader.start();
    }
}

