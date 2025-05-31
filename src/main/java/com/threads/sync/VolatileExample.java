package com.threads.sync;

/**
 * @author NaveenWodeyar
 * @date 31-May-2025
 */

public class VolatileExample {
    private volatile String message;

    public static void main(String[] args) {
        VolatileExample example = new VolatileExample();

        Thread writer = new Thread(() -> {
            example.message = "Hello from thread!";
        });

        Thread reader = new Thread(() -> {
            while (example.message == null) {
                // Wait until message is not null
            }
            System.out.println("Message received: " + example.message);
        });

        writer.start();
        reader.start();
    }
}
