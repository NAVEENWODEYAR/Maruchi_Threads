package com.threads.communication;

/**
 * @author NaveenWodeyar
 * @date 05-May-2025
 */

class PingPong {
    private boolean pingTurn = true;

    public synchronized void ping() throws InterruptedException {
        while (!pingTurn) {
            wait();
        }
        System.out.println("Ping");
        pingTurn = false;
        notify();
    }

    public synchronized void pong() throws InterruptedException {
        while (pingTurn) {
            wait();
        }
        System.out.println("Pong");
        pingTurn = true;
        notify();
    }
}

public class PingPongDemo {
    public static void main(String[] args) {
        PingPong pp = new PingPong();

        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) pp.ping();
            } catch (InterruptedException e) {}
        });

        Thread t2 = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) pp.pong();
            } catch (InterruptedException e) {}
        });

        t1.start();
        t2.start();
    }
}
