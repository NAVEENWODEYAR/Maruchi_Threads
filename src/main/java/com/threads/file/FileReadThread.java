package com.threads.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author NaveenWodeyar
 * @date 10-May-2025
 */

class FileReadThread extends Thread {
    private String fileName;

    public FileReadThread(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("Contents of " + fileName + ":");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

