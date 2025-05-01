package com.threads;

/**
 * @author NaveenWodeyar
 * @date 01-May-2025
 */

public class LambdaThreadExample {
    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            int id = i;
            Thread t = new Thread(() -> {
                for (int j = 1; j <= 3; j++) {
                    System.out.println("Lambda Thread " + id + " - Count: " + j);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted: " + e);
                    }
                }
            });
            t.start();
        }
    }
}

