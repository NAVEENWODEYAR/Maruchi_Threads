package com.threads;

/**
 * @author NaveenWodeyar
 * @date 26-Apr-2025
 */

class ChatClientHandler implements Runnable {
    private final String username;

    public ChatClientHandler(String username) {
        this.username = username;
    }

    @Override
    public void run() {
        System.out.println(username + " is connected.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}
        System.out.println(username + " received new message.");
    }

    public static void main(String[] args) {
        new Thread(new ChatClientHandler("Alice")).start();
        new Thread(new ChatClientHandler("Bob")).start();
    }
}
