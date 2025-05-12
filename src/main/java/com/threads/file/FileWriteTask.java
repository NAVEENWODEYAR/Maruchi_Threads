package com.threads.file;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author NaveenWodeyar
 * @date 10-May-2025
 */

class FileWriteTask implements Runnable {
    private final String fileName;
    private final String content;

    public FileWriteTask(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
    }

    @Override
    public void run() {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
            System.out.println("Written to " + fileName + " by " + Thread.currentThread().getName());
        } catch (IOException e) {
            System.err.println("Error writing to " + fileName);
            e.printStackTrace();
        }
    }
}
