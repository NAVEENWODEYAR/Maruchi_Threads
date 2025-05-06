package com.threads.sync;

/**
 * @author NaveenWodeyar
 * @date 06-May-2025
 */

class PrinterABC {
    private int state = 0;

    public synchronized void printA() throws InterruptedException {
        while (state % 3 != 0) wait();
        System.out.print("A");
        state++;
        notifyAll();
    }

    public synchronized void printB() throws InterruptedException {
        while (state % 3 != 1) wait();
        System.out.print("B");
        state++;
        notifyAll();
    }

    public synchronized void printC() throws InterruptedException {
        while (state % 3 != 2) wait();
        System.out.print("C");
        state++;
        notifyAll();
    }
}

public class PrintABC {
    public static void main(String[] args) {
        PrinterABC printer = new PrinterABC();
        Runnable printA = () -> {
            for (int i = 0; i < 5; i++) {
                try { printer.printA(); } catch (InterruptedException ignored) {}
            }
        };
        Runnable printB = () -> {
            for (int i = 0; i < 5; i++) {
                try { printer.printB(); } catch (InterruptedException ignored) {}
            }
        };
        Runnable printC = () -> {
            for (int i = 0; i < 5; i++) {
                try { printer.printC(); } catch (InterruptedException ignored) {}
            }
        };

        new Thread(printA).start();
        new Thread(printB).start();
        new Thread(printC).start();
    }
}

