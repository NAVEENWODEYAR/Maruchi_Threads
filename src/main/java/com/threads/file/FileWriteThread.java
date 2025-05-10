package com.threads.file;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author NaveenWodeyar
 * @date 10-May-2025
 */

class FileWriteThread extends Thread {
    private String fileName;
    private String content;

    public FileWriteThread(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
    }

    @Override
    public void run() {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
            System.out.println("Write complete: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
