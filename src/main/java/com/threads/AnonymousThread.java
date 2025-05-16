package com.threads;

/**
 * @author NaveenWodeyar
 * @date 16-May-2025
 */

public class AnonymousThread {
    public static void main(String[] args) {
        new Thread() {
            public void run() {
                System.out.println("Anonymous thread running!");
            }
        }.start();
    }
}
