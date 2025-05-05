package com.threads.communication;

/**
 * @author NaveenWodeyar
 * @date 05-May-2025
 */

class NumberPrinter {
    private boolean evenTurn = false;

    public synchronized void printEven(int number) throws InterruptedException {
        while (!evenTurn) {
            wait();
        }
        System.out.println("Even: " + number);
        evenTurn = false;
        notify();
    }

    public synchronized void printOdd(int number) throws InterruptedException {
        while (evenTurn) {
            wait();
        }
        System.out.println("Odd: " + number);
        evenTurn = true;
        notify();
    }
}

public class EvenOddDemo {
    public static void main(String[] args) {
        NumberPrinter printer = new NumberPrinter();

        Thread oddThread = new Thread(() -> {
            for (int i = 1; i <= 9; i += 2) {
                try {
                    printer.printOdd(i);
                } catch (InterruptedException e) {}
            }
        });

        Thread evenThread = new Thread(() -> {
            for (int i = 2; i <= 10; i += 2) {
                try {
                    printer.printEven(i);
                } catch (InterruptedException e) {}
            }
        });

        oddThread.start();
        evenThread.start();
    }
}
