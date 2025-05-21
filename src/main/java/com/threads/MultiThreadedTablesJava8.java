/**
 * @author NaveenWodeyar
 * @date 16-May-2025
 */
package com.threads;

import java.util.stream.IntStream;

public class MultiThreadedTablesJava8 {
    public static void main(String[] args) {

        // Use IntStream to iterate from 1 to 10
        IntStream.rangeClosed(1, 10).forEach(n -> {
            // Create a thread using a lambda expression (Runnable)
            Thread thread = new Thread(() -> {
                System.out.println("Multiplication Table of " + n + " (Thread: " + Thread.currentThread().getName() + ")");
                IntStream.rangeClosed(1, 10).forEach(i -> {
                    System.out.println(n + " x " + i + " = " + (n * i));
                    try {
                        Thread.sleep(100); // simulate delay
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
                System.out.println("---- End of Table " + n + " ----\n");
            });

            thread.start();
        });
    }
}

