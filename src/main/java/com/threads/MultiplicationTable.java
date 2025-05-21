package com.threads;

/**
 * @author NaveenWodeyar
 * @date 16-May-2025
 */

class MultiplicationTables extends Thread {
    private int number;

    public MultiplicationTables(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Multiplication Table of " + number + " (Thread: " + Thread.currentThread().getName() + ")");
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
            try {
                Thread.sleep(100); // Sleep to simulate thread execution and allow interleaving
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
        System.out.println("---- End of Table " + number + " ----\n");
    }
}

public class MultiplicationTable {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            MultiplicationTables table = new MultiplicationTables(i);
            table.start(); // Start each thread
        }
    }
}
