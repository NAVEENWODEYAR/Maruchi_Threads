package com.threads.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author NaveenWodeyar
 * @date 10-May-2025
 */

class FileReadTask implements Runnable {
    private final String fileName;

    public FileReadTask(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            System.out.println("Reading " + fileName + " by " + Thread.currentThread().getName());
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("[" + fileName + "]: " + line);
            }
        } catch (IOException e) {
            System.err.println("Error reading from " + fileName);
            e.printStackTrace();
        }
    }
}
